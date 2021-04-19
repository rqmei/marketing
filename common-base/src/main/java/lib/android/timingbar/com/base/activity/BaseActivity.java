package lib.android.timingbar.com.base.activity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.baidu.mobstat.StatService;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import lib.android.timingbar.com.base.app.BaseApplication;
import lib.android.timingbar.com.base.mvp.EventMessage;
import lib.android.timingbar.com.base.mvp.IPresenter;
import lib.android.timingbar.com.base.status.StateUtils;
import lib.android.timingbar.com.base.util.EventBusUtils;

/**
 * BaseActivity
 * -----------------------------------------------------------------------------------------------------------------------------------
 *
 * @author rqmei on 2018/2/5
 */

public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity implements IActivity<P> {
    protected P mPresenter;
    protected ProgressDialog progressDialog;
    protected Unbinder unbinder;
    //用于集中管理Observable订阅
    CompositeDisposable mCompositeDisposable;
    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView (name, context, attrs);
    }

    @SuppressLint("ObsoleteSdkInt")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (getLayoutResId ());
        setStatus ();
        unbinder = ButterKnife.bind (this);

        if (isRegisterEventBus ()) {
            EventBusUtils.register (this);
        }
        if (mPresenter == null) {
            mPresenter = obtainPresenter ();
        }
        initView (savedInstanceState);
        initData (savedInstanceState);
        registerListener ();
    }

    @Override
    protected void onResume() {
        super.onResume();
        StatService.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        StatService.onPause(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState (savedInstanceState);
        if (mPresenter == null) {
            mPresenter = obtainPresenter ();
        }

    }

    @Override
    public P obtainPresenter() {
        return null;
    }

    @Override
    public void setPresenter(P presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public boolean useFragment() {
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy ();
        if (isRegisterEventBus ()) {
            EventBusUtils.unregister (this);
        }

        if (unbinder != null) {
            unbinder.unbind();
        }
        
        if(mPresenter!=null){
            unDispose();
            mPresenter.onDestroy();
            mPresenter=null;
        }
    }

    /**
     * 是否注册事件分发
     *
     * @return true 注册；false 不注册，默认注册
     */
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

    /**
     * 修改状态栏样式
     */
    public void setStatus() {
        Log.i("baseActivity","setStatus-----------------");
        //设置状态蓝的颜色，也可以给颜色本身设置透明度，自己试试
        StateUtils.setStatusBarColor (this, Color.WHITE);
        //设置状态栏字体颜色，true:代表黑色，false代表白色
        StateUtils.setLightStatusBar (this, true);
    }

    /**
     * 加载进度条弹框
     *
     * @param title
     * @param message
     * @return
     */
    public ProgressDialog showProgressDialog(String title, String message) {
        progressDialog=ProgressDialog.show (this, title, message, false, true);
        return progressDialog;
    }

    /**
     * 加载进度条弹框
     *
     * @param message
     * @return
     */
    public ProgressDialog showProgressDialog(String message) {
        progressDialog= this.showProgressDialog ("", message);
        return progressDialog;
    }
    public void dismissProgressDialog(){
        if(progressDialog!=null&&progressDialog.isShowing ()){
            progressDialog.dismiss ();
        }
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
        mCompositeDisposable.add (disposable);//将所有disposable放入,集中处理
    }

    /**
     * RXjava取消注册，以避免内存泄露
     */
    protected void unDispose() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear ();//保证activity结束时取消所有正在执行的订阅
        }
    }
}
