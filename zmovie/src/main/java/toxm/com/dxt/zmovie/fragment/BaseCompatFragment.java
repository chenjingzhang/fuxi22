package toxm.com.dxt.zmovie.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;
import toxm.com.dxt.zmovie.R;
import toxm.com.dxt.zmovie.util.WaitPorgressDialog;

public abstract class BaseCompatFragment extends SupportFragment {
    protected String TAG;

    protected Context mContext;
    protected Activity mActivity;
    protected WaitPorgressDialog mWaitPorgressDialog;
    private Unbinder binder;

    @Override
    public void onAttach(Context context) {
        mActivity = (Activity) context;
        mContext = context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getLayoutView() != null) {
            return getLayoutView();
        } else {
            return inflater.inflate(getLayoutId(), container, false);
        }
    }

    public abstract int getLayoutId();

    public View getLayoutView(){
        return null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        TAG = getClass().getSimpleName();
        binder = ButterKnife.bind(this,view);

        getBundle(getArguments());
        initData();
        initUI(view,savedInstanceState);
    }
    /**
     * 得到Activity传进来的值
     */
    public void getBundle(Bundle bundle) {
    }

    /**
     * 在监听器之前把数据准备好
     */
    public void initData() {
        mWaitPorgressDialog = new WaitPorgressDialog(mActivity);
    }
    /**
     * 初始化UI
     */
    public abstract void initUI(View view, @Nullable Bundle savedInstanceState);


    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        if (savedInstanceState==null){
            loadRootFragment(R.id.f1_container,MovieFragment.newInstance());
        }
    }

    /**
     * 处理回退事件
     *
     * @return true 事件已消费
     * <p>
     * false 事件向上传递
     */
    @Override
    public boolean onBackPressedSupport() {
        if (getFragmentManager().getBackStackEntryCount() > 1) {
            //如果当前存在fragment>1，当前fragment出栈
            pop();
        } else {
            //已经退栈到root fragment，交由Activity处理回退事件
            return false;
        }
        return true;
    }

    /**
     * 显示提示框
     *
     * @param msg 提示框内容字符串
     */
    protected void showProgressDialog(String msg) {
        if (mWaitPorgressDialog.isShowing()) {
            mWaitPorgressDialog.dismiss();
        }
        mWaitPorgressDialog.setMessage(msg);
        mWaitPorgressDialog.show();
    }

    /**
     * 隐藏提示框
     */
    protected void hideProgressDialog() {
        if (mWaitPorgressDialog != null) {
            mWaitPorgressDialog.dismiss();
        }
    }


}






















