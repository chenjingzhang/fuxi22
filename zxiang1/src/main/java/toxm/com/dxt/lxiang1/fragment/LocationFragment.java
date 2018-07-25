package toxm.com.dxt.lxiang1.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import toxm.com.dxt.lxiang1.R;
import toxm.com.dxt.lxiang1.adapter.TabAdapter;
import toxm.com.dxt.lxiang1.location.FContentFragment;

public class LocationFragment extends Fragment {
    Context mContext;
    private TabLayout tablayout;
    private ViewPager viewPager;
    String[] titles = new String[]{"首页", "推荐", "关注"};

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_location, container, false);
        tablayout = view.findViewById(R.id.tab_layout);
        viewPager = view.findViewById(R.id.viewPager);
        initTabAsTitle();
        initContentToViewPager();
        return view;
    }

    private void initTabAsTitle() {
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < titles.length; ++i) {
            tablayout.addTab(tablayout.newTab().setText(titles[i]));
        }
    }

    public void initContentToViewPager() {
        List<Fragment> fragmentList = new ArrayList<>();
        for (int i = 0; i < titles.length; ++i) {
            FContentFragment c = new FContentFragment();
            Bundle b = new Bundle();
            b.putInt("pos", i);
            b.putString("text",titles[i]);
            c.setArguments(b);
            fragmentList.add(c);
        }
        viewPager.setAdapter(new TabAdapter(getFragmentManager(), fragmentList, titles));
        tablayout.setupWithViewPager(viewPager);

    }


}
