package toxm.com.dxt.zxingmu2.ui.picturees.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import toxm.com.dxt.zxingmu2.R;
import toxm.com.dxt.zxingmu2.bean.MeiNvGson;
import toxm.com.dxt.zxingmu2.ui.picturees.adapter.ImageAdapter2;
import toxm.com.dxt.zxingmu2.ui.picturees.contract.MeiNvContract;
import toxm.com.dxt.zxingmu2.ui.picturees.presenter.MeiNvPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
// http://api.tianapi.com/social/?key=0271191a3d0bcd8483debff0c759f20a&num=10&page=1
// http://api.tianapi.com/meinv/?key=0271191a3d0bcd8483debff0c759f20a&num=6&page=1
//http://api.tianapi.com/meinv/?key=0271191a3d0bcd8483debff0c759f20a&num=6&page=2
    //http://api.tianapi.com/meinv/?key=0271191a3d0bcd8483debff0c759f20a&num=6&page=9
public class MeiNvFragment extends Fragment implements MeiNvContract.View {

    private ImageAdapter2 adapter2;
    private int page = 1;
    private MeiNvPresenter meiNvPresenter;
    private boolean isViewPrepared;// 标识fragment视图已经初始化完毕
    private boolean hasFetchData;// 标识已经触发过懒加载数据

    List<MeiNvGson.NewslistBean> newslistBeans = new ArrayList<>();

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    public static MeiNvFragment newInstance() {
        MeiNvFragment fragment = new MeiNvFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mei_nv, container, false);
        ButterKnife.bind(this, view);
        meiNvPresenter = new MeiNvPresenter(this, getContext());
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        meiNvPresenter.loadData(page);
        return view;
    }

    @Override
    public void returnData(List<MeiNvGson.NewslistBean> datas) {
        adapter2 = new ImageAdapter2(newslistBeans, getActivity());
        recyclerView.setAdapter(adapter2);
        newslistBeans.addAll(datas);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        lazyFetchDataIfPrepared();
    }

    private void lazyFetchDataIfPrepared() {
        if (isViewPrepared && getUserVisibleHint() && !hasFetchData) {
            lazyFetchData();
            hasFetchData = true;
        }
    }

    protected void lazyFetchData() {
        meiNvPresenter.loadData(page);
        page = page + 1;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        hasFetchData = false;    //视图销毁 数据设置为空
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hasFetchData = false;
        isViewPrepared = false;
    }
}



















