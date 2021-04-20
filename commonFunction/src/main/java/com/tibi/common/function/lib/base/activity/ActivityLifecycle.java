package com.tibi.common.function.lib.base.activity;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.tibi.common.function.lib.base.fragment.FragmentLifecycle;
import com.tibi.common.function.lib.base.integration.AppManager;
import com.tibi.common.function.lib.base.integration.IConfigModule;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

/**
 * ActivityLifecycle
 * -------------------------------------------------------------------------------------------------
 * 用于对应用中Activity 和 fragment的生命周期的追踪和回调
 * 使用ActivityLifecycleCallbacks可实现:
 * 1 判断App是否在后台运行
 * 2 关闭该应用所有Activity
 *
 * @author rqmei on 2018/1/29
 */

public class ActivityLifecycle implements Application.ActivityLifecycleCallbacks {
    private AppManager mAppManager;//activity对象管理类
    private Application mApplication;
    private Map<String, Object> mExtras;
    private FragmentLifecycle mFragmentLifecycle;//fragment的生命周期
    private List<FragmentManager.FragmentLifecycleCallbacks> mFragmentLifecycles;

    public ActivityLifecycle(AppManager appManager, Application application, Map<String, Object> extras) {
        this.mAppManager = appManager;
        this.mApplication = application;
        this.mExtras = extras;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        //如果intent包含了此字段,并且为true说明不加入到list
        // 默认为false,如果不需要管理(比如不需要在退出所有activity(killAll)时，退出此activity就在intent加此字段为true)
        mAppManager.addActivity(activity);

        //配置ActivityDelegate
        if (activity instanceof IActivity && activity.getIntent() != null) {
            IActivityDelegate activityDelegate = fetchActivityDelegate(activity);
            if (activityDelegate == null) {
                activityDelegate = new ActivityDelegateImpl(activity);
                activity.getIntent().putExtra(IActivityDelegate.ACTIVITY_DELEGATE, activityDelegate);
            }
            activityDelegate.onCreate(savedInstanceState);
        }

        /**
         * 给每个Activity配置Fragment的监听,Activity可以通过 {@link IActivity#useFragment()} 设置是否使用监听
         * 如果这个Activity返回false的话,这个Activity将不能使用{@link FragmentDelegate},意味着 {@link com.jess.arms.base.BaseFragment}也不能使用
         */
        boolean useFragment = activity instanceof IActivity ? ((IActivity) activity).useFragment() : true;
        if (activity instanceof FragmentActivity && useFragment) {
            if (mFragmentLifecycle == null) {
                mFragmentLifecycle = new FragmentLifecycle();
            }

            ((FragmentActivity) activity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(mFragmentLifecycle, true);
            if (mFragmentLifecycles == null) {
                mFragmentLifecycles = new ArrayList<>();
                List<IConfigModule> modules = (List<IConfigModule>) mExtras.get(IConfigModule.class.getName());
                if (modules != null && modules.size() > 0) {
                    for (IConfigModule module : modules) {
                        module.injectFragmentLifecycle(mApplication, mFragmentLifecycles);
                    }
                }
            }

            for (FragmentManager.FragmentLifecycleCallbacks fragmentLifecycle : mFragmentLifecycles) {
                ((FragmentActivity) activity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(fragmentLifecycle, true);
            }
        }
    }

    @Override
    public void onActivityStarted(Activity activity) {
        Log.w("",activity + "--onActivityStarted");
        IActivityDelegate activityDelegate = fetchActivityDelegate(activity);
        if (activityDelegate != null) {
            activityDelegate.onStart();
        }
    }

    @Override
    public void onActivityResumed(Activity activity) {
       Log.w("",activity + "--onActivityResumed");
        IActivityDelegate activityDelegate = fetchActivityDelegate(activity);
        if (activityDelegate != null) {
            activityDelegate.onResume();
        }
    }

    @Override
    public void onActivityPaused(Activity activity) {
        Log.w("",activity + "--onActivityPaused");
        IActivityDelegate activityDelegate = fetchActivityDelegate(activity);
        if (activityDelegate != null) {
            activityDelegate.onPause();
        }
    }

    @Override
    public void onActivityStopped(Activity activity) {
        Log.w("",activity + "--onActivityStopped");
        IActivityDelegate activityDelegate = fetchActivityDelegate(activity);
        if (activityDelegate != null) {
            activityDelegate.onStop();
        }
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Log.w("",activity + "--onActivitySaveInstanceState");
        IActivityDelegate activityDelegate = fetchActivityDelegate(activity);
        if (activityDelegate != null) {
            activityDelegate.onSaveInstanceState(outState);
        }
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        Log.w("",activity + "--onActivityDestroyed");
        mAppManager.finishActivity(activity);
        boolean useFragment = activity instanceof IActivity ? ((IActivity) activity).useFragment() : true;
        if (activity instanceof FragmentActivity && useFragment) {
            if (mFragmentLifecycle != null) {
                ((FragmentActivity) activity).getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(mFragmentLifecycle);
            }
            if (mFragmentLifecycles != null && mFragmentLifecycles.size() > 0) {
                for (FragmentManager.FragmentLifecycleCallbacks fragmentLifecycle : mFragmentLifecycles) {
                    ((FragmentActivity) activity).getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(fragmentLifecycle);
                }
            }
        }

        IActivityDelegate activityDelegate = fetchActivityDelegate(activity);
        if (activityDelegate != null) {
            activityDelegate.onDestroy();
            activity.getIntent().removeExtra(IActivityDelegate.ACTIVITY_DELEGATE);
        }
    }

    private IActivityDelegate fetchActivityDelegate(Activity activity) {
        IActivityDelegate activityDelegate = null;
        if (activity instanceof IActivity && activity.getIntent() != null) {
            activityDelegate = activity.getIntent().getParcelableExtra(IActivityDelegate.ACTIVITY_DELEGATE);
        }
        return activityDelegate;
    }


}
