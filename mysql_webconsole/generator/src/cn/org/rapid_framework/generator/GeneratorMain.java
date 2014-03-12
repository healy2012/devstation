package cn.org.rapid_framework.generator;

import java.net.URL;
import java.util.Properties;


/**
 * 
 * @author badqiu
 * @email badqiu(a)gmail.com
 */

public class GeneratorMain {
	/**
	 * 请直接修改以下代码调用不同的方法以执行相关生成任务.
	 */
	public static void main(String[] args) throws Exception {
		System.setProperty("gg.isOverride", "true");//是否覆盖原来程序
		Properties p =	System.getProperties();
		URL src = GeneratorMain.class.getResource("/");
		String path = src.getPath().replace("web/WEB-INF/classes/", "");
		GeneratorProperties.setProperty("outRoot", path);//让自动生成的程序文件在本工程中
		
		GeneratorFacade g = new GeneratorFacade();
//		g.printAllTableNames();				//打印数据库中的表名称
		
		//g.deleteOutRootDir();							//删除生成器的输出目录
//		g.generateByTable("tb_z_gang_level_info","template");	//通过数据库表生成文件,template为模板的根目录
		
		g.generateByTable("tb_g_gang","template");
		g.generateByTable("tb_g_gang_announce","template");
		g.generateByTable("tb_g_gang_apply","template");
		g.generateByTable("tb_g_gang_battle","template");
		g.generateByTable("tb_g_gang_battle_detail","template");
		g.generateByTable("tb_g_gang_member","template");
		g.generateByTable("tb_g_gang_message","template");
		g.generateByTable("tb_g_gang_skill","template");
		g.generateByTable("tb_g_gang_user_skill","template");
		g.generateByTable("tb_z_gang_battle_conf","template");
		g.generateByTable("tb_z_gang_level_info","template");
		g.generateByTable("tb_z_gang_role_info","template");
		g.generateByTable("tb_z_gang_skill","template");
		g.generateByTable("tb_z_gang_skill_level","template");
		
//		g.generateByAllTable("template");	//自动搜索数据库中的所有表并生成文件,template为模板的根目录
//		g.generateByClass(Blog.class,"template_clazz");
		 
//		g.deleteByTable("table_name", "template"); //删除生成的文件
		System.out.println("输出目录:"+GeneratorProperties.getRequiredProperty("outRoot"));
		//打开文件夹 
		Runtime.getRuntime().exec("cmd.exe /h start "+path);
		
		
	}
}
