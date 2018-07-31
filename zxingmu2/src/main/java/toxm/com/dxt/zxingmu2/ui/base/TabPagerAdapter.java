package toxm.com.dxt.zxingmu2.ui.base;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabPagerAdapter extends FragmentPagerAdapter{
   private String tabTitiles[];
   private Fragment[]  fr;

    public TabPagerAdapter(FragmentManager fm, Fragment[] fr) {
        super(fm);
        this.fr = fr;
    }

    public void setTabTitiles(String[] tabTitiles){
        this.tabTitiles = tabTitiles;
    }

    @Override
    public Fragment getItem(int position) {
        return fr[position % fr.length];
    }

    @Override
    public int getCount() {
        if (fr == null || fr.length == 0)
            return 0;
        return fr.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (tabTitiles == null)
            return "";
        return tabTitiles[position];
    }
}
