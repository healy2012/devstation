package cn.emag.datares.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.emag.datares.dao.TableJdbcDao;
import cn.emag.datares.domain.Column;
import cn.emag.datares.domain.ColumnDisp;
import cn.emag.datares.domain.ListData;
import cn.emag.datares.domain.Table;
import cn.emag.framework.spring.SpringContextHolder;
import cn.emag.system.domain.BaseData;
import cn.emag.system.service.BaseDataService;

@Service("dynamicTableService")
public class DynamicTableService {
    @Autowired
    private TableJdbcDao tableJdbcDao;
    
    public int getCount(String countSql) {
        if (countSql != null) {
            return tableJdbcDao.getCount(countSql);
        }
        else {
            return 0;
        }
    }
    
    public List<Map<String, Object>> getListData(String querySql) {
        if (querySql != null) {
            return tableJdbcDao.getListData(querySql);
        }
        else {
            return null;
        }
    }
    
    public int updateSql(String sql) {
        if (sql != null) {
            return tableJdbcDao.updateSql(sql);
        }
        else {
            return -1;
        }
    }
    
    public void deleteSql(String sql) {
        if (sql != null) {
            tableJdbcDao.deleteSql(sql);
        }
    }
    
    public void deleteMultipleSql(String[] sql) {
        if (sql != null) {
            tableJdbcDao.deleteMultipleSql(sql);
        }
    }
    
    public long insertSql(String sql) {
        if (sql != null) {
            return tableJdbcDao.insertSql(sql);
        }
        else {
            return -1;
        }
    }
    
    /**
     * 获取数据字典或者关联子表数据
     * 
     * @param table
     * @param columnList
     * @param columnDispList
     * @param subTabColListMap
     * @param subTabMap
     * @return
     */
    public Map<String, ListData> getDataList(Table table, List<Column> columnList, List<ColumnDisp> columnDispList,
        Map<String, List<ColumnDisp>> subTabColListMap, Map<String, Table> subTabMap) {
        
        Map<String, Column> colsMap = new HashMap<String, Column>();
        for (int j = 0; j < columnList.size(); j++) {
            Column col = columnList.get(j);
            colsMap.put(col.getCol_sqlname(), col);
        }
        
        Map<String, ListData> listDataMap = new HashMap<String, ListData>();
        
        String tab_sqlname = table.getTab_sqlname();
        
        for (int i = 0; i < columnDispList.size(); i++) {
            ColumnDisp colDisp = columnDispList.get(i);
            Column column = colsMap.get(colDisp.getFull_col_sqlname());
            
            // 主表仅关联子表情况
            if ((StringUtils.isBlank(column.getDatadict()) || Integer.parseInt(column.getDatadict()) <= 0)
                && StringUtils.isNotBlank(column.getSub_tab_id()) && Integer.parseInt(column.getSub_tab_id()) > 0) {
                
                List<String> headNameList = new ArrayList<String>();
                List<String> headFieldList = new ArrayList<String>();
                // 字段名称及其数据列表
                Map<String, List<String>> dataDispListMap = new HashMap<String, List<String>>();
                List<String> valueList = new ArrayList<String>();
                String valueField;
                
                String col_sqlname = colDisp.getFull_col_sqlname();
                
                Table subTab = subTabMap.get(col_sqlname);
                List<ColumnDisp> subTabColList = subTabColListMap.get(col_sqlname);
                
                String sub_table_name = subTab.getTab_sqlname();
                
                valueField = sub_table_name + "." + column.getSub_tab_col_sqlname();
                
                boolean existIdField = false;//展示字段是否包含主键字段
                
                String[] sub_tab_cols = colDisp.getSub_tab_disp_cols().replaceAll(" ", "").split(",");
                
                for (int j = 0; j < sub_tab_cols.length; j++) {
                    for (int k = 0; k < subTabColList.size(); k++) {
                        ColumnDisp tmp = subTabColList.get(k);
                        if (sub_tab_cols[j].equals(tmp.getFull_col_sqlname())) {
                            headFieldList.add(sub_table_name + "." + sub_tab_cols[j]);
                            headNameList.add(tmp.getForm_disp_name());
                            
                            if (valueField.equals(sub_table_name + "." + sub_tab_cols[j])) {
                                existIdField = true;
                            }
                        }
                    }
                }
                
                StringBuilder querySql = new StringBuilder();
                querySql.append("select ");
                
                if (!existIdField) {
                    querySql.append(valueField).append(" as \"").append(valueField).append("\",");
                }
                
                for (int j = 0; j < headFieldList.size(); j++) {
                    querySql.append(headFieldList.get(j)).append(" as \"").append(headFieldList.get(j)).append("\",");
                }
                
                if (querySql.length() > 7) {
                    querySql.delete(querySql.length() - 1, querySql.length());
                }
                
                querySql.append(" from ").append(sub_table_name);
                
                List<Map<String, Object>> dataMapList = tableJdbcDao.getListData(querySql.toString());
                
                for (int j = 0; j < dataMapList.size(); j++) {
                    Map<String, Object> dataMap = (Map<String, Object>)dataMapList.get(j);
                    Iterator<String> keyIterator = dataMap.keySet().iterator();
                    while (keyIterator.hasNext()) {
                        String key = keyIterator.next();
                        
                        if (valueField.equals(key)) {
                            valueList.add(dataMap.get(key).toString());
                        }
                        
                        if ((valueField.equals(key) && existIdField) || !valueField.equals(key)) {
                            
                            List<String> dataDispList = dataDispListMap.get(key);
                            if (dataDispList == null) {
                                dataDispList = new ArrayList<String>();
                                dataDispListMap.put(key, dataDispList);
                            }
                            dataDispList.add(dataMap.get(key).toString());
                        }
                        
                    }
                }
                
                ListData listData = new ListData(headNameList, headFieldList, dataDispListMap, valueList, valueField);
                
                listDataMap.put(tab_sqlname + "." + column.getCol_sqlname(), listData);
            }
            // 数据字典情况
            else if (StringUtils.isNotBlank(column.getDatadict()) && Integer.parseInt(column.getDatadict()) > 0) {
                List<String> headNameList = new ArrayList<String>();
                List<String> headFieldList = new ArrayList<String>();
                Map<String, List<String>> dataDispListMap = new HashMap<String, List<String>>();
                List<String> valueList = new ArrayList<String>();
                String valueField;
                
                valueField = "sys_base_data.bd_value";
                
                BaseDataService baseDataService = (BaseDataService)SpringContextHolder.getService("baseDataService");
                List<BaseData> bdList = baseDataService.findChildById(Integer.valueOf(column.getDatadict()));
                
                if (bdList != null && bdList.size() > 0) {
                    List<String> nameList = new ArrayList<String>();
                    
                    for (int j = 0; j < bdList.size(); j++) {
                        BaseData baseData = bdList.get(j);
                        nameList.add(baseData.getBdName());
                        valueList.add(baseData.getBdValue());
                    }
                    
                    dataDispListMap.put("sys_base_data.bd_name", nameList);
                }
                
                ListData listData = new ListData(headNameList, headFieldList, dataDispListMap, valueList, valueField);
                
                listDataMap.put(tab_sqlname + "." + column.getCol_sqlname(), listData);
            }
        }
        
        return listDataMap;
        
    }
}
