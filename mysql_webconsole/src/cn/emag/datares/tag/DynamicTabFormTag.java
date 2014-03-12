package cn.emag.datares.tag;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.tagext.TagSupport;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import cn.emag.datares.domain.Column;
import cn.emag.datares.domain.ColumnDisp;
import cn.emag.datares.domain.Constant;
import cn.emag.datares.domain.ListData;
import cn.emag.datares.domain.Table;
import cn.emag.datares.domain.TableDisp;

public class DynamicTabFormTag extends TagSupport {
    private static final long serialVersionUID = 1L;
    
    public int doEndTag()
        throws JspException {
        try {
            ServletRequest request = this.pageContext.getRequest();
            
            Table table = (Table)request.getAttribute("table");
            TableDisp tableDisp = (TableDisp)request.getAttribute("tableDisp");
            List<Column> columnList = (List<Column>)request.getAttribute("columnList");
            List<ColumnDisp> columnDispList = (List<ColumnDisp>)request.getAttribute("columnDispList");
            
            renderTableForm(table, tableDisp, columnList, columnDispList, request);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }
    
    /**
     * 显示表单数据
     * 
     * @param tableDisp
     * @param colList
     * @param colDispList
     * @param formData
     * @throws Exception
     */
    protected void renderTableForm(Table table, TableDisp tableDisp, List<Column> colList,
        List<ColumnDisp> colDispList, ServletRequest request)
        throws Exception {
        
        Map<String, Object> formData = (Map<String, Object>)request.getAttribute("formData");
        // List<String> formFieldList = (List<String>)request.getAttribute("formFieldList");
        // List<String> formFieldDescList = (List<String>)request.getAttribute("formFieldDescList");
        Map<String, String> primaryKeyMap = (Map<String, String>)request.getAttribute("primaryKeyMap");
        
        Map<String, ListData> listDataMap = (Map<String, ListData>)request.getAttribute("listDataMap");
        
        String tab_sqlname = table.getTab_sqlname();
        
        Map<String, Column> colsMap = new HashMap<String, Column>();
        for (int j = 0; j < colList.size(); j++) {
            Column col = colList.get(j);
            colsMap.put(tab_sqlname + "." + col.getCol_sqlname(), col);
        }
        
        StringBuilder tableBuilder = new StringBuilder();
        
        //新增情况
        if (formData == null) {
            
            for (int i = 0; i < colDispList.size(); i++) {
                ColumnDisp columnDisp = colDispList.get(i);
                // 字段必须支持编辑
                if (Constant.Yes.equals(columnDisp.getSupport_update())) {
                	
                	tableBuilder.append("  <div class=\"control-group\">\n");
                    
                    String field = tab_sqlname + "." + columnDisp.getFull_col_sqlname();
                    
                    Column col = colsMap.get(field);
                    //下拉列表展示
                    if (listDataMap != null && listDataMap.containsKey(field)) {
                        
                        ListData listData = listDataMap.get(field);
                        
                        tableBuilder.append("    <label class=\"control-label\" for=\"\">\n")
                            .append(columnDisp.getForm_disp_name())
                            .append("</label>\n")
                            .append("      <div class=\"controls\"><select name=\"")
                            .append(field)
                            .append("\" id=\"")
                            .append(field.replaceAll("\\.", "_"))
                            .append("\" ");
                        
                        if (Constant.No.equals(col.getIsnullable())) {
                            tableBuilder.append("class=\"required\" ");
                        }
                        
                        tableBuilder.append(">\n");
                        
                        for (int j = 0; j < listData.getValueList().size(); j++) {
                            tableBuilder.append("           <option value=\"")
                                .append(listData.getValueList().get(j))
                                .append("\">");
                            Map<String, List<String>> dataDispList = listData.getDataDispList();
                            Iterator<List<String>> dataListIt = dataDispList.values().iterator();
                            while (dataListIt.hasNext()) {
                                List<String> dataList = dataListIt.next();
                                tableBuilder.append(dataList.get(j)).append(" | ");
                            }
                            
                            if (tableBuilder.substring(tableBuilder.length() - 3, tableBuilder.length()).equals(" | ")) {
                                tableBuilder.delete(tableBuilder.length() - 3, tableBuilder.length());
                            }
                            
                            tableBuilder.append("</option>");
                        }
                        
                        tableBuilder.append("</select>\n");
                        
                        tableBuilder.append("      <span class=\"help-inline\">").append("</span></div>\n");
                        
                        tableBuilder.append("    </div>\n");
                        
                    }
                    else {
                        tableBuilder.append("    <label class=\"control-label\" for=\"\">\n")
                            .append(columnDisp.getForm_disp_name())
                            .append("</label>\n")
                            .append("      <div class=\"controls\"><input name=\"")
                            .append(field)
                            .append("\" id=\"")
                            .append(field.replaceAll("\\.", "_"))
                            .append("\" type=\"text\" value=\"\" ");
                        
                        if (Constant.No.equals(col.getIsnullable())) {
                            tableBuilder.append("class=\"required\" ");
                        }
                        
                        tableBuilder.append("maxlength=\"").append(col.getCol_size()).append("\"/>\n");
                        
                        tableBuilder.append("      <span class=\"help-inline\">不超过")
                            .append(col.getCol_size())
                            .append("个字符</span></div>\n");
                        
                        tableBuilder.append("    </div>\n");
                    }
                    
                }
            }
            
            // 添加操作类型
            tableBuilder.append("<input name=\"operation\" id=\"operation\" value=\"save\" type=\"hidden\" />");
        }
        //修改情况
        else {
            
            Map<String, String> hiddenPrimaryKeyMap = new HashMap<String, String>(primaryKeyMap);
            
            for (int i = 0; i < colDispList.size(); i++) {
                ColumnDisp columnDisp = colDispList.get(i);
                if (Constant.Yes.equals(columnDisp.getIs_in_form())) {
                    
                    String field = tab_sqlname + "." + columnDisp.getFull_col_sqlname();
                    
                    Column col = colsMap.get(field);
                    //下拉列表展示
                    if (listDataMap != null && listDataMap.containsKey(field)) {
                        
                        ListData listData = listDataMap.get(field);
                        
                        if (Constant.Yes.equals(columnDisp.getSupport_update())) {
                        	
                        	tableBuilder.append("  <div class=\"control-group\">\n");
                        	
                            tableBuilder.append("    <label class=\"control-label\" for=\"\">\n")
                                .append(columnDisp.getForm_disp_name())
                                .append("</label>\n")
                                .append("      <div class=\"controls\"><select name=\"")
                                .append(field)
                                .append("\" id=\"")
                                .append(field.replaceAll("\\.", "_"))
                                .append("\" ");
                            
                            if (Constant.No.equals(col.getIsnullable())) {
                                tableBuilder.append("class=\"required\" ");
                            }
                            
                            tableBuilder.append(">\n");
                            
                            for (int j = 0; j < listData.getValueList().size(); j++) {
                                
                                if(formData.get(field)!=null && formData.get(field).toString().equals(listData.getValueList().get(j))){
                                    tableBuilder.append("           <option value=\"")
                                    .append(listData.getValueList().get(j))
                                    .append("\" selected>");
                                }else{
                                    tableBuilder.append("           <option value=\"")
                                    .append(listData.getValueList().get(j))
                                    .append("\">"); 
                                }                              
                                
                                Map<String, List<String>> dataDispList = listData.getDataDispList();
                                Iterator<List<String>> dataListIt = dataDispList.values().iterator();
                                while (dataListIt.hasNext()) {
                                    List<String> dataList = dataListIt.next();
                                    tableBuilder.append(dataList.get(j)).append(" | ");
                                }
                                
                                if (tableBuilder.substring(tableBuilder.length() - 3, tableBuilder.length()).equals(" | ")) {
                                    tableBuilder.delete(tableBuilder.length() - 3, tableBuilder.length());
                                }
                                
                                tableBuilder.append("</option>");
                            }
                            
                            tableBuilder.append("</select>\n");                           
                            
                            tableBuilder.append("      <span class=\"help-inline\">").append("</span></div>\n");
                            
                            // 移出已存在的主键字段
                            if (hiddenPrimaryKeyMap.containsKey(field)) {
                                hiddenPrimaryKeyMap.remove(field);
                            }
                        }
                        else {
                            tableBuilder.append("    <div class=\"control-group\">\n")
                                .append("      <label class=\"control-label\" for=\"\">")
                                .append(columnDisp.getForm_disp_name())
                                .append("</label>\n")
                                .append("      <div class=\"controls\"><label class=\"control-label\" for=\"\">")
                                .append(formData.get(field))
                                .append("</label>\n");
                            
                            tableBuilder.append("      <span class=\"help-inline\"></span></div>\n");
                            
                        }
                        
                        tableBuilder.append("    </div>\n");
                        
                    }
                    else {
                        
                        if (Constant.Yes.equals(columnDisp.getSupport_update())) {
                            tableBuilder.append("    <div class=\"control-group\">\n")
                                .append("      <label class=\"control-label\" for=\"\">")
                                .append(columnDisp.getForm_disp_name())
                                .append("</label>\n")
                                .append("      <div class=\"controls\"><input name=\"")
                                .append(field)
                                .append("\" id=\"")
                                .append(field.replaceAll("\\.", "_"))
                                .append("\" type=\"text\" value=\"")
                                .append(formData.get(field))
                                .append("\" ");
                            
                            if (Constant.No.equals(col.getIsnullable())) {
                                tableBuilder.append("class=\"required\" ");
                            }
                            
                            tableBuilder.append("maxlength=\"").append(col.getCol_size()).append("\"/></td>\n");
                            
                            tableBuilder.append("      <span class=\"help-inline\">不超过")
                                .append(col.getCol_size())
                                .append("个字符</span></div>\n");
                            
                            // 移出已存在的主键字段
                            if (hiddenPrimaryKeyMap.containsKey(field)) {
                                hiddenPrimaryKeyMap.remove(field);
                            }
                        }
                        else {
                            tableBuilder.append("    <div class=\"control-group\">\n")
                                .append("      <label class=\"control-label\" for=\"\">")
                                .append(columnDisp.getForm_disp_name())
                                .append("</label>\n")
                                .append("      <div class=\"controls\"><label class=\"control-label\" for=\"\">")
                                .append(formData.get(field))
                                .append("</label>\n");
                            
                            tableBuilder.append("      <span class=\"help-inline\"></span></div>\n");
                            
                        }
                        
                        tableBuilder.append("    </div>\n");
                        
                    }
                    
                }
            }
            
            //主键添加到隐藏字段
            if (!hiddenPrimaryKeyMap.isEmpty()) {
                Iterator<String> it = hiddenPrimaryKeyMap.keySet().iterator();
                while (it.hasNext()) {
                    String keyfield = it.next();
                    tableBuilder.append("<input name=\"")
                        .append(keyfield)
                        .append("\" id=\"")
                        .append(keyfield.replaceAll("\\.", "_"))
                        .append("\" value=\"")
                        .append(hiddenPrimaryKeyMap.get(keyfield))
                        .append("\" type=\"hidden\" />");
                }
            }
            
            // 添加操作类型
            tableBuilder.append("<input name=\"operation\" id=\"operation\" value=\"update\" type=\"hidden\" />");
        }
        // 添加表单标识ID
        tableBuilder.append("<input name=\"tab_id\" id=\"tab_id\" value=\"")
            .append(table.getTab_id())
            .append("\" type=\"hidden\" />");
        
        JspWriter out = this.pageContext.getOut();
        out.write(tableBuilder.toString());
        
    }
}
