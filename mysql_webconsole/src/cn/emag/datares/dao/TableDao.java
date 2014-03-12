package cn.emag.datares.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.emag.datares.domain.Column;
import cn.emag.datares.domain.ColumnDisp;
import cn.emag.datares.domain.ColumnVerify;
import cn.emag.datares.domain.Table;
import cn.emag.datares.domain.TableDisp;
import cn.emag.demo.domain.UserInfo;
import cn.emag.framework.dao.BaseIBatisDao;

@Repository("tableDao")
public class TableDao extends BaseIBatisDao {
    
    /**
     * 查询资源表列表
     * 
     * @param params
     * @return
     */
    public List<Table> queryTableList(Map params) {
        List<Table> tabList =
            this.getSqlMapClientTemplate().queryForList("Ctab.queryTableList", params);
        
        return tabList;
    }
    
    /**
     * 分页查询资源表
     * 
     * @param pageNumber
     * @param pageSize
     * @param sortByColumn
     * @param sortAsc
     * @param map
     * @return
     */
    public List<Table> queryTableListByPage(int pageNumber, int pageSize, String sortByColumn, boolean sortAsc,
        Map<String, String> map) {
        return queryForPaginatedList("Ctab.queryTableListByPage",
            map,
            pageNumber,
            pageSize,
            sortByColumn,
            sortAsc);
        
    }
    
    public int getTableCount(Table table)
    {
        int count = (Integer)(this.getSqlMapClientTemplate().queryForObject("Ctab.getTableCount",table));
        
        return count;
    }
    
    /**
     * 保存资源表
     * 
     * @param table
     */
    public void saveTable(Table table) {
        this.getSqlMapClientTemplate().insert("Ctab.insert", table);
    }
    
    /**
     * 更新资源表
     * @param table
     */
    public void updateTable(Table table) {
        this.getSqlMapClientTemplate().update("Ctab.update", table);
    }
    
    /**
     * 获取单个资源表信息
     * @param table
     * @return
     */
    public Table getTableById(Table table) {
        return (Table)this.getSqlMapClientTemplate().queryForObject("Ctab.getById", table);
    }
    
    /**
     * 根据表名检查是否存在数据表
     * @param params #dbname#-数据库名称  #tbname#-数据表名称
     * @return
     */
    public boolean existTableByName(Map params) {
        String table_name = (String)this.getSqlMapClientTemplate().queryForObject("Ctab.existTableByName", params);
        return StringUtils.isNotBlank(table_name);
    }
    
    /**
     * 保存资源表列信息
     * 
     * @param table
     */
    public void saveTableColumn(Column column) {
        this.getSqlMapClientTemplate().insert("CtabColumn.insert", column);
    }
    
    
    /**
     * 更新资源表列信息
     * @param table
     */
    public void updateTableColumn(Column column) {
        this.getSqlMapClientTemplate().update("CtabColumn.update", column);
    }
    
    /**
     * 查询资源表列信息
     * @param params
     * @return
     */
    public List<Column> queryTableColumnList(Map params) {
        List<Column> colList =
            this.getSqlMapClientTemplate().queryForList("CtabColumn.queryTableColumnList", params);
        
        return colList;
    }
    
    /**
     * 保存资源表展现信息
     * 
     * @param table
     */
    public void saveTableDisp(TableDisp tabDisp) {
        this.getSqlMapClientTemplate().insert("CtabDisp.insert", tabDisp);
    }
    
    /**
     * 更新资源表展现信息
     * @param table
     */
    public void updateTableDisp(TableDisp tabDisp) {
        this.getSqlMapClientTemplate().update("CtabDisp.update", tabDisp);
    }
    
    /**
     * 获取单个资源表展现信息
     * @param table
     * @return
     */
    public TableDisp getTableDispById(TableDisp tabDisp) {
        return (TableDisp)this.getSqlMapClientTemplate().queryForObject("CtabDisp.getById", tabDisp);
    }
    
    /**
     * 根据多个tab_id查询多个CtabDisp数据
     * @param params
     * @return
     */
    public List<TableDisp> getMultipleTableDispById(Map params) {
        return this.getSqlMapClientTemplate().queryForList("CtabDisp.getMultipleByIds", params);
    }
    
    /**
     * 保存资源表列展现信息
     * 
     * @param table
     */
    public void saveTableColumnDisp(ColumnDisp columnDisp) {
        this.getSqlMapClientTemplate().insert("CtabColumnDisp.insert", columnDisp);
    }
    
    
    /**
     * 更新资源表列展现信息
     * @param table
     */
    public void updateTableColumnDisp(ColumnDisp columnDisp) {
        this.getSqlMapClientTemplate().update("CtabColumnDisp.update", columnDisp);
    }
    
    /**
     * 查询资源表列展现信息
     * @param params
     * @return
     */
    public List<ColumnDisp> queryTableColumnDispList(Map params) {
        List<ColumnDisp> colList =
            this.getSqlMapClientTemplate().queryForList("CtabColumnDisp.queryTableColumnDispList", params);
        
        return colList;
    }
    
    /**
     * 查询验证信息
     * @param params
     * @return
     */
    public List<ColumnVerify> queryTableColumnVerifyList(Map params) {
        List<ColumnVerify> colList =
            this.getSqlMapClientTemplate().queryForList("CtabColumnVerify.queryTableColumnVerifyList", params);
        
        return colList;
    }
    
    /**
     * 根据tab_id删除多个表配置
     * @param params
     */
    public void deleteMultipleTable(Map params){
        this.getSqlMapClientTemplate().delete("Ctab.deleteMultiple", params);
    }
    
    /**
     * 根据tab_id删除多个表展现配置
     * @param params
     */
    public void deleteMultipleTableDisp(Map params){
        this.getSqlMapClientTemplate().delete("CtabDisp.deleteMultipleByTabId", params);
    }
    
    /**
     * 根据tab_id删除多个表的列配置
     * @param params
     */
    public void deleteMultipleTableColumn(Map params){
        this.getSqlMapClientTemplate().delete("CtabColumn.deleteMultipleByTabId", params);
    }
    
    /**
     * 根据tab_disp_id删除多个表的列配置
     * @param params
     */
    public void deleteMultipleTableColumnDisp(Map params){
        this.getSqlMapClientTemplate().delete("CtabColumnDisp.deleteMultipleByTabDispId", params);
    }
}
