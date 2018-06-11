package com.example.administrator.quarter.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

public class MyApp extends Application {
    {
        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        PlatformConfig.setQQZone("1106891201", "AbTHOw2b0ZwUiKTO");
        PlatformConfig.setYixin("yxc0614e80c9304c11b0391514d09f13bf");
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
