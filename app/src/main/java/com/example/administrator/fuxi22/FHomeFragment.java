package com.example.administrator.fuxi22;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.fuxi22.adapter.AdAdapter;
import com.example.administrator.fuxi22.callback.OnAdClickListener;
import com.example.administrator.fuxi22.view.MyViewPager;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class FHomeFragment extends Fragment {

    MyViewPager ad_vp;
    Context context;

    LinearLayout layout_point_container;

    public FHomeFragment() {

    }

    //解决imageview 参数空指针的问题
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fhome, container, false);
        ad_vp = (MyViewPager) view.findViewById(R.id.ad_vp);

        layout_point_container = (LinearLayout) view.findViewById(R.id.layout_point_container);
        int count = Images.imageUrls.length;
        List<View> views = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            //添加图片
            ImageView img = new ImageView(context);
            img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Picasso.with(context).load(Images.imageUrls[i]).into(img);
            views.add(img);
            //添加圆点指示器

            ImageView img_point = new ImageView(context);

            if (i == 0) {
                img_point.setImageResource(R.drawable.point_select);
            } else {
                img_point.setImageResource(R.drawable.point_default);
            }
            img_point.setPadding(10, 10, 10, 10);
            layout_point_container.addView(img_point);
        }
        ad_vp.setAdapter(new AdAdapter(views));
        //设置点击事件
        ad_vp.setOnAdClickListener(new OnAdClickListener() {
            @Override
            public void setOnAdClickListener() {
                Log.d("===", "==点击的位置是=" + ad_vp.getCurrentItem());
            }
        });
        //viewPager的监听事件
        ad_vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int count = layout_point_container.getChildCount();
                for (int i = 0; i < count; i++) {
                    ImageView img = (ImageView) layout_point_container.getChildAt(i);
                    if (i == position) {
                        img.setImageResource(R.drawable.point_select);
                    } else {
                        img.setImageResource(R.drawable.point_default);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return view;
    }
}
