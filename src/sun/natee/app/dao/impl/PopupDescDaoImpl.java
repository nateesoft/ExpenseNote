package sun.natee.app.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import sun.natee.app.AppConstants;
import sun.natee.app.bean.PopupDesc;
import sun.natee.app.dao.BaseDao;
import sun.natee.app.db.Database;
import sun.natee.app.main.util.MsgUtil;

public class PopupDescDaoImpl implements BaseDao<PopupDesc, Integer> {

    private final Logger logger = Logger.getLogger(PopupDescDaoImpl.class);
    private final String table = AppConstants.TABLE_POPUP_DESC;

    @Override
    public void init() {
        Database.initTable(table);
    }

    @Override
    public int save(PopupDesc bean) throws SQLException {
        if (isUpdate(bean)) {
            return update(bean);
        }

        String sql = "insert into " + table + ""
                + "(item_desc, item_type) "
                + "values('" + bean.getItemDesc() + "', '" + bean.getItemType() + "')";
        MsgUtil.printLog(sql);
        logger.debug(sql);
        return Database.getConnect().createStatement().executeUpdate(sql);
    }

    @Override
    public int update(PopupDesc bean) throws SQLException {
        String sql = "update " + table + " set "
                + "item_desc='" + bean.getItemDesc() + "', "
                + "item_type='" + bean.getItemType() + "' "
                + "where id=" + bean.getId() + "";
        MsgUtil.printLog(sql);
        logger.debug(sql);
        return Database.getConnect().createStatement().executeUpdate(sql);
    }

    @Override
    public PopupDesc findById(Integer id) throws SQLException {
        String sql = "SELECT * FROM " + table + " where id = " + id;
        logger.debug(sql);
        try (ResultSet rs = Database.getConnect().createStatement().executeQuery(sql)) {
            if (rs.next()) {
                return mapping(rs, new PopupDesc());
            }
        }

        return null;
    }

    @Override
    public List<PopupDesc> findAll() throws SQLException {
        List<PopupDesc> listShop = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " order by id";
        logger.debug(sql);
        try (ResultSet rs = Database.getConnect().createStatement().executeQuery(sql)) {
            while (rs.next()) {
                listShop.add(mapping(rs, new PopupDesc()));
            }
        }

        return listShop;
    }

    public List<PopupDesc> findAll(String type) throws SQLException {
        List<PopupDesc> listShop = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " where item_type='" + type + "' order by id";
        logger.debug(sql);
        try (ResultSet rs = Database.getConnect().createStatement().executeQuery(sql)) {
            while (rs.next()) {
                listShop.add(mapping(rs, new PopupDesc()));
            }
        }

        return listShop;
    }

    @Override
    public PopupDesc mapping(ResultSet rs, PopupDesc bean) throws SQLException {
        bean.setId(rs.getInt("id"));
        bean.setItemDesc(rs.getString("item_desc"));
        bean.setItemType(rs.getString("item_type"));

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
    public boolean isUpdate(PopupDesc bean) throws SQLException {
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
