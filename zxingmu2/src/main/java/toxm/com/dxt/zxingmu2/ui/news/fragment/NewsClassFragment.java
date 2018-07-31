package toxm.com.dxt.zxingmu2.ui.news.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import toxm.com.dxt.zxingmu2.R;
import toxm.com.dxt.zxingmu2.bean.NewsGson;
import toxm.com.dxt.zxingmu2.ui.news.adapter.NewsAdapter;
import toxm.com.dxt.zxingmu2.ui.news.adapter.NewsAdapter2;
import toxm.com.dxt.zxingmu2.ui.news.contrant.NewsContract;
import toxm.com.dxt.zxingmu2.ui.news.presenter.NewsPresenter;

public class NewsClassFragment  extends Fragment implements NewsContract.View {
    private NewsAdapter2 adapter;
    private NewsContract.Presenter mPresenter;
    PullToRefreshScrollView pullToRefreshScrollView;
    private boolean isViewPrepared; // 标识fragment视图已经初始化完毕
    private boolean hasFetchData; // 标识已经触发过懒加载数据
    private int type;

//    @BindView(R.id.recyclerView)
//    EasyRecyclerView recyclerView;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private int pageIndex = 1;
    private List<List<NewsGson.NewslistBean>> newslistBeans = new ArrayList<>();

    public static NewsClassFragment newInstance(int type) {
        Bundle bundle = new Bundle();
        NewsClassFragment fragment = new NewsClassFragment();
        bundle.putInt("type", type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getArguments().getInt("type");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news_class, container, false);
        ButterKnife.bind(this, view);
        mPresenter = new NewsPresenter(this, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mPresenter.loadData(type,pageIndex);
        isViewPrepared = true;

//        pullToRefreshScrollView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
//            @Override
//            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
//
//            }
//
//            @Override
//            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
//
//            }
//        });
        return view;
    }

    //实现NewsContract.View，重写returnData
    @Override
    public void returnData(List<NewsGson.NewslistBean> datas) {
        adapter  = new NewsAdapter2(datas,getActivity());
        recyclerView.setAdapter(adapter);
        newslistBeans.add(datas);

    }

    private void lazyFetchDataIfPrepared() {
        Log.e("data",type+""+isViewPrepared+"&&&"+hasFetchData);
        if (isViewPrepared && getUserVisibleHint() && !hasFetchData) {
            lazyFetchData();
            hasFetchData = true;
        }
    }

    protected void lazyFetchData() {
        mPresenter.loadData(type,pageIndex);
        pageIndex=pageIndex+1;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        lazyFetchDataIfPrepared();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lazyFetchDataIfPrepared();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hasFetchData = false;
        isViewPrepared = false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //视图销毁 数据设置为空
        hasFetchData=false;
    }

}
