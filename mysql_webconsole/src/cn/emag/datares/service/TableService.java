package cn.emag.datares.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.emag.datares.dao.TableDao;
import cn.emag.datares.dao.TableJdbcDao;
import cn.emag.datares.dbmodel.provider.db.DataSourceProvider;
import cn.emag.datares.dbmodel.provider.db.table.TableFactory;
import cn.emag.datares.domain.Column;
import cn.emag.datares.domain.ColumnDisp;
import cn.emag.datares.domain.Table;
import cn.emag.datares.domain.TableDisp;
import cn.emag.global.utils.DateUtil;

@Service("tableService")
public class TableService {
    
    @Autowired
    private TableDao tableDao;
    
    public List<Table> queryTableList(Table table, String sortColumns) {
        
        // 将userInfo组装成map，便于参数扩展
        Map params = organizeParams(table);
        
        // 查看sortByColumn是否为"",即是否要按列排序
        if (StringUtils.isNotBlank(sortColumns)) {
            params.put("sortColumns", sortColumns);
        }
        else {
            params.put("sortColumns", null);
        }
        
        return tableDao.queryTableList(params);
    }
    
    /**
     * 分页查询
     * 
     * @param table
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public List<Table> queryTableListByPage(Table table, int pageNumber, int pageSize) {
        // 将userInfo组装成map，便于参数扩展
        Map params = organizeParams(table);
        
        // 分页查询
        return tableDao.queryTableListByPage(pageNumber, pageSize, "tab_id", true, params);
    }
    
    /**
     * 查询总数
     * 
     * @param table
     * @return
     */
    public int getTableCount(Table table) {
        if (null == table) {
            table = new Table();
        }
        
        return tableDao.getTableCount(table);
    }
    
    /**
     * 根据tab_id查询资源表
     * 
     * @param tab_id
     * @return
     */
    public Table getTableById(String tab_id) {
        Table table = new Table();
        table.setTab_id(tab_id);
        return tableDao.getTableById(table);
    }
    
    /**
     * 根据tab_id查询资源表展示样式
     * 
     * @param tab_id
     * @return
     */
    public TableDisp getTableDispByTabId(String tab_id) {
        TableDisp tabDisp = new TableDisp();
        tabDisp.setTab_id(tab_id);
        return tableDao.getTableDispById(tabDisp);
    }
    
    /**
     * 根据多个tab_id查询多个CtabDisp数据
     * 
     * @param tab_id
     * @return
     */
    public List<TableDisp> getMultipleTableDispById(String tab_id) {
        Map parameter = new HashMap();
        parameter.put("tab_id", tab_id);
        return tableDao.getMultipleTableDispById(parameter);
    }
    
    /**
     * 从数据库查询数据表结构字段信息
     * 
     * @param table
     * @return
     */
    public List<Column> queryTableColumnFromDB(Table table) {
        List<Column> list = new ArrayList<Column>();
        
        /*
         * String url="jdbc:mysql://localhost:3306/edf?characterEncoding=utf-8"; String username="edf"; String
         * password="edf"; String driverClass="com.mysql.jdbc.Driver";
         * 
         * DataSourceProvider.DriverManagerDataSource dataSource = new DataSourceProvider.DriverManagerDataSource(url,
         * username, password, driverClass);
         */

        DataSourceProvider.setDataSource(tableDao.getDataSource());
        
        if (StringUtils.isNotBlank(table.getTab_sqlname())) {
            cn.emag.datares.dbmodel.provider.db.table.model.Table t =
                TableFactory.getInstance().getTable(table.getTab_sqlname());
            
            LinkedHashSet<cn.emag.datares.dbmodel.provider.db.table.model.Column> colHashSet = t.getColumns();
            Iterator<cn.emag.datares.dbmodel.provider.db.table.model.Column> cols = colHashSet.iterator();
            while (cols.hasNext()) {
                cn.emag.datares.dbmodel.provider.db.table.model.Column column = cols.next();
                Column c = new Column();
                c.setCol_size(column.getSize() + "");
                c.setCol_sqlname(column.getSqlName());
                c.setCol_desc(column.getSqlName());
                c.setCol_sqltype(column.getSqlTypeName());
                c.setIsnullable(column.isNullable() ? "01" : "02");
                c.setIspk(column.isPk() ? "01" : "02");
                
                list.add(c);
                
                /*
                 * System.out.println("column.getSqlName():"+column.getSqlName());
                 * System.out.println("column.getSqlType():"+column.getSqlType());
                 * System.out.println("column.getSqlTypeName():"+column.getSqlTypeName());
                 * System.out.println("column.getSize():"+column.getSize());
                 * System.out.println("column.isNullable():"+column.isNullable());
                 * System.out.println("column.isPk():"+column.isPk());
                 * 
                 * System.out.println("-------------------------------");
                 */

            }
            
        }
        
        return list;
        
    }
    
