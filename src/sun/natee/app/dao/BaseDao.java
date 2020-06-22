package sun.natee.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface BaseDao<T, ID> {
    
    public void init();
    public int save(T bean) throws SQLException;
    public int update(T bean) throws SQLException;
    public int delete(ID id) throws SQLException;
    public T findById(ID id) throws SQLException;
    public List<T> findAll() throws SQLException;
    public T mapping(ResultSet rs, T bean) throws SQLException;
    public boolean isUpdate(T bean) throws SQLException;
    public void dropTable();
}
