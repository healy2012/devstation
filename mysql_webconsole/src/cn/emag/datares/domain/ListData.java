package cn.emag.datares.domain;

import java.util.List;
import java.util.Map;

public class ListData {
    // 主题名称
    private List<String> headNameList;
    
    // 主题名称对应的表字段
    private List<String> headFieldList;
    
    // 主题名称对应的显示名称
    private Map<String, List<String>> dataDispList;
    
    // 列表主值
    private List<String> valueList;
    // 主值字段
    private String valueField;
    
    /**
     * 下拉列表数据
     * @param headNameList 子表展示字段描述
     * @param headFieldList 子表展示字段名
     * @param dataDispListMap 子表展示字段值
     * @param valueList 子表关联主键值列表
     * @param valueField 子表字段全称
     */
    public ListData(List<String> headNameList, List<String> headFieldList, Map<String, List<String>> dataDispListMap,
        List<String> valueList,String valueField) {
        this.headNameList = headNameList;
        this.headFieldList = headFieldList;
        this.dataDispList = dataDispListMap;
        this.valueList = valueList;
        this.valueField = valueField;
    }
    
    public List<String> getHeadNameList() {
        return headNameList;
    }
    
    public void setHeadNameList(List<String> headNameList) {
        this.headNameList = headNameList;
    }
    
    public Map<String, List<String>> getDataDispList() {
        return dataDispList;
    }
    
    public void setDataDispList(Map<String, List<String>> dataDispList) {
        this.dataDispList = dataDispList;
    }
    
    public List<String> getValueList() {
        return valueList;
    }
    
    public void setValueList(List<String> valueList) {
        this.valueList = valueList;
    }
    
    public List<String> getHeadFieldList() {
        return headFieldList;
    }
    
    public void setHeadFieldList(List<String> headFieldList) {
        this.headFieldList = headFieldList;
    }

    public String getValueField() {
        return valueField;
    }

    public void setValueField(String valueField) {
        this.valueField = valueField;
    }  
    
}
