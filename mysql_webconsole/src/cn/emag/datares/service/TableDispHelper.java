package cn.emag.datares.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import cn.emag.datares.domain.Column;
import cn.emag.datares.domain.ColumnDisp;
import cn.emag.datares.domain.Constant;
import cn.emag.datares.domain.Table;
import cn.emag.datares.domain.TableDisp;

public class TableDispHelper {
    
    protected Table table;
    
    protected TableDisp tableDisp;
    
    protected List<Column> columnList;
    
    protected List<ColumnDisp> columnDispList;
    
    protected Map<String, List<ColumnDisp>> subTabColListMap;
    /**表字段与子表信息映射关系*/
    protected Map<String,Table> subTabMap;
    /**所有列表字段sql语句中的表示*/
    protected List<String> fieldsForSql = new ArrayList<String>();
    /**列表中的所有字段，查询结果中显示的名称*/
    protected List<String> fields = new ArrayList<String>();
    /**所有主键字段sql语句中的表示*/
    protected List<String> prmaryKeysForSql = new ArrayList<String>();
    
    protected List<String> prmaryKeys = new ArrayList<String>();
    /**所有列表字段描述*/
    protected List<String> fieldsDesc = new ArrayList<String>();
    /**所有查询条件字段名称*/
    protected List<String> queryFields = new ArrayList<String>();
    /**所有查询条件字段描述*/
    protected List<String> queryFieldsDesc = new ArrayList<String>();
    /**查询用到的所有表*/
    protected List<String> tables = new ArrayList<String>();
    /**查询条件（主表和子表关联、手工输入的查询条件）*/
    protected List<String> queryEntities = new ArrayList<String>();
    
    protected String countSql;
    
    protected String queryPageSql;
    /**数据字典表名*/
    static final String DataDictTableName = "sys_base_data";
    /**数据字典展示描述字段*/
    static final String DataDictTableLabelField = "bd_name";
    /**数据字典值字段*/
    static final String DataDictTableValueField = "bd_value";
    
    /**
     * 数据列表展示帮助类
     * @param table 物理表配置信息
     * @param tableDisp 表展示配置信息
     * @param columnList 物理表字段信息
     * @param columnDispList 表展示字段配置信息
     * @param subTabColListMap 表字段与子表字段列表映射关系
     * @param subTabMap 表字段与子表信息映射关系
     */
    public TableDispHelper(Table table, TableDisp tableDisp, List<Column> columnList, List<ColumnDisp> columnDispList,Map<String, List<ColumnDisp>> subTabColListMap,Map<String,Table> subTabMap) {
        this.table = table;
        this.tableDisp = tableDisp;
        this.columnList = columnList;
        this.columnDispList = columnDispList;
        this.subTabColListMap = subTabColListMap;
        this.subTabMap = subTabMap;
        
        init();
        
    }
    
    /**
     * （初始化）组织展示相关数据
     */
    protected void init() {
        String main_table_sqlname = table.getTab_sqlname();//主表名称
        
        Map<String, Column> colsMap = new HashMap<String, Column>();
        for (int j = 0; j < columnList.size(); j++) {
            Column col = columnList.get(j);
            colsMap.put(col.getCol_sqlname(), col);
        }
        
        tables.add(table.getTab_sqlname());
        
        int dataDictTableCount=0;//关联数据字典表次数
        
        for (int i = 0; i < columnDispList.size(); i++) {
            ColumnDisp colDisp = columnDispList.get(i);
            
            String col_sqlname = colDisp.getFull_col_sqlname();
            Column col = colsMap.get(col_sqlname);
            
            if (Constant.Yes.equals(colDisp.getIs_in_list())) {
                
                // 关联子表情况
                if (StringUtils.isNotBlank(colDisp.getSub_tab_disp_cols())) {
                    
                    Table subTab = subTabMap.get(col_sqlname);
                    List<ColumnDisp> subTabColList = subTabColListMap.get(col_sqlname);
                    
                    String sub_table_name = subTab.getTab_sqlname();
                    tables.add(sub_table_name);
                    
                    queryEntities.add(main_table_sqlname + "." + col_sqlname + "=" + sub_table_name + "."
                        + col.getSub_tab_col_sqlname());
                    
                    String[] sub_tab_cols = colDisp.getSub_tab_disp_cols().replaceAll(" ","").split(",");
                    
                    for(int j=0;j<sub_tab_cols.length;j++){
                        for(int k=0;k<subTabColList.size();k++){
                            ColumnDisp tmp = subTabColList.get(k);
                            if(sub_tab_cols[j].equals(tmp.getFull_col_sqlname())){
                                fieldsForSql.add(sub_table_name + "." + sub_tab_cols[j] + " as \"" + sub_table_name + "." + sub_tab_cols[j] + "\"");
                                fields.add(sub_table_name + "." + sub_tab_cols[j]);
                                fieldsDesc.add(tmp.getList_disp_name());
                            }
                        }
                    }
                    
                }else if(StringUtils.isNotBlank(col.getDatadict()) && Integer.parseInt(col.getDatadict()) > 0){//关联数据字典情况
                	dataDictTableCount++;
                	String dataDictTableAlias = DataDictTableName+dataDictTableCount;//数字字典别名
                	String dataDictLabelAlias = DataDictTableLabelField + dataDictTableCount;
                	
                	tables.add(DataDictTableName +" as "+dataDictTableAlias);
                	queryEntities.add(main_table_sqlname + "." + col_sqlname + "=" + dataDictTableAlias + "."
                            + DataDictTableValueField + " and "+ dataDictTableAlias +".bd_parent_id="+col.getDatadict());
                	
                	fieldsForSql.add(dataDictTableAlias + "." + DataDictTableLabelField + " as \"" + dataDictTableAlias + "." + dataDictLabelAlias + "\"");
                	fields.add(dataDictTableAlias + "." + dataDictLabelAlias);
                    fieldsDesc.add(colDisp.getList_disp_name());
                	
                	
                }
                else {
                    
                    fieldsForSql.add(main_table_sqlname + "." + col_sqlname + " as \"" + main_table_sqlname + "." + col_sqlname
                        + "\"");
                    fields.add(main_table_sqlname + "." + col_sqlname);
                    fieldsDesc.add(colDisp.getList_disp_name());
                    
                }
                
                if (Constant.Yes.equals(colDisp.getSupport_query())) {
                    queryFields.add(main_table_sqlname + "." + col_sqlname);
                    queryFieldsDesc.add(colDisp.getList_disp_name());
                }
            }
            
            // 找出主键字段
            if (Constant.Yes.equals(col.getIspk())) {
                prmaryKeysForSql.add(main_table_sqlname + "." + col_sqlname + " as \"" + main_table_sqlname + "." + col_sqlname
                    + "\"");
                prmaryKeys.add(main_table_sqlname + "." + col_sqlname);
            }
        }
    }
    
