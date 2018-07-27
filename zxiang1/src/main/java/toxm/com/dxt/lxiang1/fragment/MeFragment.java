package toxm.com.dxt.lxiang1.fragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import toxm.com.dxt.lxiang1.R;
import toxm.com.dxt.lxiang1.me.MeAdapter;
import toxm.com.dxt.lxiang1.me.Newsm;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment {
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    Context mContext;
    public final String HOST = "http://news-at.zhihu.com/api/4/news/latest";
    int page = 1;
    MeAdapter meAdapter;

    //默认空列表
    List<Newsm.StoriesBean> list = new ArrayList<>();

    public MeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        swipeRefreshLayout = view.findViewById(R.id.swipe);
        initView();
        return view;
    }

    private void initView() {
        LinearLayoutManager ll = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(ll);
        swipeRefreshLayout.setColorSchemeColors(Color.GREEN, Color.RED, Color.BLUE);
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Color.parseColor("#00000000"));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page++;
                getMeData(page);
            }
        });
        //默认加空的列表
        meAdapter = new MeAdapter(list, mContext);
        recyclerView.setAdapter(meAdapter);
        //第一次请求
        getMeData(page);
    }


    private void getMeData(int page) {
        OkHttpClient client = new OkHttpClient();
        String url = String.format(HOST, page);
        final Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                Gson gson = new Gson();
                Newsm newsm = gson.fromJson(str, Newsm.class);
                final List<Newsm.StoriesBean> storiesBeans = newsm.getStories();
                recyclerView.post(new Runnable() {
                    @Override
                    public void run() {
                        //添加数据(下拉刷新)
                        list.addAll(0, storiesBeans);
                        //整体刷新
                        meAdapter.notifyDataSetChanged();
                        //设置刷新完毕
                    }
                });
            }
        });
    }
}











































