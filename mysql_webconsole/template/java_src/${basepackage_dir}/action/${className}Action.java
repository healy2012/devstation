<#include "/custom.include">
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign actionExtension = "action">
package ${basepackage}.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.org.rapid_framework.beanutils.BeanUtils;
import cn.org.rapid_framework.web.scope.Flash;

import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.ModelDriven;

<#include "/java_imports.include">

public class ${className}Action extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "to_list";
	
	private ${className}Manager ${classNameLower}Manager;
	
	private ${className} ${classNameLower};
	<#list table.compositeIdColumns as column>
	${column.javaType} id = null;
	</#list>
	private String[] items;

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			${classNameLower} = new ${className}();
		} else {
			${classNameLower} = (${className})${classNameLower}Manager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,注意大小写 */
	public void set${className}Manager(${className}Manager manager) {
		this.${classNameLower}Manager = manager;
	}	
	
	public Object getModel() {
		return ${classNameLower};
	}
	
	<#list table.compositeIdColumns as column>
	public void set${column.columnName}(${column.javaType} val) {
		this.id = val;
	}
	</#list>	

	public void setItems(String[] items) {
		this.items = items;
	}
	
	/** 执行搜索 */
	public String list() {
		${className}Query query = newQuery(${className}Query.class,DEFAULT_SORT_COLUMNS);
		
		Page page = ${classNameLower}Manager.findPage(query);
		savePage(page,query);
		return SUCCESS;
	}
	
	/** 查看对象*/
	public String show() {
		<#list table.pkColumns as column>
		${classNameLower} = (${className})${classNameLower}Manager.getById(${classNameLower}.get${column.columnName}());
		</#list>
		return SUCCESS;
	}
	
	/** 进入新增页面*/
	public String create() {
		return SUCCESS;
	}
	
	/** 保存新增对象 */
	public String save() {
		${classNameLower}Manager.save(${classNameLower});
		return LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		Hashtable params = HttpUtils.parseQueryString(items[0]);
		<#if table.compositeId>
		${className}Id id = (${className}Id)copyProperties(${className}Id.class,params);
		<#else>
			<#list table.compositeIdColumns as column>
		${column.javaType} id = new ${column.javaType}((String)params.get("${column.columnNameLower}"));
			</#list>
		</#if>
		${classNameLower} = (${className})${classNameLower}Manager.getById(id);
		return SUCCESS;
	}
	
	/**保存更新对象*/
	public String update() {
		${classNameLower}Manager.update(this.${classNameLower});
		return LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			<#if table.compositeId>
			${className}Id id = (${className}Id)copyProperties(${className}Id.class,params);
			<#else>
				<#list table.compositeIdColumns as column>
			${column.javaType} id = new ${column.javaType}((String)params.get("${column.columnNameLower}"));
				</#list>
			</#if>
			${classNameLower}Manager.removeById(id);
		}
		return LIST_ACTION;
	}

}