    public void saveTable(Table table) {
        if (table == null)
            return;
        String curDate = DateUtil.getCurrentDateString("yyyy-MM-dd HH:mm:ss");
        table.setCreate_time(curDate);
        table.setUpdate_time(curDate);
        tableDao.saveTable(table);
    }
    
    public void updateTable(Table table) {
        if (table == null)
            return;
        String curDate = DateUtil.getCurrentDateString("yyyy-MM-dd HH:mm:ss");
        table.setUpdate_time(curDate);
        tableDao.updateTable(table);
    }
    
    public void saveTableColumn(Table table, Column col) {
        if (table == null || col == null)
            return;
        
        String curDate = DateUtil.getCurrentDateString("yyyy-MM-dd HH:mm:ss");
        
        col.setTab_id(table.getTab_id());
        col.setCreate_time(curDate);
        col.setUpdate_time(curDate);
        
        if (StringUtils.isBlank(col.getSub_tab_id())) {
            col.setSub_tab_id("0");
        }
        
        tableDao.saveTableColumn(col);
    }
    
    public void updateTableColumn(Table table, Column col) {
        if (table == null || col == null)
            return;
        String curDate = DateUtil.getCurrentDateString("yyyy-MM-dd HH:mm:ss");
        
        col.setTab_id(table.getTab_id());
        col.setUpdate_time(curDate);
        
        if (StringUtils.isBlank(col.getSub_tab_id())) {
            col.setSub_tab_id("0");
        }
        
        tableDao.updateTableColumn(col);
    }
    
    public List<Column> queryTableColumnList(String tab_id) {
        Map parameter = new HashMap();
        parameter.put("tab_id", tab_id);
        return tableDao.queryTableColumnList(parameter);
    }
    
    public void saveTableDisp(TableDisp tableDisp) {
        if (tableDisp == null)
            return;
        String curDate = DateUtil.getCurrentDateString("yyyy-MM-dd HH:mm:ss");
        tableDisp.setCreate_time(curDate);
        tableDisp.setUpdate_time(curDate);
        
        if (StringUtils.isBlank(tableDisp.getPage_count())) {
            tableDisp.setPage_count("10");
        }
        
        tableDao.saveTableDisp(tableDisp);
    }
    
    public void updateTableDisp(TableDisp tableDisp) {
        if (tableDisp == null)
            return;
        String curDate = DateUtil.getCurrentDateString("yyyy-MM-dd HH:mm:ss");
        tableDisp.setUpdate_time(curDate);
        
        if (StringUtils.isBlank(tableDisp.getPage_count())) {
            tableDisp.setPage_count("10");
        }
        
        tableDao.updateTableDisp(tableDisp);
    }
    
    public void saveTableColumnDisp(TableDisp tableDisp, ColumnDisp colDisp) {
        if (tableDisp == null || colDisp == null)
            return;
        
        String curDate = DateUtil.getCurrentDateString("yyyy-MM-dd HH:mm:ss");
        
        colDisp.setTab_disp_id(tableDisp.getTab_disp_id());
        colDisp.setCreate_time(curDate);
        colDisp.setUpdate_time(curDate);
        
        if (StringUtils.isBlank(colDisp.getList_disp_order())) {
            colDisp.setList_disp_order("0");
        }
        
        if (StringUtils.isBlank(colDisp.getForm_disp_order())) {
            colDisp.setForm_disp_order("0");
        }
        
        tableDao.saveTableColumnDisp(colDisp);
    }
    
