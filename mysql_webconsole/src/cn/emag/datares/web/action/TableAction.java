package cn.emag.datares.web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import cn.emag.datares.domain.Column;
import cn.emag.datares.domain.ColumnDisp;
import cn.emag.datares.domain.Constant;
import cn.emag.datares.domain.Table;
import cn.emag.datares.domain.TableDisp;
import cn.emag.datares.service.TableService;
import cn.emag.framework.action.PaginationAction;
import cn.emag.framework.spring.SpringContextHolder;
import cn.emag.system.domain.BaseData;
import cn.emag.system.service.BaseDataService;

public class TableAction extends PaginationAction {

	private static final long serialVersionUID = 1L;

	private List<Column> cols;

	private Table table;

	private TableDisp tableDisp;

	private List<ColumnDisp> colsDisp;

	private List<Table> tabList;

	private List<BaseData> dataDictList;

	private List<Table> subTabList;

	private Map<String, List<Column>> subTabColListMap;

	private String errorMsg;
	
	private String successMsg;

	TableService tableService = (TableService) SpringContextHolder
			.getService("tableService");

	BaseDataService baseDataService = (BaseDataService) SpringContextHolder
			.getService("baseDataService");

	/**
	 * 获取所有的数据表配置列表信息
	 * @return
	 * @throws Exception
	 */
	public String getAllTable() throws Exception {		
		
		List<Table> tempList = tableService.queryTableList(null,
				"tab_id");
		this.setTabList(tempList);
		
		return SUCCESS;
	}

	/**
	 * 获取物理表配置信息
	 * @return
	 * @throws Exception
	 */
	public String getDbTableConfig() throws Exception {

		HttpServletRequest request = getRequest();
		String tab_id = request.getParameter("tab_id");

		if (StringUtils.isNotBlank(tab_id)) {

			if (tab_id.endsWith(",")) {
				tab_id = tab_id.substring(0, tab_id.length() - 1);
			}

			Table table = tableService.getTableById(tab_id);
			if (table != null) {

				setDbTableData(table);

			} else {
				setErrorMsg("数据表不存在");
			}
		}

		return SUCCESS;
	}
	
	/**
	 * 加载并设置物理数据表字段信息
	 * @param parameterTable
	 */
	private void setDbTableData(Table parameterTable) throws Exception {
		if (parameterTable != null) {			

			List<Column> collst = tableService.queryTableColumnList(parameterTable.getTab_id());
			List<BaseData> bdList = baseDataService.findDataWithChild();
			List<Table> subTabList = tableService
					.queryTableList(null, "tab_id");

			Map<String, List<Column>> subTabColListMap = new HashMap<String, List<Column>>();
			List<Column> emptyList = new ArrayList<Column>();

			for (int i = 0; i < collst.size(); i++) {
				Column col = collst.get(i);
				if (StringUtils.isNotBlank(col.getSub_tab_id())) {
					List<Column> tmpList = tableService
							.queryTableColumnList(col.getSub_tab_id());
					subTabColListMap.put(col.getCol_sqlname(), tmpList);
				} else {
					subTabColListMap.put(col.getCol_sqlname(), emptyList);
				}
			}

			// 数据字典列表插入空值
			if (bdList != null) {
				BaseData bd = new BaseData();
				bd.setBdId(new Integer(0));
				bd.setBdValue("");
				bdList.add(0, bd);
			}

			if (subTabList != null) {
				// 从子表列表中剔除自身
				for (int i = 0; i < subTabList.size(); i++) {
					Table t = subTabList.get(i);
					if (parameterTable.getTab_id().equals(t.getTab_id())) {
						subTabList.remove(i);
					}
				}

				Table t = new Table();
				t.setTab_id("0");
				t.setTab_name("");
				subTabList.add(0, t);
			}
			
			this.setTable(parameterTable);
			this.setCols(collst);
			this.setDataDictList(bdList);
			this.setSubTabList(subTabList);
			this.setSubTabColListMap(subTabColListMap);
		}
	}

