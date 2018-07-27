package toxm.com.dxt.zmovie.util;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class RxManager {
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();// 管理订阅者者

    public void register(Disposable d) {
        mCompositeDisposable.add(d);
    }

    public void unSubscribe() {
        mCompositeDisposable.dispose();// 取消订阅
    }
}
