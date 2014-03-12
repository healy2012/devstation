package cn.emag.datares.web.action;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import cn.emag.datares.domain.Column;
import cn.emag.datares.domain.ColumnDisp;
import cn.emag.datares.domain.ListData;
import cn.emag.datares.domain.Table;
import cn.emag.datares.domain.TableDisp;
import cn.emag.datares.service.DynamicTableService;
import cn.emag.datares.service.TableDispForBatchEditHelper;
import cn.emag.datares.service.TableDispHelper;
import cn.emag.datares.service.TableFormHelper;
import cn.emag.datares.service.TableService;
import cn.emag.framework.action.BaseAction;
import cn.emag.framework.spring.SpringContextHolder;

public class TableDisplayAction extends BaseAction {
    
    private static final long serialVersionUID = 1L;
    
    public static final int DEFAULT_PAGE_SIZE = 10;
    
    public static final String PAGE_NUMBER = "pageNumber";
    
    public static final String PAGE_COUNT = "pageCount";
    
    public static final String ITEM_COUNT = "itemCount";
    
    public static final String PAGE_SIZE = "pageSize";
    
    public static final String OPERATION_SAVE = "save";
    
    public static final String OPERATION_UPDATE = "update";
    
    public static final String OPERATION_DELETE = "delete";   
    
    private String tab_id;
    /**传递给页面的错误提示信息*/
    private String errorMsg;
    /**传递给页面的成功提示信息*/
	private String successMsg;
    
    TableService tableService = (TableService)SpringContextHolder.getService("tableService");
    
    DynamicTableService dynamicTableService =
        (DynamicTableService)SpringContextHolder.getService("dynamicTableService");
    
    /**
     * 动态列表分页
     * @return
     * @throws Exception
     */
    public String dynamicTabPaginator()
        throws Exception {
        HttpServletRequest request = getRequest();
        String tab_id = request.getParameter("tab_id");
        
        if (StringUtils.isNotBlank(tab_id)) {
            Table table = tableService.getTableById(tab_id);
            TableDisp tableDisp = tableService.getTableDispByTabId(tab_id);
            if (table != null && tableDisp != null) {
                List<Column> columnList = tableService.queryTableColumnList(tab_id);
                List<ColumnDisp> columnDispList = tableService.queryTableColumnDispList(tableDisp.getTab_disp_id());
                
                setTabListData(table, tableDisp, columnList, columnDispList);
                
            }
            else {
                return ERROR;
            }
        }
        else {
            return ERROR;
        }
        return SUCCESS;
    }
    