	/**
	 * 更新物理表配置信息
	 * @return
	 * @throws Exception
	 */
	public String updateDbTableConfig() throws Exception {

		if (table != null && StringUtils.isNotBlank(table.getTab_id())) {
			// 更新数据
			tableService.updateTable(table);

			if (cols != null && cols.size() > 0) {
				for (int i = 0; i < cols.size(); i++) {
					Column column = cols.get(i);
					tableService.updateTableColumn(table, column);
				}

			}

			setDbTableData(table);
			
			setSuccessMsg("配置更新成功");

		}
		return SUCCESS;
	}

	/**
	 * 获取数据表展示配置信息
	 * @return
	 * @throws Exception
	 */
	public String getTableDispConfig() throws Exception {

		HttpServletRequest request = getRequest();
		String tab_id = request.getParameter("tab_id");

		if (StringUtils.isNotBlank(tab_id)) {
			
			Table table = tableService.getTableById(tab_id);
			if (table != null) {
				setTableDispData(table);
			} else {
				setErrorMsg("数据表不存在");
			}			
		}

		return SUCCESS;
	}
	
	/**
	 * 加载并设置数据表展示信息
	 * @param parameterTable
	 * @throws Exception
	 */
	private void setTableDispData(Table parameterTable) throws Exception {
		if (parameterTable!=null && StringUtils.isNotBlank(parameterTable.getTab_id())) {
			
			this.setTable(parameterTable);
			
			List<Column> collst = tableService.queryTableColumnList(parameterTable.getTab_id());
			
			if (collst != null && collst.size() > 0) {
				
				Map<String, List<Column>> subTabColListMap = new HashMap<String, List<Column>>();
				List<Column> emptyList = new ArrayList<Column>();

				for (int i = 0; i < collst.size(); i++) {
					Column column = collst.get(i);

					// 主表仅关联子表情况
					if ((StringUtils.isBlank(column.getDatadict()) || Integer
							.parseInt(column.getDatadict()) <= 0)
							&& StringUtils.isNotBlank(column
									.getSub_tab_id())
							&& Integer.parseInt(column.getSub_tab_id()) > 0) {
						List<Column> tmpList = tableService
								.queryTableColumnList(column
										.getSub_tab_id());
						subTabColListMap.put(column.getCol_sqlname(),
								tmpList);
					} else {
						subTabColListMap.put(column.getCol_sqlname(),
								emptyList);
					}
				}
				//设置关联的子表信息Map
				this.setSubTabColListMap(subTabColListMap);
			}
			
			// 获取展现配置数据
			TableDisp tableDisp = tableService.getTableDispByTabId(parameterTable.getTab_id());
			//未配置展现数据情况
			if (tableDisp == null) {
				tableDisp = new TableDisp();
				tableDisp.setTab_id(parameterTable.getTab_id());
				this.setTableDisp(tableDisp);

				List<ColumnDisp> colDisplst = new ArrayList<ColumnDisp>();
				for (int i = 0; collst != null && i < collst.size(); i++) {
					Column column = collst.get(i);
					ColumnDisp colDisp = new ColumnDisp();
					colDisp.setFull_col_sqlname(column.getCol_sqlname());
					colDisp.setForm_disp_name(column.getCol_desc());
					colDisp.setList_disp_name(column.getCol_desc());

					colDisplst.add(colDisp);
				}
				this.setColsDisp(colDisplst);

			} else {
				List<ColumnDisp> colDisplst = tableService
						.queryTableColumnDispList(tableDisp.getTab_disp_id());

				this.setTableDisp(tableDisp);
				this.setColsDisp(colDisplst);
			}				
		}
	}
	
	/**
	 * 更新数据表展示配置信息
	 * @return
	 * @throws Exception
	 */
	public String updateTableDispConfig() throws Exception {

		if (tableDisp != null
				&& StringUtils.isNotBlank(tableDisp.getTab_disp_id())) {

			tableService.updateTableDisp(tableDisp);

			if (colsDisp != null && colsDisp.size() > 0) {
				for (int i = 0; i < colsDisp.size(); i++) {
					tableService.updateTableColumnDisp(tableDisp,
							colsDisp.get(i));

				}
			}

			Table table = tableService.getTableById(tableDisp.getTab_id());
			if (table != null) {
				setTableDispData(table);
				setSuccessMsg("配置更新成功");
			} else {
				setErrorMsg("数据表不存在");
			}

		}
		return SUCCESS;
	}

