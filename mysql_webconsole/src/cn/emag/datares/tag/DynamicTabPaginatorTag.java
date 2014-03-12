package cn.emag.datares.tag;

import javax.servlet.jsp.tagext.TagSupport;

import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONObject;

import cn.emag.datares.domain.ListData;
import cn.emag.datares.domain.TableDisp;

public class DynamicTabPaginatorTag extends TagSupport {
    private static final long serialVersionUID = 1L;
    
    public int doEndTag()
        throws JspException {
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
            
            TableDisp tableDisp = (TableDisp)this.pageContext.getRequest().getAttribute("tableDisp");
            
            List<Map<String, Object>> pageDataList =
                (List<Map<String, Object>>)this.pageContext.getRequest().getAttribute("pageDataList");
            List<String> fieldList = (List<String>)this.pageContext.getRequest().getAttribute("fieldList");
            List<String> fieldDescList = (List<String>)this.pageContext.getRequest().getAttribute("fieldDescList");
            List<String> queryFieldList = (List<String>)this.pageContext.getRequest().getAttribute("queryFieldList");
            List<String> queryFieldDescList =
                (List<String>)this.pageContext.getRequest().getAttribute("queryFieldDescList");
            List<String> prmaryKeyList = (List<String>)this.pageContext.getRequest().getAttribute("prmaryKeyList");
            
            Map<String, ListData> listDataMap = (Map<String, ListData>)this.pageContext.getRequest().getAttribute("listDataMap");
            
            
            if(tableDisp==null || pageDataList==null || fieldList==null ||fieldDescList==null){
                return EVAL_PAGE;
            }
            
            renderQueryRegion(queryFieldList, queryFieldDescList,listDataMap);
            
            renderDataTable(pageDataList, prmaryKeyList, fieldList, fieldDescList);
            
            //只有一页时不添加分页页脚
            if (pageCount > 1) {
                renderPaginator(pageNumber, pageCount, itemCount, pageSize);
            }
            
            renderButton(tableDisp);
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }
    
    /**
     * 显示查询区域数据
     * @param queryFieldList
     * @param queryFieldDescList
     * @param listDataMap 下拉列表数据
     * @throws Exception
     */
    protected void renderQueryRegion(List<String> queryFieldList, List<String> queryFieldDescList,Map<String, ListData> listDataMap)
        throws Exception {
        
        if (queryFieldList == null || queryFieldList.size() == 0) {
            return;
        }

        StringBuilder queryFormBuilder = new StringBuilder();
        queryFormBuilder.append("<form id=\"search\" method=\"post\" class=\"form-inline\" action=\"datares/dynamicTableList.action").append("\"> \n");
//            .append("  <ul class=\"box_search\">\n");
        for (int i = 0; i < queryFieldList.size(); i++) {
        	String queryField = queryFieldList.get(i);
        	
            queryFormBuilder.append("    <label>")
                .append(queryFieldDescList.get(i))
                .append("：</label>");
            
            ListData listData = listDataMap.get(queryField);
            if(listData==null)
            	queryFormBuilder.append(createInputTextHtml(queryField,queryField.replaceAll("\\.", "_"),null,null));
            else
            	queryFormBuilder.append(createSelectHtml(queryField,queryField.replaceAll("\\.", "_"),null,listData,true));
            
        }
        
        queryFormBuilder.append("<input name=\"tab_id\" value=\"").append(this.pageContext.getRequest().getParameter("tab_id")).append("\" type=\"hidden\" />");
        
        queryFormBuilder.append("      <button type=\"submit\" class=\"btn\">搜 索</button>\n")
            .append("      <button type=\"reset\"  class=\"btn\">重 置</button>")
            .append("  </form>\n");
        
        JspWriter out = this.pageContext.getOut();
        out.write(queryFormBuilder.toString());
        
    }
    
