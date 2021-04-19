package com.tibi.common.function;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.tibi.common.function.lib.api.HttpApi;

import androidx.appcompat.app.AppCompatDelegate;

public class BaseApplication extends Application {
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
