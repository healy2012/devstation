package cn.emag.datares.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.emag.datares.domain.Column;
import cn.emag.datares.domain.ColumnDisp;
import cn.emag.datares.domain.Constant;
import cn.emag.datares.domain.Table;
import cn.emag.datares.domain.TableDisp;

/**
 * 列表批量修改数据组织
 * 
 * @author healy
 * 
 */
public class TableDispForBatchEditHelper extends TableDispHelper {

	public TableDispForBatchEditHelper(Table table, TableDisp tableDisp,
			List<Column> columnList, List<ColumnDisp> columnDispList,
			Map<String, List<ColumnDisp>> subTabColListMap,
			Map<String, Table> subTabMap) {
		super(table, tableDisp, columnList, columnDispList, subTabColListMap,
				subTabMap);
	}

	/**
	 * （初始化）组织展示相关数据
	 */
	protected void init() {
		String main_table_sqlname = table.getTab_sqlname();// 主表名称

		Map<String, Column> colsMap = new HashMap<String, Column>();
		for (int j = 0; j < columnList.size(); j++) {
			Column col = columnList.get(j);
			colsMap.put(col.getCol_sqlname(), col);
		}

		tables.add(table.getTab_sqlname());//查询主表

		// 历遍所有数据，页面展示时区分是否能够修改，不支持查询
		for (int i = 0; i < columnDispList.size(); i++) {
			ColumnDisp colDisp = columnDispList.get(i);

			String col_sqlname = colDisp.getFull_col_sqlname();
			Column col = colsMap.get(col_sqlname);

			fieldsForSql.add(main_table_sqlname + "." + col_sqlname + " as \""
					+ main_table_sqlname + "." + col_sqlname + "\"");
			fields.add(main_table_sqlname + "." + col_sqlname);
			fieldsDesc.add(colDisp.getList_disp_name());

			// 找出主键字段
			if (Constant.Yes.equals(col.getIspk())) {
				prmaryKeysForSql.add(main_table_sqlname + "." + col_sqlname
						+ " as \"" + main_table_sqlname + "." + col_sqlname
						+ "\"");
				prmaryKeys.add(main_table_sqlname + "." + col_sqlname);
			}
		}
	}

}
