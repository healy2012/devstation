package cn.emag.datares.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import cn.emag.datares.domain.Column;
import cn.emag.datares.domain.ColumnDisp;
import cn.emag.datares.domain.Constant;
import cn.emag.datares.domain.Table;
import cn.emag.datares.domain.TableDisp;

public class TableFormHelper {
    
    List<String> formFieldList;
    
    List<String> formFieldDescList;
    
    Map<String, Object> formData;
    
    Map<String, String> primaryKeyMap;
    
    /**
     * 获取查询表单数据sql
     * 
     * @param table
     * @param tableDisp
     * @param columnList
     * @param columnDispList
     * @param primaryKey
     */
    public String getQuerySql(Table table, TableDisp tableDisp, List<Column> columnList,
        List<ColumnDisp> columnDispList, Map<String, String> pkMap) {
        
        StringBuilder sql = new StringBuilder();
        
        // 查询表单数据
        if (pkMap != null && !pkMap.isEmpty()) {
            
            StringBuilder querySql = new StringBuilder();
            
            Iterator<String> it = pkMap.keySet().iterator();
            
            while (it.hasNext()) {
                String key = it.next();
                querySql.append(key).append("='").append(pkMap.get(key)).append("' and ");
            }
            
            if (querySql.length() > 0) {
                querySql.delete(querySql.length() - 5, querySql.length());
            }
            
            formFieldList = new ArrayList<String>();
            formFieldDescList = new ArrayList<String>();
            
            StringBuilder fieldsSql = new StringBuilder();
            
            String tab_sqlname = table.getTab_sqlname();
            
            for (int i = 0; i < columnDispList.size(); i++) {
                ColumnDisp columnDisp = columnDispList.get(i);
                if (Constant.Yes.equals(columnDisp.getIs_in_form())) {
                    fieldsSql.append(tab_sqlname)
                        .append(".")
                        .append(columnDisp.getFull_col_sqlname())
                        .append(" as \"")
                        .append(tab_sqlname)
                        .append(".")
                        .append(columnDisp.getFull_col_sqlname())
                        .append("\",");
                    formFieldList.add(tab_sqlname + "." + columnDisp.getFull_col_sqlname());
                    formFieldDescList.add(columnDisp.getForm_disp_name());
                }
            }
            
            it = pkMap.keySet().iterator();
            
            // 添加主键字段
            while (it.hasNext()) {
                String key = it.next();
                if (fieldsSql.indexOf("\"" + key + "\",") < 0)
                    fieldsSql.append(key).append(" as \"").append(key).append("\",");
            }
            
            if (fieldsSql.length() > 0) {
                fieldsSql.delete(fieldsSql.length() - 1, fieldsSql.length());
            }
            
            sql.append("select ")
                .append(fieldsSql)
                .append(" from ")
                .append(tab_sqlname)
                .append(" where ")
                .append(querySql);
        }
        
        return sql.length() > 0 ? sql.toString() : null;
    }
    
    /**
     * 获得插入sql
     * @param table
     * @param tableDisp
     * @param columnList
     * @param columnDispList
     * @param request
     * @return
     */
    public String getInsertSql(Table table, TableDisp tableDisp, List<Column> columnList,
        List<ColumnDisp> columnDispList, Object rowData) {
        
        StringBuilder fieldsSql = new StringBuilder();
        StringBuilder valuesSql = new StringBuilder();
        
        String tab_sqlname = table.getTab_sqlname();
        
        for (int i = 0; i < columnDispList.size(); i++) {
            ColumnDisp columnDisp = columnDispList.get(i);
            
            String field = tab_sqlname + "." + columnDisp.getFull_col_sqlname();
            String value;
            
            if(rowData instanceof HttpServletRequest){
            	value = ((HttpServletRequest)rowData).getParameter(field);
            }else{
            	value = (String)((Map)rowData).get(columnDisp.getFull_col_sqlname());
            }
            
            if (Constant.Yes.equals(columnDisp.getIs_in_form())) {
                
                if (Constant.Yes.equals(columnDisp.getSupport_update())) {
                    
                    fieldsSql.append(field).append(",");
                    valuesSql.append("'").append(value == null ? "" : value).append("',");
                    
                }
            }
        }
        
        if (fieldsSql.length() > 0) {
            fieldsSql.delete(fieldsSql.length() - 1, fieldsSql.length());
        }
        
        if (valuesSql.length() > 0) {
            valuesSql.delete(valuesSql.length() - 1, valuesSql.length());
        }
        
        StringBuilder insertSql = new StringBuilder();
        
        insertSql.append("insert into ")
            .append(tab_sqlname)
            .append(" (")
            .append(fieldsSql)
            .append(") values(")
            .append(valuesSql)
            .append(")");
        
        return insertSql.toString();
    }
    
