package cn.emag.datares.domain;

public class Column {
    private String tab_id;
    private String col_sqlname;
    private String col_sqltype;
    private String col_size;
    private String col_desc;
    private String isnullable;
    private String ispk;
    private String datadict;
    private String sub_tab_id;
    private String sub_tab_col_sqlname;
    private String validation_type;
    private String create_time;
    private String update_time;
    public String getTab_id() {
        return tab_id;
    }
    public void setTab_id(String tabId) {
        tab_id = tabId;
    }
    public String getCol_sqlname() {
        return col_sqlname;
    }
    public void setCol_sqlname(String colSqlname) {
        col_sqlname = colSqlname;
    }
    public String getCol_sqltype() {
        return col_sqltype;
    }
    public void setCol_sqltype(String colSqltype) {
        col_sqltype = colSqltype;
    }
    public String getCol_size() {
        return col_size;
    }
    public void setCol_size(String colSize) {
        col_size = colSize;
    }
    public String getCol_desc() {
        return col_desc;
    }
    public void setCol_desc(String colDesc) {
        col_desc = colDesc;
    }
    public String getIsnullable() {
        return isnullable;
    }
    public void setIsnullable(String isnullable) {
        this.isnullable = isnullable;
    }
    public String getIspk() {
        return ispk;
    }
    public void setIspk(String ispk) {
        this.ispk = ispk;
    }
    public String getDatadict() {
        return datadict;
    }
    public void setDatadict(String datadict) {
        this.datadict = datadict;
    }
    public String getSub_tab_id() {
        return sub_tab_id;
    }
    public void setSub_tab_id(String subTabId) {
        sub_tab_id = subTabId;
    }
    public String getSub_tab_col_sqlname() {
        return sub_tab_col_sqlname;
    }
    public void setSub_tab_col_sqlname(String subTabColSqlname) {
        sub_tab_col_sqlname = subTabColSqlname;
    }
    public String getValidation_type() {
        return validation_type;
    }
    public void setValidation_type(String validationType) {
        validation_type = validationType;
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
