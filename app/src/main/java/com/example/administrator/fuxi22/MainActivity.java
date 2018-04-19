package com.example.administrator.fuxi22;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.fuxi22.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout tablayout;
    private ViewPager viewPager;
    String[] titles = new String[]{"首页", "分类", "我的"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tablayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.vp);
        initTabAsTitle();
        initContentToViewPager();

    }
//添加标题
    public void initTabAsTitle() {
        tablayout.setSelectedTabIndicatorColor(Color.GREEN);
        tablayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tablayout.setTabTextColors(Color.BLUE,Color.GREEN);
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
            b.putInt(Constant.POS, i);
            c.setArguments(b);
            fragmentList.add(c);
        }
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager(),fragmentList,titles));
        tablayout.setupWithViewPager(viewPager);
        resetTablayout();
    }

    private void resetTablayout() {
        for(int i=0;i< titles.length;++i){
            tablayout.getTabAt(i).setCustomView(getTabView(i));
        }
    }

    private View getTabView(int i) {
        View view0 = LayoutInflater.from(this).inflate(R.layout.item_layout, null);
        tablayout.getTabAt(i).setCustomView(view0);
        TextView text = (TextView) view0.findViewById(R.id.text0);
        ImageView image = (ImageView) view0.findViewById(R.id.image);
        text.setText(titles[i]);
        image.setImageResource(R.mipmap.ic_launcher);
          /*  tabLayout.newTab().setIcon(R.mipmap.ic_launcher);
            tabLayout.getTabAt(i).setText(titles[i]);*/
        return view0;
    }
}
