package toxm.com.dxt.lxiang1.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class FHomeViewPager extends FragmentStatePagerAdapter {
    List<Fragment> fragmentList;
    String[] titles;

    public FHomeViewPager(FragmentManager fm, List<Fragment> fragmentList, String[] str) {
        super(fm);
        this.fragmentList = fragmentList;
        this.titles = str;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
