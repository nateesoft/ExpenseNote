package sun.natee.app.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import sun.natee.app.AppConstants;
import sun.natee.app.bean.Schedule;
import sun.natee.app.dao.BaseDao;
import sun.natee.app.db.Database;
import sun.natee.app.main.util.MsgUtil;

public class ScheduleDaoImpl implements BaseDao<Schedule, Integer> {

    private final Logger logger = Logger.getLogger(ScheduleDaoImpl.class);
    private final String table = AppConstants.TABLE_SCHEDULE;

    @Override
    public void init() {
        Database.initTable(table);
    }

    @Override
    public int save(Schedule bean) throws SQLException {
        if (isUpdate(bean)) {
            return update(bean);
        }

        String sql = "insert into " + table + ""
                + "(item_desc,item_type,month_date,"
                + "year_date,end_month,holidy_skip,"
                + "month_at,before_deadline,is_success) "
                + "values("
                + "'" + bean.getItem_desc() + "','" + bean.getItem_type() + "','" + bean.getMonth_date() + "',"
                + "'" + bean.getYear_date() + "','" + bean.getEnd_month() + "','" + bean.getHolidy_skip() + "',"
                + "" + bean.getMonth_at() + ",'" + bean.getBefore_deadline() + "', '" + bean.getChkSuccess() + "')";
        MsgUtil.printLog(sql);
        logger.debug(sql);
        return Database.getConnect().createStatement().executeUpdate(sql);
    }

    @Override
    public int update(Schedule bean) throws SQLException {
        String sql = "update " + table + " set "
                + "item_desc='" + bean.getItem_desc() + "',"
                + "item_type='" + bean.getItem_type() + "',"
                + "month_date='" + bean.getMonth_date() + "',"
                + "year_date='" + bean.getYear_date() + "',"
                + "end_month='" + bean.getEnd_month() + "',"
                + "holidy_skip='" + bean.getHolidy_skip() + "',"
                + "month_at=" + bean.getMonth_at() + ","
                + "before_deadline='" + bean.getBefore_deadline() + "', "
                + "is_success='" + bean.getChkSuccess() + "' "
                + "where id=" + bean.getId() + "";
        MsgUtil.printLog(sql);
        logger.debug(sql);
        return Database.getConnect().createStatement().executeUpdate(sql);
    }

    @Override
    public Schedule findById(Integer id) throws SQLException {
        String sql = "SELECT * FROM " + table + " where id = " + id;
        logger.debug(sql);
        try (ResultSet rs = Database.getConnect().createStatement().executeQuery(sql)) {
            if (rs.next()) {
                return mapping(rs, new Schedule());
            }
        }

        return null;
    }

    @Override
    public List<Schedule> findAll() throws SQLException {
        List<Schedule> listShop = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " order by id";
        logger.debug(sql);
        try (ResultSet rs = Database.getConnect().createStatement().executeQuery(sql)) {
            while (rs.next()) {
                listShop.add(mapping(rs, new Schedule()));
            }
        }

        return listShop;
    }

    @Override
    public Schedule mapping(ResultSet rs, Schedule bean) throws SQLException {
        bean.setId(rs.getInt("id"));
        bean.setItem_desc(rs.getString("item_desc"));
        bean.setItem_type(rs.getString("item_type"));
        bean.setMonth_date(rs.getString("month_date"));
        bean.setYear_date(rs.getString("year_date"));
        bean.setEnd_month(rs.getString("end_month"));
        bean.setHolidy_skip(rs.getString("holidy_skip"));
        bean.setMonth_at(rs.getInt("month_at"));
        bean.setBefore_deadline(rs.getString("before_deadline"));
        bean.setChkSuccess(rs.getString("is_success"));

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
    public boolean isUpdate(Schedule bean) throws SQLException {
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
