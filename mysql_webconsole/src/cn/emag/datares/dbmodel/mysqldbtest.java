package cn.emag.datares.dbmodel;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import net.sf.json.JSONObject;

import cn.emag.datares.dbmodel.provider.db.DataSourceProvider;
import cn.emag.datares.dbmodel.provider.db.table.TableFactory;
import cn.emag.datares.dbmodel.provider.db.table.model.Column;
import cn.emag.datares.dbmodel.provider.db.table.model.Table;

public class mysqldbtest {
    private static String url;
    private static String username;
    private static String password;
    private static String driverClass;
    
    public static void main2(String args[]){
        
        url="jdbc:mysql://192.168.167.125:3306/EDF?characterEncoding=utf-8";
        username="edf";
        password="edf";
        driverClass="com.mysql.jdbc.Driver";
        
        try {
            DataSourceProvider.DriverManagerDataSource dataSource = new DataSourceProvider.DriverManagerDataSource(url, username, password, driverClass);
            DataSourceProvider.setDataSource(dataSource);
            List tablist = TableFactory.getInstance().getAllTables();
            for(int i=0;i<tablist.size();i++){
                Table tab = (Table)tablist.get(i);
                System.out.println("tab.getSqlName():"+tab.getSqlName());
                
                LinkedHashSet<Column> colHashSet = tab.getColumns();
                Iterator<Column> cols = colHashSet.iterator();
                while(cols.hasNext()){
                    Column column = cols.next();
                    System.out.println("column.getSqlName():"+column.getSqlName());
                    System.out.println("column.getSqlType():"+column.getSqlType());
                    System.out.println("column.getSqlTypeName():"+column.getSqlTypeName());
                    
                    System.out.println("column.getSize():"+column.getSize());
                    System.out.println("column.isNullable():"+column.isNullable());
                    System.out.println("column.isPk():"+column.isPk());
                    
                    System.out.println("-------------------------------");
                    
                }
                System.out.println("=============================");
            }
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    public static void main3(String args[]){
        new mysqldbtest().test();
    }
    
    public static void main4(String args[]){
        JSONObject json = JSONObject.fromObject("{\"field1\":\"字段1\",\"field2\":\"字段2\",\"field3\":\"字段3\"}");
//        System.out.println(json.getString("field1"));
        System.out.println(json.toString());
        Iterator it = json.keys();
        while(it.hasNext()){
            String key = (String)it.next();
            System.out.println(key+":"+json.getString(key));
        }
        
        json = new JSONObject();
        json.put("p1", "value1");
        json.put("p2", "value2");
        
        System.out.println(json.toString());
        System.out.println(json.toString().replaceAll("\\\"", "\\\\\"").toString());
    }
    
    public static void main5(String args[]){
        try {
            Connection conn = new mysqldbtest().getmysqlConn();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO STUDENT_INFO (STUNAME, PASSWORD, BIRTH_DATE, SEX, AGE ) VALUES ('1221', '1212', '2013-01-08 14:18:00', 0, 0 )", Statement.RETURN_GENERATED_KEYS);
            
            ResultSet rs = stmt.getGeneratedKeys();
            
            /*ResultSetMetaData rd = rs.getMetaData();
            
            List<String> colList = new ArrayList<String>();
            
            int count = rd.getColumnCount();
            for(int i=1;i<count+1;i++){
                colList.add(rd.getCatalogName(i));
            }
            
            if(rs.next()){
                for(int i=0;i<colList.size();i++){
                    rs.getString(colList.get(i));
                }
            }*/
            
            if(rs.next()){
                System.out.println(rs.getString(1));
            }
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    public static void main6(String args[]){
        try {
            Connection conn = new mysqldbtest().getmysqlConn();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO generatedkeytest ( f1 ) VALUES ( '测试' )", Statement.RETURN_GENERATED_KEYS);
            
            ResultSet rs = stmt.getGeneratedKeys();
            
            if(rs.next()){
                System.out.println(rs.getString("stu_id"));
            }
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    public static void main(String args[]){
        try {
            Connection conn = new mysqldbtest().getmysqlConn();            
            DatabaseMetaData dbmd=conn.getMetaData(); //获取DatabaseMetaData实例
            
            System.out.println(dbmd.getDatabaseProductName()); //获取数据库名称
            System.out.println(dbmd.getDatabaseProductVersion()); //获取数据库版本号
            System.out.println(dbmd.getDriverName()); //获取JDBC驱动器名称
            System.out.println(dbmd.getDriverVersion()); //获取驱动器版本号
            System.out.println(dbmd.getUserName()); //获取登录用户名
            
            conn.close(); //关闭连接
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }      
    }
    
    public Connection getmysqlConn() throws SQLException{
        url="jdbc:mysql://192.168.167.125:3306/EDF?characterEncoding=utf-8";
        username="edf";
        password="edf";
        driverClass="com.mysql.jdbc.Driver";
        
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("not found jdbc driver class:["+driverClass+"]",e);
        }
        
        return DriverManager.getConnection(url,username,password);
    }
    
    public void test(){
        try {
            Connection conn = getmysqlConn();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT userid as 'isfssdfd',     username,     portaluserinfo.password as 'portaluserinfo.password',     email,     tel,     name FROM portaluserinfo");
            if(rs.next()){
                System.out.println("isfssdfd:"+rs.getString("isfssdfd"));
                System.out.println("portaluserinfo.password:"+rs.getString("portaluserinfo.password"));
            }
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
