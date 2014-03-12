package cn.emag.datares.domain;

public class Table {
    
    private String tab_id;
    private String tab_name;
    private String tab_sqlname;
    private String create_time;
    private String update_time;
    
    public String getTab_id() {
        return tab_id;
    }
    public void setTab_id(String tabId) {
        tab_id = tabId;
    }
    public String getTab_name() {
        return tab_name;
    }
    public void setTab_name(String tabName) {
        tab_name = tabName;
    }
    public String getTab_sqlname() {
        return tab_sqlname;
    }
    public void setTab_sqlname(String tabSqlname) {
        tab_sqlname = tabSqlname;
    }
    public String getCreate_time() {
        return create_time;
    }
    public void setCreate_time(String createTime) {
        create_time = createTime;
    }
    public String getUpdate_time() {
        return update_time;
    }
    public void setUpdate_time(String updateTime) {
        update_time = updateTime;
    }
    
}
