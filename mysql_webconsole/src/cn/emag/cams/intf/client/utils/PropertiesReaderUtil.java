package cn.emag.cams.intf.client.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class PropertiesReaderUtil
{
    private static Properties pro;
    
    private static boolean init = false;
    
    public static void init(String file)
    {
        
        if (null == pro)
        {
            pro = new Properties();
        }
        InputStream is = null;
        try
        {
            is = new FileInputStream(PropertiesReaderUtil.class.getResource("/").getPath() + file);
            pro.load(is);
            init = true;
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (null != is)
            {
                try
                {
                    is.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static Properties getPro()
    {
    	if(init)
    		return pro;
    	else{
    		init("ClientConfig.properties");
    		return pro;
    	}		
    }
}