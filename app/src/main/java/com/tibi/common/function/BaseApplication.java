package com.tibi.common.function;

import android.app.Application;
import android.content.Context;

import com.tibi.common.function.lib.api.HttpApi;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.multidex.MultiDex;

public class BaseApplication extends Application {
    /**
     *vector 兼容5.0以下系统
     */
    static {
        /*获取当前系统的android版本号*/
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion < 21)//适配android5.0以下
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
    @Override
    public void onCreate() {
        super.onCreate();
        HttpApi.initEasyHttp(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

}
