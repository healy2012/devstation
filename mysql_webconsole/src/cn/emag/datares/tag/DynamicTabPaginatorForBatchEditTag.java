package cn.emag.datares.tag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import net.sf.json.JSONObject;

import cn.emag.datares.domain.Column;
import cn.emag.datares.domain.ColumnDisp;
import cn.emag.datares.domain.Constant;
import cn.emag.datares.domain.ListData;
import cn.emag.datares.domain.Table;
import cn.emag.datares.domain.TableDisp;

public class DynamicTabPaginatorForBatchEditTag extends DynamicTabPaginatorTag {

	private static final long serialVersionUID = 1L;

	public int doEndTag() throws JspException {
		try {
			int pageNumber = getPageNumber();
			int pageCount = getPageCount();
			int itemCount = getItemCount();
			int pageSize = getPageSize();

			if (pageNumber <= 0) {
				pageNumber = 1;
			}
			if (pageNumber >= pageCount) {
				pageNumber = pageCount;
			}

			TableDisp tableDisp = (TableDisp) this.pageContext.getRequest()
					.getAttribute("tableDisp");

			List<Map<String, Object>> pageDataList = (List<Map<String, Object>>) this.pageContext
					.getRequest().getAttribute("pageDataList");
			List<String> fieldList = (List<String>) this.pageContext
					.getRequest().getAttribute("fieldList");
			List<String> fieldDescList = (List<String>) this.pageContext
					.getRequest().getAttribute("fieldDescList");
			List<String> queryFieldList = (List<String>) this.pageContext
					.getRequest().getAttribute("queryFieldList");
			List<String> queryFieldDescList = (List<String>) this.pageContext
					.getRequest().getAttribute("queryFieldDescList");
			List<String> prmaryKeyList = (List<String>) this.pageContext
					.getRequest().getAttribute("prmaryKeyList");

			List<Column> columnList = (List<Column>) this.pageContext
					.getRequest().getAttribute("columnList");
			List<ColumnDisp> columnDispList = (List<ColumnDisp>) this.pageContext
					.getRequest().getAttribute("columnDispList");

			Table table = (Table) this.pageContext.getRequest().getAttribute(
					"table");

			Map<String, ListData> listDataMap = (Map<String, ListData>) this.pageContext
					.getRequest().getAttribute("listDataMap");

			if (tableDisp == null || pageDataList == null || fieldList == null
					|| fieldDescList == null) {
				return EVAL_PAGE;
			}

			// renderQueryRegion(queryFieldList, queryFieldDescList,
			// listDataMap);
			
			JspWriter out = this.pageContext.getOut();
			out.write("<form name=\"batchEditForm\" id=\"batchEditForm\" method=\"post\" action=\"datares/batchEditCommit.action\">");

			renderDataTable(pageDataList, prmaryKeyList, fieldList,
					fieldDescList, listDataMap, columnList, columnDispList,
					table);

			// 只有一页时不添加分页页脚
			if (pageCount > 1) {
				renderPaginator(pageNumber, pageCount, itemCount, pageSize);
			}
			
			renderJavascript(pageDataList, prmaryKeyList, fieldList,
					fieldDescList, listDataMap, columnList, columnDispList,
					table);

			renderButton(tableDisp);
			
			out.write("</form>");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	protected void renderButton(TableDisp tableDisp) throws Exception {

		String buttonStr = "  <div class=\"btn-group\"><!-- box_tool start -->"
				+ "    <button id=\"addNewRow\" type=\"button\" class=\"btn btn-large btn-info\" title=\"新添加一条数据\">添加</button>"
				+ "    <button id=\"deleteRow\" type=\"button\" class=\"btn btn-large btn-info\" title=\"删除指定行数据\">删除</button>"
				+ "    <button type=\"submit\" class=\"btn btn-large btn-primary\" title=\"保存所有数据\">提交</button>"
				+ "  </div><!-- box_tool end -->";

		JspWriter out = this.pageContext.getOut();
		out.write(buttonStr);

	}

	/**
	 * 创建批量编辑表数据
	 * @param pageDataList
	 * @param prmaryKeyList
	 * @param fieldList
	 * @param fieldDescList
	 * @param listDataMap
	 * @param columnList
	 * @param columnDispList
	 * @param table
	 * @throws Exception
	 */
	protected void renderDataTable(List<Map<String, Object>> pageDataList,
			List<String> prmaryKeyList, List<String> fieldList,
			List<String> fieldDescList, Map<String, ListData> listDataMap,
			List<Column> columnList, List<ColumnDisp> columnDispList,
			Table table) throws Exception {

		StringBuilder dataTableBuilder = new StringBuilder();
		
		dataTableBuilder.append(createInputHiddenHtml("tab_id","tab_id",table.getTab_id()));
		
		dataTableBuilder
				.append("<table id=\"dataTable\" class=\"table table-striped table-bordered table-condensed\">\n");
		dataTableBuilder
				.append("    <tr>\n")
				.append("      <th><input name=\"checkAll\" type=\"checkbox\" value=\"全选/取消全选\" /></th>\n");

		Map<String, Integer> colsMap = new HashMap<String, Integer>();
		for (int j = 0; j < columnList.size(); j++) {
			Column col = columnList.get(j);
			colsMap.put(table.getTab_sqlname() + "." + col.getCol_sqlname(), j);
		}

		// 标题
		for (int i = 0; i < fieldDescList.size(); i++) {
			String currentField = fieldList.get(i);
			int n = colsMap.get(currentField);
			ColumnDisp colDisp = columnDispList.get(n);

			// 在表单中展示
			if (Constant.Yes.equals(colDisp.getIs_in_form()))
				dataTableBuilder.append("      <th>")
						.append(fieldDescList.get(i)).append("</th>\n");
		}

		dataTableBuilder.append("    </tr>\n");

		for (int i = 0; i < pageDataList.size(); i++) {

			Map<String, Object> dataMap = pageDataList.get(i);

			dataTableBuilder.append("     <tr id=\"dataRow_").append(i).append("\">\n");
			dataTableBuilder
					.append("      <td><input name=\"primaryKey\" id=\"primaryKey\" type=\"checkbox\" value=\"");

			// 主键值设置
			JSONObject json = new JSONObject();
			for (int j = 0; j < prmaryKeyList.size(); j++) {
				json.put(prmaryKeyList.get(j),
						dataMap.get(prmaryKeyList.get(j)));
			}

			dataTableBuilder.append(json.toString()).append("\" />");

			// 插入隐藏标识，标注用户操作
			dataTableBuilder.append(createInputHiddenHtml("tableData[" + i
					+ "].userOperation__", "tableData_" + i
					+ "__userOperation__", "updateRow"));

			dataTableBuilder.append("</td>\n");

			for (int k = 0; k < fieldList.size(); k++) {
				String currentField = fieldList.get(k);
				String currentValue = dataMap.get(currentField) == null ? ""
						: dataMap.get(currentField).toString();

				int n = colsMap.get(currentField);
				ColumnDisp colDisp = columnDispList.get(n);

				String htmlName = "tableData[" + i + "]."
						+ colDisp.getFull_col_sqlname();
				/*String htmlName = "tableData[" + i + "]['"
						+ colDisp.getFull_col_sqlname()+"']";*/
				
				String htmlId = "tableData_" + i + "__"
						+ colDisp.getFull_col_sqlname();

				ListData listData = listDataMap.get(currentField);

				// 在表单中展示
				if (Constant.Yes.equals(colDisp.getIs_in_form())) {

					// 字段支持修改，并且不是主键字段
					if (Constant.Yes.equals(colDisp.getSupport_update())
							&& !prmaryKeyList.contains(currentField)) {
						if (listData == null) {// 不是下拉列表
							dataTableBuilder
									.append("      <td>")
									.append(createInputTextHtml(htmlName,
											htmlId, currentValue, null))
									.append("&nbsp;</td>\n");
						} else {
							dataTableBuilder
									.append("      <td>")
									.append(createSelectHtml(htmlName, htmlId,
											null, listData, false, currentValue))
									.append("&nbsp;</td>\n");
						}
					} else {// 不能修改只展示值，同时添加隐藏字段
						dataTableBuilder
								.append("      <td>")
								.append(currentValue)
								.append(createInputHiddenHtml(htmlName, htmlId,
										currentValue)).append("&nbsp;</td>\n");
					}
				} else {// 不展示字段
					dataTableBuilder.append(createInputHiddenHtml(htmlName,
							htmlId, currentValue));
				}

			}

			dataTableBuilder.append("    </tr>\n");
		}

		dataTableBuilder.append("</table>\n");

		JspWriter out = this.pageContext.getOut();
		out.write(dataTableBuilder.toString());
	}
	
	/**
	 * 创建新增行数据的html模板
	 * @param pageDataList
	 * @param prmaryKeyList
	 * @param fieldList
	 * @param fieldDescList
	 * @param listDataMap
	 * @param columnList
	 * @param columnDispList
	 * @param table
	 * @throws Exception
	 */
	protected void renderJavascript(List<Map<String, Object>> pageDataList,
			List<String> prmaryKeyList, List<String> fieldList,
			List<String> fieldDescList, Map<String, ListData> listDataMap,
			List<Column> columnList, List<ColumnDisp> columnDispList,
			Table table) throws Exception {

		StringBuilder scriptBuilder = new StringBuilder();

		scriptBuilder.append("\r\n<script language=\"javascript\">\r\n");

		Map<String, Integer> colsMap = new HashMap<String, Integer>();
		for (int j = 0; j < columnList.size(); j++) {
			Column col = columnList.get(j);
			colsMap.put(table.getTab_sqlname() + "." + col.getCol_sqlname(), j);
		}
		
		scriptBuilder.append("var trTemplet =");

		String i = "IDTOBEREPLACE";
		
		scriptBuilder.append("     '<tr id=\"dataRow_").append(i)
				.append("\">'+\n");
		scriptBuilder
				.append("      '<td><input name=\"primaryKey\" id=\"primaryKey\" type=\"checkbox\" value=\"");

		scriptBuilder.append("\" />");
		
		// 插入隐藏标识，标注用户操作
		scriptBuilder.append(createInputHiddenHtml("tableData[" + i
				+ "].userOperation__", "tableData_" + i + "__userOperation__",
				"newRow"));

		scriptBuilder.append("</td>'+\n");

		for (int k = 0; k < fieldList.size(); k++) {
			String currentField = fieldList.get(k);
			String currentValue = "";

			int n = colsMap.get(currentField);
			ColumnDisp colDisp = columnDispList.get(n);

			String htmlName = "tableData[" + i + "]."
					+ colDisp.getFull_col_sqlname();

			String htmlId = "tableData_" + i + "__"
					+ colDisp.getFull_col_sqlname();

			ListData listData = listDataMap.get(currentField);

			// 在表单中展示
			if (Constant.Yes.equals(colDisp.getIs_in_form())) {

				// 字段支持修改，并且不是主键字段
				if (Constant.Yes.equals(colDisp.getSupport_update())
						&& !prmaryKeyList.contains(currentField)) {
					if (listData == null) {// 不是下拉列表
						scriptBuilder
								.append("      '<td>")
								.append(createInputTextHtml(htmlName, htmlId,
										currentValue, null))
								.append("&nbsp;</td>'+\n");
					} else {
						scriptBuilder
								.append("      '<td>")
								.append(createSelectHtml(htmlName, htmlId,
										null, listData, false, currentValue))
								.append("&nbsp;</td>'+\n");
					}
				} else {// 不能修改只展示值，同时添加隐藏字段
					scriptBuilder.append("      '<td>").append(currentValue)
							.append("&nbsp;</td>'+\n");
				}
			}

		}

		scriptBuilder.append("    '</tr>';\n");

		scriptBuilder.append("</script>\r\n");

		JspWriter out = this.pageContext.getOut();
		out.write(scriptBuilder.toString());

	}
}