    /**
     * 创建InputText标签
     * @param name
     * @param id
     * @param cssClass
     * @param value
     * @return
     */
    protected String createInputTextHtml(String name,String id,String value,String cssClass){
    	StringBuilder htmlBuilder = new StringBuilder();
    	
    	htmlBuilder.append("<input name=\"").append(name).append("\" id=\"").append(id);
    	
    	if(StringUtils.isBlank(value)){
    		htmlBuilder.append("\" type=\"text\" value=\"\"");
    	}else{
    		htmlBuilder.append("\" type=\"text\" value=\"").append(value).append("\"");
    	}
    	
    	if(StringUtils.isBlank(cssClass)){
    		htmlBuilder.append(" class=\"input-small\"/>");
    	}else{
    		htmlBuilder.append(" class=\"").append(cssClass).append("\"/>");
    	}
    	
    	return htmlBuilder.toString();
    }
    
    
    protected String createInputHiddenHtml(String name,String id,String value){
    	StringBuilder htmlBuilder = new StringBuilder();
    	
    	htmlBuilder.append("<input name=\"").append(name).append("\" id=\"").append(id);
    	
    	if(StringUtils.isBlank(value)){
    		htmlBuilder.append("\" type=\"hidden\" value=\"\" />");
    	}else{
    		htmlBuilder.append("\" type=\"hidden\" value=\"").append(value).append("\" />");
    	}
    	
    	return htmlBuilder.toString();
    }
    
    /**
     * 创建Select标签
     * @param name
     * @param id
     * @param cssClass
     * @param listData 下拉列表数据
     * @param addBlankOption 是否插入空白Option
     * @return
     */
    protected String createSelectHtml(String name,String id,String cssClass,ListData listData,boolean addBlankOption){
    	
    	return createSelectHtml(name,id,cssClass,listData,addBlankOption,null);
    }
    
    /**
     * 创建Select标签
     * @param name
     * @param id
     * @param cssClass
     * @param listData 下拉列表数据
     * @param addBlankOption 是否插入空白Option
     * @param selectedValue 选中值
     * @return
     */
    protected String createSelectHtml(String name,String id,String cssClass,ListData listData,boolean addBlankOption,String selectedValue){
    	StringBuilder htmlBuilder = new StringBuilder();
    	
    	htmlBuilder.append("<select name=\"").append(name).append("\" id=\"").append(id);
    	
    	if(StringUtils.isBlank(cssClass)){
    		htmlBuilder.append("\" class=\"input-small\" >");
    	}else{
    		htmlBuilder.append("\" class=\"").append(cssClass).append("\" >");
    	}
    	
    	if(addBlankOption){
    		htmlBuilder.append("           <option value=\"\"></option>");
    	}
    	
    	for (int j = 0; j < listData.getValueList().size(); j++) {
            
            if(StringUtils.isNotBlank(selectedValue) && selectedValue.equals(listData.getValueList().get(j))){
            	htmlBuilder.append("           <option value=\"")
                .append(listData.getValueList().get(j))
                .append("\" selected>");
            }else{
            	htmlBuilder.append("           <option value=\"")
                .append(listData.getValueList().get(j))
                .append("\">"); 
            }      
            
            Map<String, List<String>> dataDispList = listData.getDataDispList();
            Iterator<List<String>> dataListIt = dataDispList.values().iterator();
            while (dataListIt.hasNext()) {
                List<String> dataList = dataListIt.next();
                htmlBuilder.append(dataList.get(j)).append(" | ");
            }
            
            if (htmlBuilder.substring(htmlBuilder.length() - 3, htmlBuilder.length()).equals(" | ")) {
                htmlBuilder.delete(htmlBuilder.length() - 3, htmlBuilder.length());
            }
            
            htmlBuilder.append("</option>");
        }
        
        htmlBuilder.append("</select>");
    	
    	return htmlBuilder.toString();
    }
    
