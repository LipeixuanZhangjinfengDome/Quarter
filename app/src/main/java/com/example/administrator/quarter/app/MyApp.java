package com.example.administrator.quarter.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ////kkkkk
        Fresco.initialize(this);
    }
}