	public String saveTable() throws Exception {

		if (table != null) {

			System.out.println(table.getTab_name());
			System.out.println(table.getTab_sqlname());

			if (tableService.existTableByName(table)) {

				// 检查数据表是否已经配置过
				Table searchCondition = new Table();
				searchCondition.setTab_sqlname(table.getTab_sqlname());
				List<Table> configuredTableList = tableService.queryTableList(
						searchCondition, null);
				if (configuredTableList != null
						&& configuredTableList.size() > 0
						&& StringUtils.isNotBlank(configuredTableList.get(0)
								.getTab_id())) {
					setErrorMsg("当前数据表已经配置过，不能重复配置");
					return "errorPage";
				}

				List<Column> collst = tableService
						.queryTableColumnFromDB(table);
				List<BaseData> bdList = baseDataService.findDataWithChild();
				List<Table> subTabList = tableService.queryTableList(null,
						"tab_id");

				// 插入空值
				if (bdList != null) {
					BaseData bd = new BaseData();
					bd.setBdId(new Integer(0));
					bd.setBdValue("");
					bdList.add(0, bd);
				}

				if (subTabList != null) {
					Table t = new Table();
					t.setTab_id("0");
					t.setTab_name("");
					subTabList.add(0, t);
				}

				this.setCols(collst);
				this.setDataDictList(bdList);
				this.setSubTabList(subTabList);

			} else {
				setErrorMsg("数据表不存在");
				return "errorPage";
			}

			/*
			 * List<Column> collst = new ArrayList<Column>(); for (int i = 0; i
			 * < 5; i++) { Column tmp = new Column(); tmp.setCol_desc("desc测试" +
			 * i); tmp.setCol_size("size" + i); tmp.setCol_sqlname("sqlname" +
			 * i); collst.add(tmp); System.out.println("Column:" + tmp); }
			 */
		}

		return SUCCESS;
	}

