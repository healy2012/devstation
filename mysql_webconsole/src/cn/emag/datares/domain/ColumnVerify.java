package cn.emag.datares.domain;

public class ColumnVerify {
    private String validation_type;
    private String regular_exp;
    private String message;
    private String validation_desc;
    private String create_time;
    private String update_time;
    public String getValidation_type() {
        return validation_type;
    }
    public void setValidation_type(String validationType) {
        validation_type = validationType;
    }
    public String getRegular_exp() {
        return regular_exp;
    }
    public void setRegular_exp(String regularExp) {
        regular_exp = regularExp;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getValidation_desc() {
        return validation_desc;
    }
    public void setValidation_desc(String validationDesc) {
        validation_desc = validationDesc;
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
