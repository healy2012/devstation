package cn.emag.cams.intf.client.timer;

import java.util.TimerTask;

import cn.emag.cams.intf.client.bean.CamsCacheData;
import cn.emag.cams.intf.client.service.CamsCacheDataFactory;

public class ManageCamsCacheDataTask extends TimerTask
{
    @Override
    public void run()
    {
        CamsCacheData cacheData = CamsCacheDataFactory.getInstance().getCamsCacheData();
        
        String systemId = cacheData.getSystemId();
        
        CamsCacheDataFactory.getInstance().init(systemId);
        
    }
    
}
