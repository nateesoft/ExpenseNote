package sun.natee.app.main.util;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UXUtil {

    public static void alignTable(JTable table, int colsAt, int swingConstants) {
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(swingConstants);
        table.getColumnModel().getColumn(colsAt).setCellRenderer(render);
    }

    public static void initTable(JTable table) {
        JTableHeader tHead = table.getTableHeader();
        tHead.setFont(new Font("Tahoma", Font.BOLD, 12));
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table.setRowHeight(25);
    }
    
    public static void exportData(JTable tableData, JDialog dialog) {
        dialog.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        String FILE_NAME = "output.xlsx";

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Data");
        int rowNum = 0;
        System.out.println("Creating excel");

        //font style
        XSSFCellStyle myStyle = workbook.createCellStyle();
        XSSFFont myFont = workbook.createFont();
        myFont.setFontName("Tahoma");
        myFont.setColor(HSSFFont.COLOR_NORMAL);
        myFont.setBold(true);
        myStyle.setFont(myFont);

        String[] dataColumns = getTableColumns(tableData);
        int colNum1 = 0;
        Row row = sheet.createRow(rowNum);
        for (String col : dataColumns) {
            Cell cell = row.createCell(colNum1++);
            cell.setCellValue((String) col);
            cell.setCellStyle(myStyle);
        }

        rowNum++;

        Object[][] datatypes = getTableData(tableData);
        for (Object[] datatype : datatypes) {
            row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);

                try {
                    String data = field.toString().replace(",", "");
                    double a = Double.parseDouble(data);
                    cell.setCellValue((Double) a);
                } catch (NumberFormatException e) {
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    } else if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    } else if (field instanceof Double) {
                        cell.setCellValue((Double) field);
                    }
                }

            }
        }

        //freeze pane
        sheet.createFreezePane(0, 1);

        try {
            try (FileOutputStream outputStream = new FileOutputStream(FILE_NAME)) {
                workbook.write(outputStream);
            }
        } catch (FileNotFoundException e) {
            MsgUtil.showMsg(e.getMessage(), null);
        } catch (IOException e) {
            MsgUtil.showMsg(e.getMessage(), null);
        }

        dialog.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

        try {
            Desktop.getDesktop().open(new File(FILE_NAME));
        } catch (IOException e) {
            MsgUtil.showMsg(e.getMessage(), null);
        }
    }

    static String[] getTableColumns(JTable tb) {
        String colName = "";
        for (int i = 0; i < tb.getColumnCount(); i++) {
            colName += tb.getColumnName(i) + ",";
        }

        return colName.split(",");
    }

    static Object[][] getTableData(JTable tableData) {
        DefaultTableModel dtm = (DefaultTableModel) tableData.getModel();
        int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
        Object[][] tDataObj = new Object[nRow][nCol];
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                tDataObj[i][j] = dtm.getValueAt(i, j);
            }
        }
        return tDataObj;
    }
}
