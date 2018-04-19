package com.example.scrollviewandlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;

import com.example.scrollviewandlistview.adapter.MyListViewAdapter;
import com.example.scrollviewandlistview.adapter.MyGridViewAdapter;
import com.example.scrollviewandlistview.view.MyCustomGridView;
import com.example.scrollviewandlistview.view.MyCustomListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MyCustomListView listView;
    MyCustomGridView gridView;

    ScrollView scrollView;

    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initMiddleListView();

        initBottomGridView();

    }

    public void initView() {
        listView = (MyCustomListView) findViewById(R.id.home_middle_listView);
        gridView = (MyCustomGridView) findViewById(R.id.home_bottom_gridView);
// 方法1 让页面从头开始
//   scrollView = (ScrollView) findViewById(R.id.ss);
//        scrollView.smoothScrollTo(0,0);

        layout = (LinearLayout) findViewById(R.id.layout_header);

        layout.setFocusableInTouchMode(true);
        layout.setFocusable(true);
    }


    public void initHeaderLayout() {

    }

    public void initMiddleListView() {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 40; ++i) {
            stringList.add("====" + i + "------");
        }
        MyListViewAdapter myAdapter = new MyListViewAdapter(stringList, this);
        listView.setAdapter(myAdapter);
//        setListViewHeight(listView);
    }

    public void initBottomGridView() {
        MyGridViewAdapter myGridViewAdapter = new MyGridViewAdapter(Images.imageUrls, this);
        gridView.setAdapter(myGridViewAdapter);
    }


    public void setListViewHeight(ListView listView) {
        //先去适配器
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        //取出总个数
        int conut = listAdapter.getCount();
        int totalitemH = 0;
        for (int i = 0; i < conut; ++i) {
            //位置，item视图的默认值，父视图
            View itemView = listAdapter.getView(i, null, listView);
            //测量item的宽和高,参数是默认值，实际是测量执行动作
            itemView.measure(0, 0);
            //取出测量结果
            int itemh = itemView.getMeasuredHeight();
            //累积得到item高度
            totalitemH += itemh;
        }
        //获取分割线的高度，表示一条分割线的高度
        int itemDividerH = listView.getDividerHeight();
        //总的分割线高度
        int totalDividerH = itemDividerH * (conut - 1);
        //listView的总高度
        int totalH = totalDividerH + totalitemH;
        //设置高度，（LayoutParams引用的是item根视图的布局）
        listView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, totalH));
    }
}




















