package lib.android.timingbar.com.base.integration.lifecycle;

import android.app.Activity;

import com.trello.rxlifecycle3.RxLifecycle;

import androidx.fragment.app.Fragment;
import io.reactivex.subjects.Subject;

/**
 * ================================================
 * 让 {@link Activity}/{@link Fragment} 实现此接口,即可正常使用 {@link RxLifecycle}
 * 无需再继承 {@link RxLifecycle} 提供的 Activity/Fragment ,扩展性极强
 *
 * @see RxLifecycleUtils 详细用法请查看此类
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * =================================================
 */
public interface Lifecycleable<E> {
    Subject<E> provideLifecycleSubject();
}
