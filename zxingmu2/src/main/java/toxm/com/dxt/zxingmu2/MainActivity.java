package toxm.com.dxt.zxingmu2;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import toxm.com.dxt.zxingmu2.ui.picturees.fragment.MeiNvFragment;
import toxm.com.dxt.zxingmu2.ui.news.fragment.NewsFragment;
import toxm.com.dxt.zxingmu2.ui.base.TabPagerAdapter;
import toxm.com.dxt.zxingmu2.widget.NoScrollViewPage;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private NoScrollViewPage mViewPager;
    private Fragment[] fragments;
    private String[] mTitles;
    private TabPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTitles = getResources().getStringArray(R.array.main_titles);
        mViewPager = findViewById(R.id.viewPager);
        fragments = new Fragment[2];
        fragments[0] = NewsFragment.newInstance();
        fragments[1] = MeiNvFragment.newInstance();
        mAdapter = new TabPagerAdapter(getSupportFragmentManager(),fragments);
        mViewPager.setAdapter(mAdapter);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.nav_camera:
                mViewPager.setCurrentItem(0);
                break;

            case R.id.nav_slideshow:
                mViewPager.setCurrentItem(1);
                break;
        }
        return true;
    }
}
