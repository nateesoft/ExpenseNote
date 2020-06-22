package sun.natee.app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;
import sun.natee.app.AppConstants;
import sun.natee.app.main.util.AppUI;
import sun.natee.app.main.util.MsgUtil;

public class Database {

    private static Connection conn = null;
    private static final Logger logger = Logger.getLogger(Database.class);

    public static Connection getConnect() {
        if (conn == null) {
            try {
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
                conn = DriverManager.getConnection("jdbc:derby:" + AppUI.DATA_DB + ";create=true;user=app;password=app");
//                conn = DriverManager.getConnection("jdbc:derby:" + AppUI.DATA_DB + ";upgrade=true;user=app;password=app");
                return conn;
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            }
        }

        return conn;
    }

    public static boolean isTableExists(String tableName) throws SQLException {
        return Database.getConnect().getMetaData().getTables(null, null, tableName.toUpperCase(), null).next();
    }

    public static boolean dropTable(String tableName) throws SQLException {
        return Database.getConnect().createStatement().execute("drop table " + tableName);
    }

    public static boolean execute(String sql) throws SQLException {
        return Database.getConnect().createStatement().execute(sql);
    }

    public static void initTable(String tableName) {
        Statement stmt;
        try {
            stmt = Database.getConnect().createStatement();
            String sql;
            if (tableName.equalsIgnoreCase(AppConstants.TABLE_EXPENSE)) {
                sql = "CREATE TABLE " + tableName + " ("
                        + "id INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                        + "date date, "
                        + "time varchar(10), "
                        + "incomeAmt decimal(10,2), "
                        + "outcomeAmt decimal(10,2), "
                        + "totalAmt decimal(10,2), "
                        + "descript varchar(250), "
                        + "username varchar(150), "
                        + "place varchar(150) "
                        + ")";
                if (!isTableExists(tableName)) {
                    logger.debug(sql);
                    stmt.execute(sql);
                    MsgUtil.printLog("create table " + tableName + " already.");
                }
            } else if (tableName.equalsIgnoreCase(AppConstants.TABLE_POPUP_DESC)) {
                sql = "CREATE TABLE " + tableName + " ("
                        + "id INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                        + "item_desc varchar(255), "
                        + "item_type varchar(100) "
                        + ")";
                if (!isTableExists(tableName)) {
                    logger.debug(sql);
                    stmt.execute(sql);
                    MsgUtil.printLog("create table " + tableName + " already.");
                }
            } else if (tableName.equalsIgnoreCase(AppConstants.TABLE_SCHEDULE)) {
                sql = "CREATE TABLE " + tableName + " ("
                        + "id INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                        + "item_desc varchar(255), "
                        + "item_type varchar(100), "
                        + "month_date varchar(20), "
                        + "year_date varchar(20), "
                        + "end_month varchar(50), "
                        + "holidy_skip varchar(50), "
                        + "month_at int, "
                        + "before_deadline varchar(1), "
                        + "is_success varchar(1) "
                        + ")";
                if (!isTableExists(tableName)) {
                    logger.debug(sql);
                    stmt.execute(sql);
                    MsgUtil.printLog("create table " + tableName + " already.");
                }
            }

            stmt.close();
        } catch (SQLException ex) {
            MsgUtil.printLog(ex.getMessage());
        }
    }

    public static void close() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException ex) {
            }
        }
    }
}
