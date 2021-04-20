package com.tibi.common.function.lib.base.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/**
 * FragmentLifecycle
 * -------------------------------------------------------------------------------------------------
 * fragment 的生命周期管理
 *
 * @author rqmei on 2018/9/13
 */

@SuppressLint("NewApi")
public class FragmentLifecycle extends FragmentManager.FragmentLifecycleCallbacks {
    @Override
    public void onFragmentAttached(FragmentManager fm, Fragment f, Context context) {
        super.onFragmentAttached(fm, f, context);
        Log.w("", f.toString() + " - onFragmentAttached");
        if (f instanceof IFragment && f.getArguments() != null) {
            IFragmentDelegate fragmentDelegate = fetchFragmentDelegate(f);
            if (fragmentDelegate == null || !fragmentDelegate.isAdded()) {
                fragmentDelegate = new FragmentDelegateImpl(fm, f);
                f.getArguments().putParcelable(IFragmentDelegate.FRAGMENT_DELEGATE, fragmentDelegate);
            }
            fragmentDelegate.onAttach(context);
        }
    }

    @Override
    public void onFragmentCreated(FragmentManager fm, Fragment f, Bundle savedInstanceState) {
        super.onFragmentCreated(fm, f, savedInstanceState);
        Log.w("", f.toString() + " - onFragmentCreated");
        IFragmentDelegate fragmentDelegate = fetchFragmentDelegate(f);
        if (fragmentDelegate != null) {
            fragmentDelegate.onCreate(savedInstanceState);
        }
    }

    @Override
    public void onFragmentViewCreated(FragmentManager fm, Fragment f, View v, Bundle savedInstanceState) {
        super.onFragmentViewCreated(fm, f, v, savedInstanceState);
        Log.w("", f.toString() + " - onFragmentViewCreated");
        IFragmentDelegate fragmentDelegate = fetchFragmentDelegate(f);
        if (fragmentDelegate != null) {
            fragmentDelegate.onCreateView(v, savedInstanceState);
        }
    }

    @Override
    public void onFragmentActivityCreated(FragmentManager fm, Fragment f, Bundle savedInstanceState) {
        super.onFragmentActivityCreated(fm, f, savedInstanceState);
        Log.w("", f.toString() + " - onFragmentActivityCreated");
        IFragmentDelegate fragmentDelegate = fetchFragmentDelegate(f);
        if (fragmentDelegate != null) {
            fragmentDelegate.onActivityCreate(savedInstanceState);
        }
    }

    @Override
    public void onFragmentStarted(FragmentManager fm, Fragment f) {
        super.onFragmentStarted(fm, f);
        Log.w("", f.toString() + " - onFragmentStarted");
        IFragmentDelegate fragmentDelegate = fetchFragmentDelegate(f);
        Log.i("onFragmentStarted--", "fragmentDelegate--" + fragmentDelegate);
        if (fragmentDelegate != null && fragmentDelegate instanceof BaseFragment) {
            fragmentDelegate.onStart();
        }
    }

    @Override
    public void onFragmentResumed(FragmentManager fm, Fragment f) {
        super.onFragmentResumed(fm, f);
        Log.w("", f.toString() + " - onFragmentResumed");
        IFragmentDelegate fragmentDelegate = fetchFragmentDelegate(f);
        if (fragmentDelegate != null) {
            fragmentDelegate.onResume();
        }
    }

    @Override
    public void onFragmentPaused(FragmentManager fm, Fragment f) {
        super.onFragmentPaused(fm, f);
        Log.w("", f.toString() + " - onFragmentPaused");
        IFragmentDelegate fragmentDelegate = fetchFragmentDelegate(f);
        if (fragmentDelegate != null) {
            fragmentDelegate.onPause();
        }
    }

    @Override
    public void onFragmentStopped(FragmentManager fm, Fragment f) {
        super.onFragmentStopped(fm, f);
        Log.w("", f.toString() + " - onFragmentStopped");
        IFragmentDelegate fragmentDelegate = fetchFragmentDelegate(f);
        Log.i("FragmentLifecycle", "fragmentDelegate对象-" + fragmentDelegate);
        if (fragmentDelegate != null) {
            fragmentDelegate.onStop();
        }
    }

    @Override
    public void onFragmentViewDestroyed(FragmentManager fm, Fragment f) {
        super.onFragmentViewDestroyed(fm, f);
        Log.w("", f.toString() + " - onFragmentViewDestroyed");
        IFragmentDelegate fragmentDelegate = fetchFragmentDelegate(f);
        if (fragmentDelegate != null) {
            fragmentDelegate.onDestroyView();
        }
    }

    @Override
    public void onFragmentDestroyed(FragmentManager fm, Fragment f) {
        super.onFragmentDestroyed(fm, f);
        Log.w("", f.toString() + " - onFragmentDestroyed");
        IFragmentDelegate fragmentDelegate = fetchFragmentDelegate(f);
        if (fragmentDelegate != null) {
            fragmentDelegate.onDestroy();
        }
    }

    @Override
    public void onFragmentDetached(FragmentManager fm, Fragment f) {
        super.onFragmentDetached(fm, f);
        Log.w("", f.toString() + " - onFragmentDetached");
        IFragmentDelegate fragmentDelegate = fetchFragmentDelegate(f);
        Log.i("测试", "fragmentDelegate=" + fragmentDelegate + ",f-" + f);
        if (fragmentDelegate != null) {
            fragmentDelegate.onDetach();
            f.getArguments().clear();
        }
    }

    /**
     * 将fragment 转换为自定义的 IFragmentDelegate
     *
     * @param fragment
     * @return
     */
    private IFragmentDelegate fetchFragmentDelegate(Fragment fragment) {
        try {
            if (fragment instanceof IFragment) {
                return fragment.getArguments() == null ? null : (IFragmentDelegate) fragment.getArguments().getParcelable(IFragmentDelegate.FRAGMENT_DELEGATE);
            }
        } catch (Exception e) {
            Log.w("", " fetchFragmentDelegate 异常了");
            e.printStackTrace();
        }
        return null;
    }

}