    public void updateTableColumnDisp(TableDisp tableDisp, ColumnDisp colDisp) {
        if (tableDisp == null || colDisp == null)
            return;
        
        String curDate = DateUtil.getCurrentDateString("yyyy-MM-dd HH:mm:ss");
        
        colDisp.setTab_disp_id(tableDisp.getTab_disp_id());
        colDisp.setUpdate_time(curDate);
        
        if (StringUtils.isBlank(colDisp.getList_disp_order())) {
            colDisp.setList_disp_order("0");
        }
        
        if (StringUtils.isBlank(colDisp.getForm_disp_order())) {
            colDisp.setForm_disp_order("0");
        }
        
        tableDao.updateTableColumnDisp(colDisp);
    }
    
    public List<ColumnDisp> queryTableColumnDispList(String tab_disp_id) {
        Map parameter = new HashMap();
        parameter.put("tab_disp_id", tab_disp_id);
        return tableDao.queryTableColumnDispList(parameter);
    }
    
    /**
     * 根据tab_id删除多个表配置
     * 
     * @param tab_id
     */
    public void deleteMultipleTable(String tab_id) {
        if (StringUtils.isNotBlank(tab_id)) {
            Map parameter = new HashMap();
            parameter.put("tab_id", tab_id);
            tableDao.deleteMultipleTable(parameter);
        }
    }
    
    /**
     * 根据tab_id删除多个表展现配置
     * 
     * @param tab_id
     */
    public void deleteMultipleTableDisp(String tab_id) {
        if (StringUtils.isNotBlank(tab_id)) {
            Map parameter = new HashMap();
            parameter.put("tab_id", tab_id);
            tableDao.deleteMultipleTableDisp(parameter);
        }
    }
    
    /**
     * 根据tab_id删除多个表的列配置
     * 
     * @param tab_id
     */
    public void deleteMultipleTableColumn(String tab_id) {
        if (StringUtils.isNotBlank(tab_id)) {
            Map parameter = new HashMap();
            parameter.put("tab_id", tab_id);
            tableDao.deleteMultipleTableColumn(parameter);
        }
    }
    
    /**
     * 根据tab_disp_id删除多个表的列配置
     * 
     * @param tab_disp_id
     */
    public void deleteMultipleTableColumnDisp(String tab_disp_id) {
        if (StringUtils.isNotBlank(tab_disp_id)) {
            Map parameter = new HashMap();
            parameter.put("tab_disp_id", tab_disp_id);
            tableDao.deleteMultipleTableColumnDisp(parameter);
        }
    }
    
    /**
     * 检查物理表是否存在
     * 
     * @param table
     * @return
     */
    public boolean existTableByName(Table table) {
        Map<String, String> params = new HashMap<String, String>();
        // 数据库名称         
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties"); 
//        =ClassLoader.getSystemResourceAsStream("jdbc.properties");
        Properties p = new Properties();
        try {
            p.load(in);
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        String dbname = p.getProperty("table.schema");        
        if(dbname!=null){
            params.put("dbname", dbname);
        }
        
        if (table != null && StringUtils.isNotBlank(table.getTab_sqlname())) {
            params.put("tbname", table.getTab_sqlname());
        }
        
        System.out.println("dbname:"+dbname);
        System.out.println("tbname:"+table.getTab_sqlname());
        
        return tableDao.existTableByName(params);
    }
    
    private Map organizeParams(Table table) {
        if (null == table) {
            table = new Table();
        }
        
        // 用于存放参数值的容器，用于Ibatis条件查询是取值
        Map params = new HashMap();
        
        if (StringUtils.isNotBlank(table.getTab_name()))
            params.put("tab_name", table.getTab_name());
        
        if (StringUtils.isNotBlank(table.getTab_sqlname()))
            params.put("tab_sqlname", table.getTab_sqlname());
        
        return params;
        
    }
    
}
