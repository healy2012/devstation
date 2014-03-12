/**
 * TODO
 * @author Administrator
 * Create on 2011-7-8
 */
package cn.emag.system.dao;

import java.sql.Types;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import cn.emag.framework.dao.BaseJdbcDao;
import cn.emag.framework.utils.DataUtil;
import cn.emag.system.domain.Navigator;

@Repository
public class NavigatorJdbcDao extends BaseJdbcDao {

	@SuppressWarnings("unchecked")
	public List<Navigator> listDisplayNavigator() {
		String sql = loadSQL("listDisplayNavigator");
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Navigator.class));
	}
	
	public int saveNavigator(Navigator navigator)
	{
		navigator.setNavId(DataUtil.getNextIntegerID("SYS_NAV_SEQ"));
	    
	    String sql = loadSQL("saveNavigator");
	    
	    return getJdbcTemplate().update(
            sql,
            new Object[] {
                    navigator.getNavId(),
                    navigator.getNavName(),
                    navigator.getNavUrl(),
                    navigator.getNavStatus(),
                    navigator.getNavSeq(),
                    navigator.getNavNote(),
                    },
            new int[] { Types.INTEGER, Types.VARCHAR, Types.VARCHAR,Types.INTEGER,Types.INTEGER,Types.VARCHAR});
	}
	
	public int deleteNavigators(String navId)
	{
	    String sql = loadSQL("delNavigator");
	    
	    return getJdbcTemplate().update(sql, 
	        new Object[] 
	       {
	         navId
	       }
	    );
	}
	
	public Navigator getNavigator(String navId)
	    {
	        String sql = loadSQL("getNavigator");
	        
	        return (Navigator)getJdbcTemplate().queryForObject(
	        sql,  
	       new Object[] 
           {
             navId
           }, 
           new BeanPropertyRowMapper(Navigator.class));
	    }
	
	public int updateNavigator(Navigator navigator)
	{
	    String sql = loadSQL("updateNavigator");
	    
	    return getJdbcTemplate().update(
	        sql, 
	        new Object[] {
                navigator.getNavName(),
                navigator.getNavUrl(),
                navigator.getNavStatus(),
                navigator.getNavSeq(),
                navigator.getNavNote(),
                navigator.getNavId(),
                }, 
                new int[] {Types.VARCHAR, Types.VARCHAR,Types.INTEGER,Types.INTEGER,Types.VARCHAR, Types.INTEGER});
	}
	
	@SuppressWarnings("unchecked")
    public List<Navigator> queryNavigatorList()
	{
	    String sql = loadSQL("queryNavigatorList");
	    
	    return getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Navigator.class));
	}
	
	public int getSameSeqCount(Integer navId,Integer navSeq)
	{
	   String sql = null;
	   if(null == navId)
	   {
	     sql = loadSQL("getSeqWhenCreate");
	    
	    return getJdbcTemplate().queryForInt(
	       sql,  
	       new Object[] 
           {
             navSeq
           });
	   }
	   
	   sql = loadSQL("getSeqWhenUpdate");
	  
	   return getJdbcTemplate().queryForInt(
           sql,  
           new Object[] 
           {
             navId,
             navSeq,
           });
	   
	}
}
