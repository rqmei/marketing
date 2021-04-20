package com.tibi.common.function.lib.base.integration;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import java.util.Stack;

/**
 * activity堆栈式管理
 */
public final class AppManager {

    private static Stack<Activity> activityStack;
    private static AppManager instance;

    private AppManager() {
    }

    /**
     * 单例
     */
    public static synchronized AppManager getInstance() {
        if (instance == null) {
            instance = new AppManager ();
        }
        return instance;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        Log.i ("addActivity==", "添加activity到栈");
        if (activityStack == null) {
            activityStack = new Stack<Activity> ();
        }
        activityStack.add (activity);
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity getCurrentActivity() {
        if (activityStack == null || activityStack.size () == 0) {
            return null;
        }
        return activityStack.lastElement ();
    }


    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity() {
        if (activityStack == null || activityStack.size () == 0) {
            return;
        }
        Activity activity = activityStack.lastElement ();
        finishActivity (activity);
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        Log.i ("结束指定的Activity", "名字===" + activity.getClass ().getSimpleName ());
        if (activity != null && !activity.isFinishing ()) {
            activityStack.remove (activity);
            activity.finish ();
            activity = null;
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass ().equals (cls)) {
                finishActivity (activity);
                break;
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        Log.i ("finishAll", "-----------");
        for (int i = 0, size = activityStack.size (); i < size; i++) {
            if (null != activityStack.get (i)) {
                Activity activity = activityStack.get (i);
                if (activity != null && !activity.isFinishing ()) {
                    // Log.i("finish---",activity.getClass()+"");
                    activity.finish ();
                    activity = null;
                }
            }
        }
        activityStack.clear ();
    }

    /**
     * 获取指定的Activity
     *
     * @author kymjs
     */
    public Activity getActivity(Class<?> cls) {
        if (activityStack != null)
            for (Activity activity : activityStack) {
                if (activity.getClass ().equals (cls)) {
                    return activity;
                }
            }
        return null;
    }

    public <T extends Activity> boolean isActivityExist(Class<T> clz) {
        boolean res = true;
        Activity activity = getActivity (clz);
        if (activity == null) {
            res = false;
        } else {
            if (Build.VERSION.SDK_INT < 17) {
                if (activity.isFinishing ()) {
                    res = false;
                } else {
                    res = true;
                }
            } else {
                if (activity.isFinishing () || activity.isDestroyed ()) {
                    res = false;
                } else {
                    res = true;
                }
            }
        }

        return res;
    }

    /**
     * 退出应用程序
     */
    public void AppExit(Context context) {
        try {
            finishAllActivity ();
            // 杀死该应用进程
            android.os.Process.killProcess (android.os.Process.myPid ());
            System.exit (0);
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

    public String getActivityString() {
        try {
            if (activityStack != null && activityStack.size () > 0) {
                String str = "";
                for (int i = 0; i < activityStack.size (); i++) {
                    str = str + "," + activityStack.get (i).getClass ();
                }
                return str;
            } else {
                return "null";
            }
        } catch (Exception e) {
            e.printStackTrace ();
            return "null";
        }
    }
}