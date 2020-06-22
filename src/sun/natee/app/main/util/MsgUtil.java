package sun.natee.app.main.util;

import javax.swing.JOptionPane;

public class MsgUtil {

    public static final int MSG_TYPE_NORMAL = 1;
    public static final int MSG_TYPE_WAR = 2;
    public static final int MSG_TYPE_ERROR = 3;

    public static final String ERROR_MSG_VALID_01 = "กรุณากรอกข้อมูลให้ครบถ้วน";

    public static void showMsg(String msg, String type) {
        if (type == null) {
            JOptionPane.showMessageDialog(null, msg);
        }
    }

    public static void printLog(String log) {
        System.out.println(log);
    }

    public static boolean confirmMsg(String msg) {
        int confirm = JOptionPane.showConfirmDialog(null, msg);
        return confirm == JOptionPane.YES_OPTION;
    }
}
