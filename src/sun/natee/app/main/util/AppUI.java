package sun.natee.app.main.util;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import sun.natee.app.dao.impl.ExpenseDaoImpl;
import sun.natee.app.dao.impl.PopupDescDaoImpl;
import sun.natee.app.dao.impl.ScheduleDaoImpl;
import sun.natee.app.main.Main;

public class AppUI {

    public static String DATA_DB = "data";

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.put("OptionPane.messageFont", new Font("Tahoma", Font.PLAIN, 14));
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
        }

        Properties prop = new Properties();
        try {
            if (new File("config.txt").exists()) {
                prop.load(new FileInputStream(new File("config.txt")));
                DATA_DB = prop.getProperty("db");
                if (DATA_DB == null && DATA_DB.equals("")) {
                    DATA_DB = "data";
                }
            }
        } catch (IOException e) {
            DATA_DB = "data";
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                // create table to derby database
                new ExpenseDaoImpl().init();
                new PopupDescDaoImpl().init();
                new ScheduleDaoImpl().init();

                Main dialog = new Main(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {                        
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }

        });
    }

    public static void dropAllTable() {
        new ExpenseDaoImpl().dropTable();
        new PopupDescDaoImpl().dropTable();
        new ScheduleDaoImpl().dropTable();
    }
}
