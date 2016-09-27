package com.uestczhh.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by zhanghao on 2016/9/26.
 */
public class BaseApplication extends Application {
    private static Context instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Context getInstance() {
        return instance;
    }
}
