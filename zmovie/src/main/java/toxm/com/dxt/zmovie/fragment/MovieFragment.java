package toxm.com.dxt.zmovie.fragment;


import android.app.Activity;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import toxm.com.dxt.zmovie.R;
import toxm.com.dxt.zmovie.base.BasePresenter;
import toxm.com.dxt.zmovie.bean.SubjectsBean;
import toxm.com.dxt.zmovie.contract.MovieMainContract;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends BaseRecycleFragment<MovieMainContract.MovieMainPresenter>
        implements MovieMainContract.IMovieMainView {

    @BindView(R.id.rv_hot_movie)
    RecyclerView rvHotMovie;
    private HotMovieAdapter mHotMovieAdapter;
    private View headView;

   public static MovieFragment newInstance(){
       Bundle args  = new Bundle();
       MovieFragment fragment = new MovieFragment();
       fragment.setArguments(args);
       return fragment;
   }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_movice;
    }


    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    protected void onErrorViewClick(View view) {

    }

    @Override
    protected void showLoading() {

    }

    @Override
    public void startNewActivity(@NonNull Class<?> clz) {

    }

    @Override
    public void startNewActivity(@NonNull Class<?> clz, Bundle bundle) {

    }

    @Override
    public void startNewActivityForResult(@NonNull Class<?> clz, Bundle bundle, int requestCode) {

    }

    @Override
    public boolean isVisiable() {
        return false;
    }

    @Override
    public Activity getBindActivity() {
        return null;
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void updateContentList(List<SubjectsBean> list) {

    }

    @Override
    public void showNetworkError() {

    }
}
