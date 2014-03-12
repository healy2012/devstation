package cn.emag.datares.dbmodel.util;

public class SystemHelper {
    public static boolean isWindowsOS = System.getProperty("os.name").toLowerCase().indexOf("windows")>= 0;
}