    /**
     * 组织分页查询count语句
     * @param request 用于获取查询条件
     * @return
     */
    public String getCountSql(HttpServletRequest request) {
        
        if (countSql != null) {
            return countSql;
        }
        
        countSql = "select count(*) from ";
        String tableSql = "";
        String querySql = "";
        for (int i = 0; i < tables.size(); i++) {
            tableSql = tableSql + "," + tables.get(i);
        }
        if (tableSql.length() > 0) {
            tableSql = tableSql.substring(1, tableSql.length());
        }
        
        for (int i = 0; i < queryEntities.size(); i++) {
            querySql = querySql + " and " + queryEntities.get(i);
        }
        
        // 添加数据表查询条件
        // TODO:需要防止SQL注入
        for(int i=0;i<queryFields.size();i++){
        	String searchField = queryFields.get(i);
        	String value = request.getParameter(searchField);
            if (StringUtils.isNotBlank(value)) {
                querySql = querySql + " and " + searchField + "='" + value + "'";
            }
        }
        
        if (querySql.length() > 0) {
            querySql = querySql.substring(5, querySql.length());
            countSql = countSql + tableSql + " where " + querySql;
        }
        else {
            countSql = countSql + tableSql;
        }
        
        return countSql;
    }
    
    /**
     * 组织分页查询详细查询SQL
     * @param pageNumber 当前显示第几页
     * @param pageSize 每页显示的记录数
     * @param request 用于获取查询条件
     * @return
     */
    public String getPageQuerySql(int pageNumber, int pageSize, HttpServletRequest request) {
        
        int skip = (pageNumber - 1) * pageSize;
        int max = pageSize;
        
        String fieldsSql = "";
        String tableSql = "";
        String querySql = "";
        for (int i = 0; i < fieldsForSql.size(); i++) {
            fieldsSql = fieldsSql + "," + fieldsForSql.get(i);
        }
        
        fieldsSql = fieldsSql + ",";
        
        // 添加主键字段
        for (int i = 0; i < prmaryKeysForSql.size(); i++) {
            String key = prmaryKeysForSql.get(i);
            if (fieldsSql.indexOf("," + key + ",") < 0) {
                fieldsSql = fieldsSql + key + ",";
            }
        }
        
        fieldsSql = fieldsSql.substring(0, fieldsSql.length() - 1);
        
        if (fieldsSql.length() > 0) {
            fieldsSql = fieldsSql.substring(1, fieldsSql.length());
        }
        
        for (int i = 0; i < tables.size(); i++) {
            tableSql = tableSql + "," + tables.get(i);
        }
        if (tableSql.length() > 0) {
            tableSql = tableSql.substring(1, tableSql.length());
        }
        
        for (int i = 0; i < queryEntities.size(); i++) {
            querySql = querySql + " and " + queryEntities.get(i);
        }
        
        // 添加数据表查询条件
        // TODO:需要防止SQL注入
        for(int i=0;i<queryFields.size();i++){
        	String searchField = queryFields.get(i);
        	String value = request.getParameter(searchField);
            if (StringUtils.isNotBlank(value)) {
                querySql = querySql + " and " + searchField + "='" + value + "'";
            }
        }
        
        if (querySql.length() > 0) {
            querySql = querySql.substring(5, querySql.length());
            
        }
        
        if (querySql.length() > 0) {
            queryPageSql =
                "select " + fieldsSql + " from " + tableSql + " where " + querySql + " LIMIT " + skip + "," + max;
        }
        else {
            queryPageSql = "select " + fieldsSql + " from " + tableSql + " LIMIT " + skip + "," + max;
        }
        
        return queryPageSql;
    }
    
    public List<String> getFieldList() {
        return fields;
    }
    
    public List<String> getFieldDescList() {
        return fieldsDesc;
    }
    
    public List<String> getQueryFieldList() {
        return queryFields;
    }
    
    public List<String> getQueryFieldDescList() {
        return queryFieldsDesc;
    }
    
    public List<String> getPrmaryKeyList() {
        return prmaryKeys;
    }
    
}