	/**
	 * 保存资源表物理模型
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveTabModel() throws Exception {

		// 保存数据
		if (table != null && StringUtils.isBlank(table.getTab_id())) {
			tableService.saveTable(table);

			System.out.println(table.getTab_name());
			System.out.println(table.getTab_sqlname());
			System.out.println("table.getTab_id():" + table.getTab_id());

			List<ColumnDisp> colDisplst = new ArrayList<ColumnDisp>();

			if (cols != null && cols.size() > 0) {

				Map<String, List<Column>> subTabColListMap = new HashMap<String, List<Column>>();
				List<Column> emptyList = new ArrayList<Column>();

				for (int i = 0; i < cols.size(); i++) {

					Column column = cols.get(i);
					tableService.saveTableColumn(table, cols.get(i));

					ColumnDisp colDisp = new ColumnDisp();
					colDisp.setFull_col_sqlname(column.getCol_sqlname());
					colDisp.setForm_disp_name(column.getCol_desc());
					colDisp.setList_disp_name(column.getCol_desc());
					// 默认无查询条件
					colDisp.setSupport_query(Constant.No);
					// 主键默认不支持编辑
					if (Constant.Yes.equals(column.getIspk())) {
						colDisp.setSupport_update(Constant.No);
					}

					colDisplst.add(colDisp);

					// 主表关联子表情况
					if ((StringUtils.isBlank(column.getDatadict()) || Integer
							.parseInt(column.getDatadict()) <= 0)
							&& StringUtils.isNotBlank(column.getSub_tab_id())
							&& Integer.parseInt(column.getSub_tab_id()) > 0) {
						List<Column> tmpList = tableService
								.queryTableColumnList(column.getSub_tab_id());
						subTabColListMap.put(column.getCol_sqlname(), tmpList);

					} else {
						subTabColListMap
								.put(column.getCol_sqlname(), emptyList);
					}
				}

				this.setSubTabColListMap(subTabColListMap);
			}

			TableDisp tableDisp = new TableDisp();
			tableDisp.setTab_id(table.getTab_id());

			this.setTableDisp(tableDisp);

			this.setColsDisp(colDisplst);

		} else if (table != null && StringUtils.isNotBlank(table.getTab_id())) {
			// 更新数据
			tableService.updateTable(table);

			if (cols != null && cols.size() > 0) {
				Map<String, List<Column>> subTabColListMap = new HashMap<String, List<Column>>();
				List<Column> emptyList = new ArrayList<Column>();

				for (int i = 0; i < cols.size(); i++) {

					Column column = cols.get(i);

					tableService.updateTableColumn(table, cols.get(i));

					// 主表仅关联子表情况
					if ((StringUtils.isBlank(column.getDatadict()) || Integer
							.parseInt(column.getDatadict()) <= 0)
							&& StringUtils.isNotBlank(column.getSub_tab_id())
							&& Integer.parseInt(column.getSub_tab_id()) > 0) {
						List<Column> tmpList = tableService
								.queryTableColumnList(column.getSub_tab_id());
						subTabColListMap.put(column.getCol_sqlname(), tmpList);
					} else {
						subTabColListMap
								.put(column.getCol_sqlname(), emptyList);
					}
				}

				this.setSubTabColListMap(subTabColListMap);
			}

			// 获取展现配置数据
			TableDisp tableDisp = tableService.getTableDispByTabId(table
					.getTab_id());
			if (tableDisp == null) {
				tableDisp = new TableDisp();
				tableDisp.setTab_id(table.getTab_id());
				this.setTableDisp(tableDisp);

				List<ColumnDisp> colDisplst = new ArrayList<ColumnDisp>();
				for (int i = 0; i < cols.size(); i++) {
					Column column = cols.get(i);
					ColumnDisp colDisp = new ColumnDisp();
					colDisp.setFull_col_sqlname(column.getCol_sqlname());
					colDisp.setForm_disp_name(column.getCol_desc());
					colDisp.setList_disp_name(column.getCol_desc());

					colDisplst.add(colDisp);
				}
				this.setColsDisp(colDisplst);

			} else {
				List<ColumnDisp> colDisplst = tableService
						.queryTableColumnDispList(tableDisp.getTab_disp_id());

				this.setTableDisp(tableDisp);
				this.setColsDisp(colDisplst);
			}

		}
		return SUCCESS;
	}

	/**
	 * 保存资源模型展示信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveTabModelDisp() throws Exception {

		//新建
		if (tableDisp != null
				&& StringUtils.isBlank(tableDisp.getTab_disp_id())) {
			tableService.saveTableDisp(tableDisp);

			System.out.println("tableDisp.getTab_disp_id():"
					+ tableDisp.getTab_disp_id());

			if (colsDisp != null && colsDisp.size() > 0) {
				for (int i = 0; i < colsDisp.size(); i++) {
					tableService
							.saveTableColumnDisp(tableDisp, colsDisp.get(i));

				}
			}

		//修改	
		} else if (tableDisp != null
				&& StringUtils.isNotBlank(tableDisp.getTab_disp_id())) {

			tableService.updateTableDisp(tableDisp);

			if (colsDisp != null && colsDisp.size() > 0) {
				for (int i = 0; i < colsDisp.size(); i++) {
					tableService.updateTableColumnDisp(tableDisp,
							colsDisp.get(i));

				}
			}

		}

		return SUCCESS;
	}

	/**
	 * 删除资源表配置
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteTable() throws Exception {

		HttpServletRequest request = getRequest();
		String tab_id = request.getParameter("tab_id");

		if (StringUtils.isNotBlank(tab_id)) {

			if (tab_id.endsWith(",")) {
				tab_id = tab_id.substring(0, tab_id.length() - 1);
			}

			List<TableDisp> tabDispList = tableService
					.getMultipleTableDispById(tab_id);
			StringBuilder tab_disp_id = new StringBuilder();

			for (int i = 0; tabDispList != null && i < tabDispList.size(); i++) {
				tab_disp_id.append(tabDispList.get(i).getTab_disp_id()).append(
						",");
			}

			if (tab_disp_id.length() > 0) {
				tab_disp_id.delete(tab_disp_id.length() - 1,
						tab_disp_id.length());
			}

			tableService.deleteMultipleTableColumnDisp(tab_disp_id.toString());
			tableService.deleteMultipleTableDisp(tab_id);
			tableService.deleteMultipleTableColumn(tab_id);
			tableService.deleteMultipleTable(tab_id);

		}

		return SUCCESS;
	}

	/**
	 * 更新资源表配置
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateTable() throws Exception {

		HttpServletRequest request = getRequest();
		String tab_id = request.getParameter("tab_id");

		if (StringUtils.isNotBlank(tab_id)) {

			if (tab_id.endsWith(",")) {
				tab_id = tab_id.substring(0, tab_id.length() - 1);
			}

			Table table = new Table();
			table = tableService.getTableById(tab_id);
			if (table != null) {

				this.setTable(table);

				List<Column> collst = tableService.queryTableColumnList(tab_id);
				List<BaseData> bdList = baseDataService.findDataWithChild();
				List<Table> subTabList = tableService.queryTableList(null,
						"tab_id");

				Map<String, List<Column>> subTabColListMap = new HashMap<String, List<Column>>();
				List<Column> emptyList = new ArrayList<Column>();

				for (int i = 0; i < collst.size(); i++) {
					Column col = collst.get(i);
					if (StringUtils.isNotBlank(col.getSub_tab_id())) {
						List<Column> tmpList = tableService
								.queryTableColumnList(col.getSub_tab_id());
						subTabColListMap.put(col.getCol_sqlname(), tmpList);
					} else {
						subTabColListMap.put(col.getCol_sqlname(), emptyList);
					}
				}

				// 插入空值
				if (bdList != null) {
					BaseData bd = new BaseData();
					bd.setBdId(new Integer(0));
					bd.setBdValue("");
					bdList.add(0, bd);
				}

				if (subTabList != null) {
					// 从子表列表中剔除自身
					for (int i = 0; i < subTabList.size(); i++) {
						Table t = subTabList.get(i);
						if (tab_id.equals(t.getTab_id())) {
							subTabList.remove(i);
						}
					}

					Table t = new Table();
					t.setTab_id("0");
					t.setTab_name("");
					subTabList.add(0, t);
				}

				this.setCols(collst);
				this.setDataDictList(bdList);
				this.setSubTabList(subTabList);
				this.setSubTabColListMap(subTabColListMap);

			} else {
				setErrorMsg("数据表不存在");
				return "errorPage";
			}
		}

		return SUCCESS;
	}

	protected String executePaginationAction(HttpServletRequest request,
			HttpServletResponse response, int pageNumber, int pageSize)
			throws Exception {

		tabList = tableService
				.queryTableListByPage(table, pageNumber, pageSize);

		return SUCCESS;
	}

	protected int getItemCount(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return tableService.getTableCount(table);

	}

	public List<Column> getCols() {
		return cols;
	}

	public void setCols(List<Column> cols) {
		this.cols = cols;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public TableDisp getTableDisp() {
		return tableDisp;
	}

	public void setTableDisp(TableDisp tableDisp) {
		this.tableDisp = tableDisp;
	}

	public List<ColumnDisp> getColsDisp() {
		return colsDisp;
	}

	public void setColsDisp(List<ColumnDisp> colsDisp) {
		this.colsDisp = colsDisp;
	}

	public List<Table> getTabList() {
		return tabList;
	}

	public void setTabList(List<Table> tabList) {
		this.tabList = tabList;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public List<BaseData> getDataDictList() {
		return dataDictList;
	}

	public void setDataDictList(List<BaseData> dataDictList) {
		this.dataDictList = dataDictList;
	}

	public List<Table> getSubTabList() {
		return subTabList;
	}

	public void setSubTabList(List<Table> subTabList) {
		this.subTabList = subTabList;
	}

	public Map<String, List<Column>> getSubTabColListMap() {
		return subTabColListMap;
	}

	public void setSubTabColListMap(Map<String, List<Column>> subTabColListMap) {
		this.subTabColListMap = subTabColListMap;
	}

	public String getSuccessMsg() {
		return successMsg;
	}

	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}

	
}
