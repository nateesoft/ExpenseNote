package sun.natee.app.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import sun.natee.app.AppConstants;
import sun.natee.app.bean.Expense;
import sun.natee.app.dao.BaseDao;
import sun.natee.app.db.Database;
import sun.natee.app.main.util.MsgUtil;
import sun.natee.app.main.util.StringUtil;

public class ExpenseDaoImpl implements BaseDao<Expense, Integer> {

    private final Logger logger = Logger.getLogger(ExpenseDaoImpl.class);
    private final String table = AppConstants.TABLE_EXPENSE;

    @Override
    public void init() {
        Database.initTable(table);
    }

    @Override
    public int save(Expense bean) throws SQLException {
        if (isUpdate(bean)) {
            return update(bean);
        }

        String sql = "insert into " + table + ""
                + "(date, time, descript, incomeAmt, outcomeAmt, totalAmt, username, place) "
                + "values('" + StringUtil.dateToDb(bean.getDate()) + "', '" + bean.getTime() + "', '" + bean.getDesc() + "', "
                + bean.getIncomeAmt() + "," + bean.getOutcomeAmt() + "," + bean.getTotalAmt() + ","
                + "'" + bean.getUser() + "','" + bean.getPlace() + "')";
        MsgUtil.printLog(sql);
        logger.debug(sql);
        return Database.getConnect().createStatement().executeUpdate(sql);
    }

    @Override
    public int update(Expense bean) throws SQLException {
        String sql = "update " + table + " set "
                + "date='" + StringUtil.dateToDb(bean.getDate()) + "', "
                + "time='" + bean.getTime() + "', "
                + "descript='" + bean.getDesc() + "', "
                + "incomeAmt=" + bean.getIncomeAmt() + ", "
                + "outcomeAmt=" + bean.getOutcomeAmt() + ", "
                + "totalAmt=" + bean.getTotalAmt() + ", "
                + "username='" + bean.getUser() + "', "
                + "place='" + bean.getPlace() + "' "
                + "where id=" + bean.getId() + "";
        MsgUtil.printLog(sql);
        logger.debug(sql);
        return Database.getConnect().createStatement().executeUpdate(sql);
    }

    @Override
    public Expense findById(Integer id) throws SQLException {
        String sql = "SELECT * FROM " + table + " where id = " + id;
        logger.debug(sql);
        try (ResultSet rs = Database.getConnect().createStatement().executeQuery(sql)) {
            if (rs.next()) {
                return mapping(rs, new Expense());
            }
        }

        return null;
    }

    @Override
    public List<Expense> findAll() throws SQLException {
        List<Expense> listShop = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " order by id";
        logger.debug(sql);
        try (ResultSet rs = Database.getConnect().createStatement().executeQuery(sql)) {
            while (rs.next()) {
                listShop.add(mapping(rs, new Expense()));
            }
        }

        return listShop;
    }

    public List<Expense> findAll(Date date) throws SQLException {
        List<Expense> listShop = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " where date='" + StringUtil.dateToDb(date) + "' order by id";
        logger.debug(sql);
        try (ResultSet rs = Database.getConnect().createStatement().executeQuery(sql)) {
            while (rs.next()) {
                listShop.add(mapping(rs, new Expense()));
            }
        }

        return listShop;
    }

    public List<Expense> findAll(Date date1, Date date2) throws SQLException {
        List<Expense> listShop = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " "
                + "where date between '" + StringUtil.dateToDb(date1) + "' and '" + StringUtil.dateToDb(date2) + "' "
                + "order by id";
        logger.debug(sql);
        try (ResultSet rs = Database.getConnect().createStatement().executeQuery(sql)) {
            while (rs.next()) {
                listShop.add(mapping(rs, new Expense()));
            }
        }

        return listShop;
    }

    @Override
    public Expense mapping(ResultSet rs, Expense bean) throws SQLException {
        bean.setId(rs.getInt("id"));
        bean.setDate(rs.getDate("date"));
        bean.setTime(rs.getString("time"));
        bean.setDesc(rs.getString("descript"));
        bean.setIncomeAmt(rs.getBigDecimal("incomeAmt"));
        bean.setOutcomeAmt(rs.getBigDecimal("outcomeAmt"));
        bean.setTotalAmt(rs.getBigDecimal("totalAmt"));
        bean.setUser(rs.getString("username"));
        bean.setPlace(rs.getString("place"));

        return bean;
    }

    @Override
    public int delete(Integer id) throws SQLException {
        String sql;
        if (id == null) {
            sql = "delete from " + table + "";
            logger.debug(sql);
            return Database.getConnect().createStatement().executeUpdate(sql);
        }
        sql = "delete from " + table + " where id=" + id;
        logger.debug(sql);
        return Database.getConnect().createStatement().executeUpdate(sql);
    }

    @Override
    public boolean isUpdate(Expense bean) throws SQLException {
        boolean isExist = false;
        String sql = "SELECT id FROM " + table + " where id=" + bean.getId() + "";
        logger.debug(sql);
        try (ResultSet rs = Database.getConnect().createStatement().executeQuery(sql)) {
            if (rs.next()) {
                isExist = true;
            }
        }

        return isExist;
    }

    @Override
    public void dropTable() {
        try {
            Database.dropTable(table);
        } catch (SQLException ex) {
            MsgUtil.showMsg(ex.getMessage(), null);
        }
    }

}