    /**
     * 动态列表分页(批量编辑)
     * @return
     * @throws Exception
     */
	public String dynamicTabPaginatorForBatchEdit() throws Exception {
		HttpServletRequest request = getRequest();
		String tab_id = request.getParameter("tab_id");

		if (StringUtils.isNotBlank(tab_id)) {
			Table table = tableService.getTableById(tab_id);
			TableDisp tableDisp = tableService.getTableDispByTabId(tab_id);
			if (table != null && tableDisp != null) {
				List<Column> columnList = tableService
						.queryTableColumnList(tab_id);
				List<ColumnDisp> columnDispList = tableService
						.queryTableColumnDispList(tableDisp.getTab_disp_id());

				setTabListDataForBatchEdit(table, tableDisp, columnList, columnDispList);

			} else {
				return ERROR;
			}
		} else {
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 批量编辑后提交
	 * @return
	 * @throws Exception
	 */
	public String batchEditCommit() throws Exception {

		if (StringUtils.isNotBlank(tab_id)) {

			List<Map<String, String>> tableData = bandingListMap();

			if (tableData != null) {

				Table table = tableService.getTableById(tab_id);
				TableDisp tableDisp = tableService.getTableDispByTabId(tab_id);
				List<Column> columnList = null;
				List<ColumnDisp> columnDispList = null;
				if (table != null && tableDisp != null) {
					columnList = tableService.queryTableColumnList(tab_id);
					columnDispList = tableService
							.queryTableColumnDispList(tableDisp
									.getTab_disp_id());
				}

				List<Map<String, String>> updateList = new ArrayList<Map<String, String>>();
				List<Map<String, String>> addList = new ArrayList<Map<String, String>>();
				List<Map<String, String>> deleteList = new ArrayList<Map<String, String>>();

				TableFormHelper tableFormHelper = new TableFormHelper();
				List<String> primaryKeyList = TableFormHelper
						.getPrimaryKeyList(columnList);

				for (int i = 0; i < tableData.size(); i++) {
					Map<String, String> rowData = tableData.get(i);

					if (rowData != null) {
						String userOperation = rowData.get("userOperation__");
						if (userOperation.equals("newRow")) {
							addList.add(rowData);
						} else if (userOperation.equals("updateRow")) {
							if (isValidateRecord(primaryKeyList, rowData))
								updateList.add(rowData);
						} else if (userOperation.equals("deletedRow")) {
							if (isValidateRecord(primaryKeyList, rowData))
								deleteList.add(rowData);
						}
					}

					/*Iterator<String> it = rowData.keySet().iterator();
					while (it.hasNext()) {
						String key = it.next();
						String value = rowData.get(key);
						System.out
								.println(i + "key:" + key + ";value:" + value);
					}*/
				}

				// 批量执行insert
				for (int j = 0; j < addList.size(); j++) {
					Map<String, String> rowData = addList.get(j);
					dynamicTableService.insertSql(tableFormHelper.getInsertSql(
							table, tableDisp, columnList, columnDispList,
							rowData));
				}

				for (int j = 0; j < updateList.size(); j++) {
					Map<String, String> rowData = updateList.get(j);
					dynamicTableService.updateSql(tableFormHelper.getUpdateSql(
							table, tableDisp, columnList, columnDispList,
							rowData));
				}

				List<String> deleteSqlList = tableFormHelper.getDeleteSql(
						table, tableDisp, columnList, columnDispList,
						primaryKeyList, deleteList);

				String[] sql = new String[deleteSqlList.size()];

				for (int i = 0; i < deleteSqlList.size(); i++) {
					sql[i] = deleteSqlList.get(i);
				}

				if(sql.length>0)
					dynamicTableService.deleteMultipleSql(sql);
				
				//设置批量编辑展示页面数据
				setTabListDataForBatchEdit(table, tableDisp, columnList, columnDispList);
				
				setSuccessMsg("数据更新成功");

			}
		}
		return SUCCESS;
	}
	
	/**
	 * 检查数据主键值是否存在
	 * @param primaryKeyList
	 * @param rowData
	 * @return
	 */
	private boolean isValidateRecord(List<String> primaryKeyList,Map<String, String> rowData){
		boolean success = true;
		
		if(primaryKeyList!=null && rowData!=null && primaryKeyList.size()>0){
			for(int i=0;i<primaryKeyList.size();i++){
				String key = primaryKeyList.get(i);
				String value = rowData.get(key);
				if(StringUtils.isBlank(value)){
					success = false;
				}
			}
		}else{
			success = false;
		}
		
		return success;
	}
	
	/**
	 * 将表单数据绑定到List
	 * @return
	 */
	private List<Map<String,String>> bandingListMap(){
		List<Map<String,String>> tableData = new ArrayList<Map<String,String>>();
		HashMap<String,HashMap<String,String>> temp = new  HashMap<String,HashMap<String,String>>();
		
		HttpServletRequest request = getRequest();
		Enumeration parameterName = request.getParameterNames();
		while(parameterName.hasMoreElements()){
			String key = (String)parameterName.nextElement();
			String value = request.getParameter(key);
			if(StringUtils.isNotBlank(key) && key.startsWith("tableData[")){
				String index = key.substring("tableData[".length(),key.lastIndexOf("]."));
				String fieldName = key.substring(key.lastIndexOf("].")+2);
				if(temp.get(index)==null){
					HashMap<String,String> rows = new HashMap<String,String>();
					rows.put(fieldName, value);
					temp.put(index, rows);
				}else{
					HashMap<String,String> rows = temp.get(index);
					rows.put(fieldName, value);
				}
				
			}
		}
		
		for(int i=0;i<temp.size();i++){
			tableData.add(temp.get(String.valueOf(i)));
		}
		
		return tableData;
	}
    
    /**
     * 动态表单展示及处理
     * @return
     * @throws Exception
     */
    public String dynamicTabForm()
        throws Exception {
        HttpServletRequest request = getRequest();
        String tab_id = request.getParameter("tab_id");
        String primaryKey = request.getParameter("primaryKey");
        String operation = request.getParameter("operation");
        if (StringUtils.isNotBlank(tab_id)) {
            Table table = tableService.getTableById(tab_id);
            TableDisp tableDisp = tableService.getTableDispByTabId(tab_id);
            if (table != null && tableDisp != null) {
                List<Column> columnList = tableService.queryTableColumnList(tab_id);
                List<ColumnDisp> columnDispList = tableService.queryTableColumnDispList(tableDisp.getTab_disp_id());
                
                if (OPERATION_SAVE.equals(operation)) {//新增保存
                    saveTabForm(table, tableDisp, columnList, columnDispList);
                }
                else if (OPERATION_UPDATE.equals(operation)) {//更新
                    updateTabForm(table, tableDisp, columnList, columnDispList);
                }else if(OPERATION_DELETE.equals(operation)){//删除
                    List<Map<String, String>> pkMapList = parsePrimaryKeyList(primaryKey);  
                    if(pkMapList!=null){
                        deleteTableRecords(table, tableDisp, columnList, columnDispList, pkMapList);
                    }
                    
                    this.tab_id = tab_id;                    
                    return "deleteSuccess";
                }
                else {//修改前加载原始数据
                    List<Map<String, String>> pkMapList = parsePrimaryKeyList(primaryKey);
                    
                    Map<String, String> pkMap = null;
                    
                    if (pkMapList != null && !pkMapList.isEmpty()) {
                        pkMap = pkMapList.get(0);
                    }
                    
                    // 设置表单相关的数据
                    setTabFormData(table, tableDisp, columnList, columnDispList, pkMap);
                }
                
            }
            else {
                return ERROR;
            }
        }
        else {
            return ERROR;
        }
        return SUCCESS;
    }
    
    /**
     * 设置分页展示相关的各项数据
     * @param table
     * @param tableDisp
     * @param columnList
     * @param columnDispList
     * @throws Exception
     */
    private void setTabListData(Table table, TableDisp tableDisp, List<Column> columnList,
        List<ColumnDisp> columnDispList)
        throws Exception {
        
        Map<String, List<ColumnDisp>> subTabColListMap = new HashMap<String, List<ColumnDisp>>();//主表字段与子表字段的映射关系
        Map<String, Table> subTabMap = new HashMap<String, Table>();//主表字段与子表信息的映射关系
        
        for (int i = 0; i < columnList.size(); i++) {
            
            Column column = columnList.get(i);
            
            // 主表仅关联子表情况
            if ((StringUtils.isBlank(column.getDatadict()) || Integer.parseInt(column.getDatadict()) <= 0)
                && StringUtils.isNotBlank(column.getSub_tab_id()) && Integer.parseInt(column.getSub_tab_id()) > 0) {
                Table subTable = tableService.getTableById(column.getSub_tab_id());
                subTabMap.put(column.getCol_sqlname(), subTable);
                
                TableDisp subTabDisp = tableService.getTableDispByTabId(column.getSub_tab_id());
                
                List<ColumnDisp> tmpList = tableService.queryTableColumnDispList(subTabDisp.getTab_disp_id());
                subTabColListMap.put(column.getCol_sqlname(), tmpList);
            }
        }
        
        TableDispHelper tableDispHelper =
            new TableDispHelper(table, tableDisp, columnList, columnDispList, subTabColListMap, subTabMap);
        
        Map<String, ListData> listDataMap = dynamicTableService.getDataList(table, columnList, columnDispList,subTabColListMap,subTabMap);
        
        HttpServletRequest request = getRequest();
        HttpServletResponse response = getResponse();
        int itemCount = getItemCount(tableDispHelper, request, response);
        
        int pageSize = Integer.parseInt(tableDisp.getPage_count());
        if (pageSize <= 0) {
            pageSize = getDefaultPageSize();
        }
        
        int pageCount = itemCount / pageSize + (itemCount % pageSize == 0 ? 0 : 1);
        int pageNumber = getPageNumber(request);
        if (pageNumber > pageCount) {
            pageNumber = pageCount;
        }
        if (pageNumber <= 0) {
            pageNumber = 1;
        }
        request.setAttribute("pageNumber", Integer.valueOf(pageNumber));
        request.setAttribute("pageCount", Integer.valueOf(pageCount));
        request.setAttribute("itemCount", Integer.valueOf(itemCount));
        request.setAttribute("pageSize", Integer.valueOf(pageSize));
        
        request.setAttribute("tableDisp", tableDisp);
        
        if (listDataMap != null) {
        	request.setAttribute("listDataMap", listDataMap);//查询条件项下拉列表
        }
        
        setPageData(tableDispHelper, request, response, pageNumber, pageSize);
    }
    
    /**
     * 设置分页批量修改所需要的数据
     * @param table
     * @param tableDisp
     * @param columnList
     * @param columnDispList
     * @throws Exception
     */
	private void setTabListDataForBatchEdit(Table table, TableDisp tableDisp,
			List<Column> columnList, List<ColumnDisp> columnDispList)
			throws Exception {

		Map<String, List<ColumnDisp>> subTabColListMap = new HashMap<String, List<ColumnDisp>>();// 主表字段与子表字段的映射关系
		Map<String, Table> subTabMap = new HashMap<String, Table>();// 主表字段与子表信息的映射关系

		for (int i = 0; i < columnList.size(); i++) {

			Column column = columnList.get(i);

			// 主表仅关联子表情况
			if ((StringUtils.isBlank(column.getDatadict()) || Integer
					.parseInt(column.getDatadict()) <= 0)
					&& StringUtils.isNotBlank(column.getSub_tab_id())
					&& Integer.parseInt(column.getSub_tab_id()) > 0) {
				Table subTable = tableService.getTableById(column
						.getSub_tab_id());
				subTabMap.put(column.getCol_sqlname(), subTable);

				TableDisp subTabDisp = tableService.getTableDispByTabId(column
						.getSub_tab_id());

				List<ColumnDisp> tmpList = tableService
						.queryTableColumnDispList(subTabDisp.getTab_disp_id());
				subTabColListMap.put(column.getCol_sqlname(), tmpList);
			}
		}

		TableDispForBatchEditHelper tableDispForBatchEditHelper = new TableDispForBatchEditHelper(table, tableDisp,
				columnList, columnDispList, subTabColListMap, subTabMap);

		Map<String, ListData> listDataMap = dynamicTableService.getDataList(
				table, columnList, columnDispList, subTabColListMap, subTabMap);

		HttpServletRequest request = getRequest();
		HttpServletResponse response = getResponse();
		int itemCount = getItemCount(tableDispForBatchEditHelper, request, response);

		int pageSize = Integer.parseInt(tableDisp.getPage_count());
		if (pageSize <= 0) {
			pageSize = getDefaultPageSize();
		}

		int pageCount = itemCount / pageSize
				+ (itemCount % pageSize == 0 ? 0 : 1);
		int pageNumber = getPageNumber(request);
		if (pageNumber > pageCount) {
			pageNumber = pageCount;
		}
		if (pageNumber <= 0) {
			pageNumber = 1;
		}
		request.setAttribute("pageNumber", Integer.valueOf(pageNumber));
		request.setAttribute("pageCount", Integer.valueOf(pageCount));
		request.setAttribute("itemCount", Integer.valueOf(itemCount));
		request.setAttribute("pageSize", Integer.valueOf(pageSize));

		request.setAttribute("tableDisp", tableDisp);

		if (listDataMap != null) {
			request.setAttribute("listDataMap", listDataMap);// 所有的主表字段下拉列表
		}

		setPageData(tableDispForBatchEditHelper, request, response, pageNumber, pageSize);
		
		request.setAttribute("table", table);
		request.setAttribute("tableDisp", tableDisp);
		request.setAttribute("columnList", columnList);
		request.setAttribute("columnDispList", columnDispList);
	}

    /**
     * 向request对象设置表单展示所需要的数据
     * @param table
     * @param tableDisp
     * @param columnList
     * @param columnDispList
     * @param pkMap
     */
    private void setTabFormData(Table table, TableDisp tableDisp, List<Column> columnList,
        List<ColumnDisp> columnDispList, Map<String, String> pkMap) {
        
        TableFormHelper tableFormHelper = new TableFormHelper();
        
        List<Map<String, Object>> formDataList =
            dynamicTableService.getListData(tableFormHelper.getQuerySql(table,
                tableDisp,
                columnList,
                columnDispList,
                pkMap));
        
        if (formDataList != null && formDataList.size() > 0) {
            getRequest().setAttribute("formData", formDataList.get(0));
        }
        
        Map<String, List<ColumnDisp>> subTabColListMap = new HashMap<String, List<ColumnDisp>>();
        Map<String, Table> subTabMap = new HashMap<String, Table>();
        
        for (int i = 0; i < columnList.size(); i++) {
            
            Column column = columnList.get(i);
            
            // 主表仅关联子表情况
            if ((StringUtils.isBlank(column.getDatadict()) || Integer.parseInt(column.getDatadict()) <= 0)
                && StringUtils.isNotBlank(column.getSub_tab_id()) && Integer.parseInt(column.getSub_tab_id()) > 0) {
                Table subTable = tableService.getTableById(column.getSub_tab_id());
                subTabMap.put(column.getCol_sqlname(), subTable);
                
                TableDisp subTabDisp = tableService.getTableDispByTabId(column.getSub_tab_id());
                
                List<ColumnDisp> tmpList = tableService.queryTableColumnDispList(subTabDisp.getTab_disp_id());
                subTabColListMap.put(column.getCol_sqlname(), tmpList);
            }
        }
        
        Map<String, ListData> listDataMap = dynamicTableService.getDataList(table, columnList, columnDispList,subTabColListMap,subTabMap);
        
        /*
         * List<String> formFieldList = tableFormHelper.getFormFieldList(); List<String> formFieldDescList =
         * tableFormHelper.getFormFieldDescList();
         * 
         * if (formFieldList != null) getRequest().setAttribute("formFieldList", formFieldList); if (formFieldDescList
         * != null) getRequest().setAttribute("formFieldDescList", formFieldDescList);
         */

        if (pkMap != null)
            getRequest().setAttribute("primaryKeyMap", pkMap);
        if (listDataMap != null) {
            getRequest().setAttribute("listDataMap", listDataMap);
        }
        
        getRequest().setAttribute("table", table);
        getRequest().setAttribute("tableDisp", tableDisp);
        getRequest().setAttribute("columnList", columnList);
        getRequest().setAttribute("columnDispList", columnDispList);
        
    }
    
    private Map<String, String> parsePrimaryKey(String pk) {
        
        if (StringUtils.isBlank(pk)) {
            return null;
        }
        
        JSONObject json = JSONObject.fromObject(pk);
        Iterator it = json.keys();
        
        Map<String, String> pkMap = new HashMap<String, String>();
        
        while (it.hasNext()) {
            String key = (String)it.next();
            pkMap.put(key, json.getString(key));
        }
        
        return pkMap;
    }
    
    private List<Map<String, String>> parsePrimaryKeyList(String pkList) {
        
        if (StringUtils.isBlank(pkList)) {
            return null;
        }
        
        String pkArray[] = pkList.split("},");
        
        List<Map<String, String>> pkMapList = new ArrayList<Map<String, String>>();
        
        for (int i = 0; i < pkArray.length; i++) {
            if (StringUtils.isNotBlank(pkArray[i])) {
                Map<String, String> pkMap = parsePrimaryKey(pkArray[i] + "}");
                pkMapList.add(pkMap);
            }
        }
        
        return pkMapList;
    }
    
    private void saveTabForm(Table table, TableDisp tableDisp, List<Column> columnList, List<ColumnDisp> columnDispList) {
        
        HttpServletRequest request = getRequest();
        
        TableFormHelper tableFormHelper = new TableFormHelper();
        
        // 数据插入后返回自增字段值
        long generatedKey =
            dynamicTableService.insertSql(tableFormHelper.getInsertSql(table,
                tableDisp,
                columnList,
                columnDispList,
                request));
        
        Map<String, String> pkMap = tableFormHelper.getPrimaryKeyMap();
        
        if (generatedKey > 0) {
            Iterator<String> it = pkMap.keySet().iterator();
            
            while (it.hasNext()) {
                String key = it.next();
                if (pkMap.get(key) == null) {
                    pkMap.put(key, String.valueOf(generatedKey));
                }
            }
        }
        
        // 查询数据库获取数据记录
        setTabFormData(table, tableDisp, columnList, columnDispList, pkMap);
        
    }
    
    private void updateTabForm(Table table, TableDisp tableDisp, List<Column> columnList,
        List<ColumnDisp> columnDispList) {
        
        TableFormHelper tableFormHelper = new TableFormHelper();
        
        dynamicTableService.updateSql(tableFormHelper.getUpdateSql(table,
            tableDisp,
            columnList,
            columnDispList,
            getRequest()));
        
        Map<String, String> pkMap = tableFormHelper.getPrimaryKeyMap();
        
        // 查询数据库获取数据记录
        setTabFormData(table, tableDisp, columnList, columnDispList, pkMap);
        
    }
    
    private void deleteTableRecords(Table table, TableDisp tableDisp, List<Column> columnList,
        List<ColumnDisp> columnDispList,List<Map<String, String>> pkMapList) {
        
        TableFormHelper tableFormHelper = new TableFormHelper();
        
        List<String> deleteSqlList = tableFormHelper.getDeleteSql(table,
            tableDisp,
            columnList,
            columnDispList,
            pkMapList);
        
        
        String[] sql = new String[deleteSqlList.size()];
        
        for(int i=0;i<deleteSqlList.size();i++){
            sql[i] = deleteSqlList.get(i);
        }
        
        dynamicTableService.deleteMultipleSql(sql);
        
    }
    
    protected int getItemCount(TableDispHelper tableDispHelper, HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        
        return dynamicTableService.getCount(tableDispHelper.getCountSql(request));
        
    }
    
    protected void setPageData(TableDispHelper tableDispHelper, HttpServletRequest request,
        HttpServletResponse response, int pageNumber, int pageSize)
        throws Exception {
        
        List<Map<String, Object>> pageDataList =
            dynamicTableService.getListData(tableDispHelper.getPageQuerySql(pageNumber, pageSize, request));
        
        List<String> fieldList = tableDispHelper.getFieldList();
        List<String> fieldDescList = tableDispHelper.getFieldDescList();
        List<String> queryFieldList = tableDispHelper.getQueryFieldList();
        List<String> queryFieldDescList = tableDispHelper.getQueryFieldDescList();
        List<String> prmaryKeyList = tableDispHelper.getPrmaryKeyList();
        
        request.setAttribute("pageDataList", pageDataList);
        request.setAttribute("fieldList", fieldList);
        request.setAttribute("fieldDescList", fieldDescList);
        request.setAttribute("queryFieldList", queryFieldList);
        request.setAttribute("queryFieldDescList", queryFieldDescList);
        request.setAttribute("prmaryKeyList", prmaryKeyList);
    }
    
    private int getDefaultPageSize() {
        return DEFAULT_PAGE_SIZE;
    }
    
    protected int getPageNumber(HttpServletRequest request) {
        Object value = request.getAttribute(PAGE_NUMBER);
        if (value == null) {
            value = request.getParameter(PAGE_NUMBER);
        }
        if (value instanceof String) {
            return Integer.parseInt((String)value);
        }
        else if (value instanceof Integer) {
            return ((Integer)value).intValue();
        }
        else {
            return 1;
        }
    }

    public String getTab_id() {
        return tab_id;
    }

    public void setTab_id(String tabId) {
        tab_id = tabId;
    }

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getSuccessMsg() {
		return successMsg;
	}

	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}
    
    

}
