package toxm.com.dxt.zmovie.base;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.yokeyword.fragmentation.ISupportFragment;
import me.yokeyword.fragmentation.SupportFragment;
import toxm.com.dxt.zmovie.R;
import toxm.com.dxt.zmovie.fragment.BaseCompatFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseMVPCompatFragment<P extends BasePresenter> extends
        BaseCompatFragment implements IBaseFragment {

    public P mPresenter;

    public void initData() {
        super.initData();
        mPresenter = (P) initPresenter();
        if (mPresenter != null) {
            mPresenter.attachMV(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachMV();
        }
    }

    @Override
    public void showWaitDialog(String waitMsg) {
        showProgressDialog(waitMsg);
    }

    @Override
    public void hideWaitDialog() {
        hideProgressDialog();
    }

    @Override
    public void back() {
        this.onBackPressedSupport();
    }

    @Override
    public void startNewFragment(@NonNull SupportFragment supportFragment) {
        start(supportFragment);
    }

    @Override
    public void startNewFragmentWithPop(@NonNull SupportFragment supportFragment) {
       startWithPop(supportFragment);
    }

    @Override
    public void startNewFragmentForResult(@NonNull SupportFragment supportFragment, int requestCode) {
       startForResult(supportFragment,requestCode);
    }

    @Override
    public void startWithPop(ISupportFragment toFragment) {
        super.startWithPop(toFragment);
    }

    @Override
    public void popToFragment(Class<?> targetFragmentClass, boolean includeTargetFragment) {
        popTo(targetFragmentClass,includeTargetFragment);
    }


    @Override
    public void hideKeybord() {
        hideSoftInput();
    }

    @Override
    public void setOnFragmentResult(int ResultCode, Bundle data) {
        setFragmentResult(ResultCode, data);
    }


}
