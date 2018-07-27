package toxm.com.dxt.zmovie.base;

import toxm.com.dxt.zmovie.util.RxManager;

public abstract class BasePresenter<M,V> {
    public M mIModel;
    public V mIView;
    protected RxManager rxManager = new RxManager();

    public abstract M getModel();

    public void attachMV(V v){
        this.mIModel = getModel();
        this.mIView = v;
        this.onStart();
    }
    public abstract void onStart();


    public void detachMV() {
        rxManager.unSubscribe();
        mIView = null;
        mIModel = null;
    }
}