    /**
     * 获取删除sql列表
     * @param table
     * @param tableDisp
     * @param columnList
     * @param columnDispList
     * @param pkMapList
     * @return
     */
    public List<String> getDeleteSql(Table table, TableDisp tableDisp, List<Column> columnList,
        List<ColumnDisp> columnDispList, List<Map<String, String>> pkMapList) {
        
        List<String> deleteSqlList = new ArrayList<String>();
        
        StringBuilder deleteSql = new StringBuilder();
        
        String sqlHead = "delete from "+table.getTab_sqlname() +" where ";       
        
        for(int i=0;i<pkMapList.size();i++){
            Map<String,String> pkMap = pkMapList.get(i);
            Iterator<String> it = pkMap.keySet().iterator();
            
            deleteSql.delete(0, deleteSql.length());
            
            while(it.hasNext()){
                String field = it.next();
                deleteSql.append(sqlHead).append(field).append("='").append(pkMap.get(field)).append("' and ");
            }
            
            if(deleteSql.length()>0){
                deleteSql.delete(deleteSql.length()-5, deleteSql.length());
                deleteSqlList.add(deleteSql.toString());  
            }        
        }
        
        return deleteSqlList;
    }
    
    /**
     * 获取删除sql列表
     * @param table
     * @param tableDisp
     * @param columnList
     * @param columnDispList
     * @param primaryKeyList
     * @param deleteList
     * @return
     */
	public List<String> getDeleteSql(Table table, TableDisp tableDisp,
			List<Column> columnList, List<ColumnDisp> columnDispList,
			List<String> primaryKeyList, List<Map<String, String>> deleteList) {

		List<String> deleteSqlList = new ArrayList<String>();

		StringBuilder deleteSql = new StringBuilder();

		String sqlHead = "delete from " + table.getTab_sqlname() + " where ";

		for (int i = 0; i < deleteList.size(); i++) {
			Map<String, String> rowData = deleteList.get(i);

			deleteSql.delete(0, deleteSql.length());

			for (int j = 0; j < primaryKeyList.size(); j++) {
				String field = primaryKeyList.get(j);
				deleteSql.append(sqlHead).append(field).append("='")
						.append(rowData.get(field)).append("' and ");
			}

			if (deleteSql.length() > 0) {
				deleteSql.delete(deleteSql.length() - 5, deleteSql.length());
				deleteSqlList.add(deleteSql.toString());
			}
		}

		return deleteSqlList;
	}
    
	/**
	 * 获取更新sql
	 * @param table
	 * @param tableDisp
	 * @param columnList
	 * @param columnDispList
	 * @param rowData
	 * @return
	 */
    public String getUpdateSql(Table table, TableDisp tableDisp, List<Column> columnList,
        List<ColumnDisp> columnDispList, Object rowData) {
        
        Map<String, Column> colsMap = new HashMap<String, Column>();
        for (int j = 0; j < columnList.size(); j++) {
            Column col = columnList.get(j);
            colsMap.put(col.getCol_sqlname(), col);
        }
        
        StringBuilder updateFieldsSql = new StringBuilder();
        StringBuilder queryEntrySql = new StringBuilder();
        
        String tab_sqlname = table.getTab_sqlname();
        
        primaryKeyMap = new HashMap<String, String>();
        
        for (int i = 0; i < columnDispList.size(); i++) {
            ColumnDisp columnDisp = columnDispList.get(i);
            
            String field = tab_sqlname + "." + columnDisp.getFull_col_sqlname();
            
            String value;
            
            if(rowData instanceof HttpServletRequest){
            	value = ((HttpServletRequest)rowData).getParameter(field);
            }else{
            	value = (String)((Map)rowData).get(columnDisp.getFull_col_sqlname());
            }
            
            Column col = colsMap.get(columnDisp.getFull_col_sqlname());
            
            if (Constant.Yes.equals(col.getIspk())) {
                primaryKeyMap.put(field, value);
            }
            
            if (Constant.Yes.equals(columnDisp.getIs_in_form())) {
                
                if (Constant.Yes.equals(columnDisp.getSupport_update())) {
                    
                    updateFieldsSql.append(field).append("='").append(value == null ? "" : value).append("',");
                    
                }
                
                // formData.put(field, value);
            }
        }
        
        if (updateFieldsSql.length() > 0) {
            updateFieldsSql.delete(updateFieldsSql.length() - 1, updateFieldsSql.length());
        }
        
        Iterator<String> it = primaryKeyMap.keySet().iterator();
        
        while (it.hasNext()) {
            String key = it.next();
            String value = primaryKeyMap.get(key);
            if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value)) {
                queryEntrySql.append(key).append("='").append(value).append("' and ");
            }
        }
        
        if (queryEntrySql.length() > 0) {
            queryEntrySql.delete(queryEntrySql.length() - 5, queryEntrySql.length());
        }
        else {
            return null;
        }
        
        StringBuilder updateSql = new StringBuilder();
        
        updateSql.append("update ")
            .append(tab_sqlname)
            .append(" set ")
            .append(updateFieldsSql)
            .append(" where ")
            .append(queryEntrySql);
        
        return updateSql.toString();
    }
    
	public static List<String> getPrimaryKeyList(List<Column> columnList) {

		List<String> primaryKeyList = new ArrayList<String>();

		for (int i = 0; i < columnList.size(); i++) {
			Column col = columnList.get(i);

			if (Constant.Yes.equals(col.getIspk())) {
				primaryKeyList.add(col.getCol_sqlname());
			}
		}

		return primaryKeyList;
	}
    
    public Map<String, String> getPrimaryKeyMap() {
        return primaryKeyMap;
    }
    
    public List<String> getFormFieldList() {
        return formFieldList;
    }
    
    public List<String> getFormFieldDescList() {
        return formFieldDescList;
    }
    
    public Map<String, Object> getFormData() {
        return formData;
    }
}
