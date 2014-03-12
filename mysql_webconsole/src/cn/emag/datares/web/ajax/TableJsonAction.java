package cn.emag.datares.web.ajax;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.emag.datares.domain.Column;
import cn.emag.datares.service.TableService;
import cn.emag.framework.action.JsonAction;
import cn.emag.framework.spring.SpringContextHolder;

public class TableJsonAction extends JsonAction {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    TableService tableService = (TableService)SpringContextHolder.getService("tableService");
    
    private static Log log = LogFactory.getLog(TableJsonAction.class);
    
    /**列出直接子类*/
    public void getColumnListById(){
        

        String tab_id = getStringParameter("tab_id");
        List<Column> colList = tableService.queryTableColumnList(tab_id);
        
//        JSONObject json = new JSONObject();
//        json.put("result", colList);
//        JSONObject json = JSONObject.fromObject(colList);
        JSONArray json =JSONArray.fromObject(colList);
        
        log.debug("TableJsonAction--result: " + json.toString());
        
        try {
            serializer(json);
        } catch (IOException e) {
            e.printStackTrace();
            //IO 异常
            log.error(e.getMessage(), e);
        }
    }
}
