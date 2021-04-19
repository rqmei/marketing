package lib.android.timingbar.com.base.app;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;


import org.matomo.sdk.Tracker;
import org.matomo.sdk.extra.DimensionQueue;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.multidex.MultiDex;
import lib.android.timingbar.com.base.integration.AppManager;

/**
 * BaseApplication
 * -----------------------------------------------------------------------------------------------------------------------------------
 * 基类application
 *
 * @author rqmei on 2018/1/29
 */

public class BaseApplication extends Application implements IApp {
    private AppDelegateImpl mAppDelegate;
    AppManager appManager;
    /**
     * 自定义维度类
     */
    private DimensionQueue mDimensionQueue;
    /**
     * 系统上下文
     */
    private static Context mAppContext;
    public Tracker tracker = null;
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
        appManager = new AppManager(this);
        mAppContext = getApplicationContext();
        this.mAppDelegate = new AppDelegateImpl(this);
        this.mAppDelegate.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    /**
     * 在模拟环境中程序终止时会被调用
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
        if (mAppDelegate != null)
            this.mAppDelegate.onTerminate();
    }

    /**
     * 将IAppComponent返回出去,供其它地方使用, IAppComponent接口中声明的方法返回的实例,在getAppComponent()拿到对象后都可以直接使用
     *
     * @return IAppComponent实例对象
     */
    @Override
    public AppManager appManager() {
        if (appManager == null) {
            appManager = new AppManager(this);
        }
        return appManager;
    }


    /**
     * 获取系统上下文：用于ToastUtil类
     */
    public static Context getAppContext() {
        return mAppContext;
    }
}