    /**
     * 显示主表数据
     * 
     * @param colDispList
     * @param Data
     * @throws Exception
     */
    protected void renderDataTable(List<Map<String, Object>> pageDataList, List<String> prmaryKeyList,
        List<String> fieldList, List<String> fieldDescList)
        throws Exception {
        
        StringBuilder dataTableBuilder = new StringBuilder();
        dataTableBuilder.append("<table class=\"table table-striped table-bordered table-condensed\">\n");
        dataTableBuilder.append("    <tr>\n")
            .append("      <th><input name=\"checkAll\" type=\"checkbox\" value=\"全选/取消全选\" /></th>\n");
        
        // 标题
        for (int i = 0; i < fieldDescList.size(); i++) {
            dataTableBuilder.append("      <th>").append(fieldDescList.get(i)).append("</th>\n");
        }
        
        dataTableBuilder.append("    </tr>\n");
        
        for (int i = 0; i < pageDataList.size(); i++) {
            
            Map<String, Object> dataMap = pageDataList.get(i);
            
            dataTableBuilder.append("    </tr>\n");
            
            dataTableBuilder.append("     <tr>\n");
            dataTableBuilder.append("      <td><input name=\"primaryKey\" id=\"primaryKey\" type=\"checkbox\" value='");
            
            // 主键值设置
            JSONObject json = new JSONObject();
            for (int j = 0; j < prmaryKeyList.size(); j++) {
                json.put(prmaryKeyList.get(j), dataMap.get(prmaryKeyList.get(j)));
            }
            
            dataTableBuilder.append(json.toString()).append("' /></td>\n");
            
            for(int k=0;k<fieldList.size();k++){
                dataTableBuilder.append("      <td>").append(dataMap.get(fieldList.get(k))).append("&nbsp;</td>\n");
            }
            
            dataTableBuilder.append("    </tr>\n");
        }
        
        dataTableBuilder.append("</table>\n");
        
        JspWriter out = this.pageContext.getOut();
        out.write(dataTableBuilder.toString());       
    }
    
    /**
     * 显示分页页脚
     * 
     * @param pageNumber
     * @param pageCount
     * @param itemCount
     * @param pageSize
     * @throws Exception
     */
    protected void renderPaginator(int pageNumber, int pageCount, int itemCount, int pageSize)
        throws Exception {
        JspWriter out = this.pageContext.getOut();
        int prevPage = 0;
        int nextPage = 0;
        
        prevPage = pageNumber > 1 ? pageNumber - 1 : 1;
        nextPage = pageNumber < pageCount ? pageNumber + 1 : pageCount;
        out.write("<p/><div class=\"pagination\"><ul>");
        out.write("<span>总计" + itemCount + "条记录</span></ul><ul>");
        if (pageNumber == 1) {
            out.write("<li class=\"disabled\"><span>首页</span></li>");
            out.write("<li class=\"disabled\"><span>上一页</span></li>");
        }
        else {
            out.write("<li><a href=\"" + generatePaginationUrl(1) + "\">首页</a></li>");
            out.write("<li><a href=\"" + generatePaginationUrl(prevPage) + "\">上一页</a></li>");
        }
        
        if (pageNumber == pageCount) {
            out.write("<li class=\"disabled\"><span>下一页</span></li>");
            out.write("<li class=\"disabled\"><span>尾页</span></li>");
        }
        else {
            out.write("<li><a href=\"" + generatePaginationUrl(nextPage) + "\">下一页</a></li>");
            
            out.write("<li><a href=\"" + generatePaginationUrl(pageCount) + "\">尾页</a></li>");
        }
        
        out.write("</ul><ul><li>第<b>" + pageNumber + "/" + pageCount + "</b>页，每页<b>" + pageSize + "</b>条</li></ul>");
        
        out.write(" 跳转至<input id=\"jumpnum\" type=\"text\" onkeypress=\"if ((event.keyCode<48) || (event.keyCode>57 && event.keyCode != 190)) { event.returnValue=false ;}\" onkeyup=\"if (event.keyCode == 13) { onJumpPage(); } \" class=\"input-mini\" />页 <button type=\"button\" onclick=\"onJumpPage()\" class=\"btn\">GO</button>");
        
        out.write("</div>");
        String strscript =
            "function onJumpPage() { \r\n \tvar pageNum = document.getElementById('jumpnum').value ;\r\n\tvar strUrl = document.location.href ; \r\n\tvar newloc ; \r\n \tif (pageNum && (pageNum - 0) > 0) { \r\n   \t\tstrUrl = strUrl.replace(/#/g,'') ; \r\n \t\tif (strUrl.indexOf('pageNumber') != -1) { \r\n   \t\t\tvar reg = /(pageNumber=)(\\d+)/ ; \r\n   \t\t\tnewloc = strUrl.replace(reg,'pageNumber=' + pageNum) ; \r\n\t\t} else if(strUrl.indexOf('?') > 0) { \r\n       \t\tnewloc =  strUrl + '&pageNumber=' + pageNum ; \r\n      \t} else { \r\n          \tnewloc =  strUrl + '?pageNumber=' + pageNum ; \r\n       \t}\t\r\n        document.location = newloc;\r\n\t}\r\n}\r\n";
        
        out.write("\r\n<script language=\"javascript\">\r\n");
        out.write(strscript);
        out.write("</script>\r\n");
    }
    
