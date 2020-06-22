package sun.natee.app.main;

import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;
import sun.natee.app.bean.PopupDesc;
import sun.natee.app.main.util.UXUtil;

public class PopupListDialog extends javax.swing.JDialog {

    private static final Logger logger = Logger.getLogger(PopupListDialog.class);
    private DefaultTableModel model = null;
    private String desc = null;

    public PopupListDialog(java.awt.Frame parent, boolean modal, List<PopupDesc> listPopup) {
        super(parent, modal);
        initComponents();

        UXUtil.initTable(tableData);
        UXUtil.alignTable(tableData, 0, SwingConstants.CENTER);
        UXUtil.alignTable(tableData, 2, SwingConstants.CENTER);

        model = (DefaultTableModel) tableData.getModel();
        for (PopupDesc bean : listPopup) {
            model.addRow(new Object[]{
                bean.getId(),
                bean.getItemDesc(),
                bean.getItemType()
            });
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableData = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("แสดงประเภทรายการ");
        setResizable(false);

        tableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "รหัส", "รายการ", "ประเภท"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableData);
        if (tableData.getColumnModel().getColumnCount() > 0) {
            tableData.getColumnModel().getColumn(1).setPreferredWidth(250);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tableDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDataMouseClicked
        if (evt.getClickCount() == 2) {
            int iSel = tableData.getSelectedRow();
            if (iSel != -1) {
                setDesc("" + tableData.getValueAt(iSel, 1));
                dispose();
            }
        }
    }//GEN-LAST:event_tableDataMouseClicked

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableData;
    // End of variables declaration//GEN-END:variables
}
