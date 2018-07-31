package toxm.com.dxt.zxingmu2.ui.news.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import toxm.com.dxt.zxingmu2.R;
import toxm.com.dxt.zxingmu2.ui.base.TabPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment implements ViewPager.OnPageChangeListener{

    private String[] mTitles;
    private NewsClassFragment[] mFragments;
    private TabPagerAdapter mAdapter;

    private TabLayout mTabs;
    private ViewPager mViewPager;

    public NewsFragment() {
        // Required empty public constructor
    }

    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this,view);
        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);
        mTabs = (TabLayout) view.findViewById(R.id.tab_layout);
        mTitles = getResources().getStringArray(R.array.main_titles);

        mFragments = new NewsClassFragment[mTitles.length];
        for (int i = 0; i < mFragments.length; i++) {
            mFragments[i] = NewsClassFragment.newInstance(i);
        }
        mTabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        mAdapter = new TabPagerAdapter(getChildFragmentManager(),mFragments);
        mAdapter.setTabTitiles(mTitles);
        mViewPager.setAdapter(mAdapter);
        mTabs.setupWithViewPager(mViewPager);
        mViewPager.addOnPageChangeListener(this);
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
