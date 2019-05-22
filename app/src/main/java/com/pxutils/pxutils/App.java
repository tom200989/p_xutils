package com.pxutils.pxutils;

import android.app.Application;

import org.xutils.x;

/*
 * Created by qianli.ma on 2019/1/11 0011.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(false);
    }
}
