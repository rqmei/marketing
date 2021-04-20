package com.tibi.common.function.lib.base.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.tibi.common.function.lib.base.mvp.IPresenter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * BaseFragment
 * -----------------------------------------------------------------------------------------------------------------------------------
 *
 * @author rqmei on 2018/11/6
 */

public abstract class BaseFragment<P extends IPresenter> extends Fragment implements IFragment<P> {
    /**
     * 用于集中管理Observable订阅
     */
    CompositeDisposable mCompositeDisposable;
    protected P mPresenter;
    Unbinder unbinder;
    /**
     * onCreateView方法中方法的view,
     */
    protected View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getLayoutRes(), container, false);
        }
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mPresenter == null) {
            mPresenter = obtainPresenter();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    /**
     * 通知fragment，该视图层已保存
     * 每次新建Fragment都会发生.
     * 它并不是实例状态恢复的方法, 只是一个View状态恢复的回调.
     * 在onActivityCreated()和onStart()之间调用
     *
     * @param savedInstanceState
     */
    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (mPresenter == null) {
            mPresenter = obtainPresenter();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        unDispose();
        if (unbinder != null) {
            unbinder.unbind();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mCompositeDisposable = null;
    }

    /**
     * 是否使用eventBus,默认为使用(true)，
     */
    @Override
    public boolean isRegisterEventBus() {
        return true;
    }


    @Override
    public void setPresenter(P presenter) {
        this.mPresenter = presenter;
    }

    /**
     * RXjava注册
     *
     * @param disposable
     */
    protected void addDispose(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        // 将所有disposable放入,集中处理
        mCompositeDisposable.add(disposable);
    }

    /**
     * RXjava取消注册，以避免内存泄露
     */
    protected void unDispose() {
        // 保证activity结束时取消所有正在执行的订阅
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
    }
}
