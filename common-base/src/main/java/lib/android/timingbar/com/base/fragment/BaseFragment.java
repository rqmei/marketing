package lib.android.timingbar.com.base.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.mobstat.StatService;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import lib.android.timingbar.com.base.app.BaseApplication;
import lib.android.timingbar.com.base.mvp.EventMessage;
import lib.android.timingbar.com.base.mvp.IPresenter;
import lib.android.timingbar.com.base.util.EventBusUtils;

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
    protected BaseApplication application;
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
        if (isRegisterEventBus()) {
            EventBusUtils.register(this);
        }
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (application == null) {
            application = (BaseApplication) getActivity().getApplication();
        }
        if (mPresenter == null) {
            mPresenter = obtainPresenter();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        StatService.onPageStart(getActivity(), "start"+this.getClass().getName());
    }

    @Override
    public void onPause() {
        super.onPause();
        StatService.onPageEnd(getActivity(), "end"+this.getClass().getName());
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
        if (application == null) {
            application = (BaseApplication) getActivity().getApplication();
        }
        if (mPresenter == null) {
            mPresenter = obtainPresenter();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (isRegisterEventBus()) {
            EventBusUtils.unregister(this);
        }

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

    /**
     * 接收到分发的事件
     *
     * @param event 事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveEvent(EventMessage event) {
    }

    /**
     * 接受到分发的粘性事件
     *
     * @param event 粘性事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onReceiveStickyEvent(EventMessage event) {
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
