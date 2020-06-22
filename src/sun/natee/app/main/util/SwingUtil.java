package sun.natee.app.main.util;

import javax.swing.table.DefaultTableModel;

public class SwingUtil {
    
    public static void clearModel(DefaultTableModel model){
        int size = model.getRowCount();
        for (int i = 0; i < size; i++) {
            model.removeRow(0);
        }
    }
}
