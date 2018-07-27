package toxm.com.dxt.lxiang1.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import toxm.com.dxt.lxiang1.R;
import toxm.com.dxt.lxiang1.activity.NewsChannelActivity;
import toxm.com.dxt.lxiang1.home.FHomeViewPager;
import toxm.com.dxt.lxiang1.home.MainReadContentData;
import toxm.com.dxt.lxiang1.home.ReadChildFragment;
import toxm.com.dxt.lxiang1.util.Constants;
import toxm.com.dxt.lxiang1.util.DataCallback;
import toxm.com.dxt.lxiang1.util.HttpUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements DataCallback {
    ViewPager viewPager;
    TabLayout tabLayout;
    String[] titles = new String[]{"精选 ", "原创", "首页","推荐","介绍","导航","测试","结束","倒数","最后"};
    Handler handler = new Handler();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        viewPager = view.findViewById(R.id.home_content_viewPager);
        tabLayout = view.findViewById(R.id.tab_layout_home);
        ImageView add_channel_iv = view.findViewById(R.id.add_channel_iv);
        add_channel_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Intent(getActivity(), NewsChannelActivity.class);
            }
        });
        initTabAsTitle();
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        httpUtils.getStrByNetWork(1, Constants.READING.READING_CONTENT_PATH,handler);
        httpUtils.setDataCallback(this);
        return view;
    }

    private void initTabAsTitle() {
        for (int i = 0; i < titles.length; ++i) {
            tabLayout.addTab(tabLayout.newTab().setText(titles[i]));
        }
    }

    @Override
    public void setDataCallback(int type, String s) {
        if(type ==1){
            Gson gson = new Gson();
            MainReadContentData contentData = gson.fromJson(s,MainReadContentData.class);
            int size= contentData.getData().getSerial().size();
            List<Fragment> fragmentList = new ArrayList<>();
            for(int  i=0;i<size;i++){
                Log.d("ddd","dddsi"+size);
                ReadChildFragment childFragment = new ReadChildFragment();
                Bundle b = new Bundle();
                b.putInt("pos",i);
                b.putParcelable("content",contentData);
                childFragment.setArguments(b);
                fragmentList.add(childFragment);
                viewPager.setAdapter(new FHomeViewPager(getFragmentManager(),fragmentList,titles));
                tabLayout.setupWithViewPager(viewPager);
            }
        }
    }
}
