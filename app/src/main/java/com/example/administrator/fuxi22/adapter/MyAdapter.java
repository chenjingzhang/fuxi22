package com.example.administrator.fuxi22.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2018/3/17 0017.
 */
public class MyAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList;
    String[] titles;


    public MyAdapter(FragmentManager fm, List<Fragment> fragmentList, String[] titles) {
        super(fm);
        this.fragmentList = fragmentList;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

//只能填文字
// @Override
//    public CharSequence getPageTitle(int position) {
//        return titles[position];
//    }
}
