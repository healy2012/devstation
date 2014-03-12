package cn.emag.datares.web.action;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class ListMapConverter extends StrutsTypeConverter{

	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		System.out.println("===convertFromString===");
		// TODO Auto-generated method stub
		for(int i=0 ;i<arg1.length;i++){
			System.out.println("arg1["+i+"]:"+arg1[i]);
		}
		
		return null;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		System.out.println("===convertToString===");
		return null;
	}

}
