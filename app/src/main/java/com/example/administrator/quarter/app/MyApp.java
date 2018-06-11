package com.example.administrator.quarter.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

public class MyApp extends Application {
    {
        PlatformConfig.setWeixin("wx396ea2b17e2f8938", "e21c38fb0064a9631b05957f6bec73bd");
        PlatformConfig.setQQZone("1106891201", "AbTHOw2b0ZwUiKTO");
    }
    @Override
    public void onCreate() {
        super.onCreate();
        ////kkkkk
        Fresco.initialize(this);
        UMConfigure.init(this,"5b1d08edb27b0a5e77000292"
                ,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"");//58edcfeb310c93091c000be2 5965ee00734be40b580001a0
    }
}