    /**
     * 显示按钮区域
     * 
     * @param tableDisp
     * @throws Exception
     */
    protected void renderButton(TableDisp tableDisp)
        throws Exception {
        
        String buttonStr =
            "  <div class=\"btn-group\"><!-- box_tool start -->"
                + "    <a href=\"datares/dynamicTabForm.action?tab_id=" + tableDisp.getTab_id() + "\" target=\"systemMainFrame\" class=\"btn btn-large btn-info\" title=\"新建\"><span>新建</span></a>"
                + "    <a href=\"#\" id=\"update\" target=\"systemMainFrame\" class=\"btn btn-large btn-info\" title=\"修改\"><span>修改</span></a>"
                + "    <a href=\"#\" id=\"delete\" target=\"systemMainFrame\" class=\"btn btn-large btn-warning\" title=\"删除\"><span>删除</span></a>"
                + "    <a href=\"datares/dynamicTableListForBatchEdit.action?tab_id=" + tableDisp.getTab_id() + "\" target=\"systemMainFrame\" class=\"btn btn-large btn-success\" title=\"批量编辑\"><span>批量编辑</span></a>"
                + "  </div><!-- box_tool end -->";
        
        JspWriter out = this.pageContext.getOut();
        out.write(buttonStr);
        
    }
    
    protected int getPaginationAttribute(String key) {
        Object value = this.pageContext.getRequest().getAttribute(key);
        if ((value instanceof String))
            return Integer.parseInt((String)value);
        if ((value instanceof Integer)) {
            return ((Integer)value).intValue();
        }
        throw new IllegalStateException("The value can not be parsed as integer.");
    }
    
    protected String generatePaginationUrl(int pageNumber)
        throws Exception {
        HttpServletRequest request = (HttpServletRequest)this.pageContext.getRequest();
        
        Map params = new HashMap();
        Enumeration enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String name = (String)enumeration.nextElement();
            String value = request.getParameter(name);
            params.put(name, value);
        }
        params.put("pageNumber", String.valueOf(pageNumber));
        String path = (String)request.getAttribute("ORIGINAL_SERVLET_PATH");
        
        StringBuffer url = new StringBuffer(request.getContextPath() + path);
        url = url.indexOf("?") != -1 ? url.append("&") : url.append("?");
        Iterator iter = params.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry element = (Map.Entry)iter.next();
            String key = (String)element.getKey();
            String value = (String)element.getValue();
            url.append(key).append("=").append(URLDecoder.decode(value, "utf-8")).append("&");
        }
        
        String result = url.substring(0, url.lastIndexOf("&"));
        return result;
    }
    
    protected int getPageNumber() {
        return getPaginationAttribute("pageNumber");
    }
    
    protected int getPageCount() {
        return getPaginationAttribute("pageCount");
    }
    
    protected int getItemCount() {
        return getPaginationAttribute("itemCount");
    }
    
    protected int getPageSize() {
        return getPaginationAttribute("pageSize");
    }
}
