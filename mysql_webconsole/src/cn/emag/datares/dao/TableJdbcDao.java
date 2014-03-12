package cn.emag.datares.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("tableJdbcDao")
public class TableJdbcDao extends NamedParameterJdbcDaoSupport {
    
    /**
     * 获取数据记录总数
     * @param countSql
     * @return
     */
    public int getCount(String countSql){
        return getJdbcTemplate().queryForInt(countSql);
    }
    
    /**
     * 获取列表数据
     * @param querySql
     * @return
     */
    public List<Map<String,Object>> getListData(String querySql){
        return getJdbcTemplate().queryForList(querySql);
    }
    
    public int updateSql(String sql){
        return getJdbcTemplate().update(sql);
    }
    
    public void deleteSql(String sql){
        getJdbcTemplate().execute(sql);
    }
    
    /**
     * 批量删除
     * @param sql
     */
    public void deleteMultipleSql(String[] sql){
        getJdbcTemplate().batchUpdate(sql);
    }
    
    /**
     * 插入数据，如果有自增字段，返回自增字段值
     * @param sql
     * @return
     */
    public long insertSql(String sql){
        Connection conn = null;
        try {
            conn = getJdbcTemplate().getDataSource().getConnection();
            
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            
            ResultSet rs = stmt.getGeneratedKeys();
            
            if(rs.next()){
                return rs.getLong(1);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            if(conn!=null){
                try {
                    conn.close();
                }
                catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return -1;       
    }
}
