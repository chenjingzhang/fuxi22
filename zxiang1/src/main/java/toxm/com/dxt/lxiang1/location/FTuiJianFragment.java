package toxm.com.dxt.lxiang1.location;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import toxm.com.dxt.lxiang1.R;

import toxm.com.dxt.lxiang1.location.tuijian.AdAdapter;
import toxm.com.dxt.lxiang1.location.tuijian.MyCustomListView;
import toxm.com.dxt.lxiang1.location.tuijian.MyListViewAdapter;
import toxm.com.dxt.lxiang1.location.tuijian.MyViewPager;
import toxm.com.dxt.lxiang1.location.tuijian.OnAdClickListener;
import toxm.com.dxt.lxiang1.util.Images;

/**
 * A simple {@link Fragment} subclass.
 */
public class FTuiJianFragment extends Fragment {
    ScrollView ss;
    LinearLayout ll;
    MyViewPager ad_vp;
    LinearLayout layout_point_container;
    MyCustomListView listView;
    Context mcontext;

    public FTuiJianFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mcontext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ftui_jian, container, false);
        ss = view.findViewById(R.id.ss);
        ll = view.findViewById(R.id.layout_header);
        ad_vp = view.findViewById(R.id.ad_vp);
        layout_point_container = view.findViewById(R.id.layout_point_container);
        listView = view.findViewById(R.id.home_middle_listView);

        //让scollView从头开始
        ll.setFocusableInTouchMode(true);
        ll.setFocusable(true);

        initViewPager();
        initMiddleListView();
        return view;
    }

    private void initViewPager() {
        int count = Images.imageUrls.length;
        List<View> views = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            //添加图片
            ImageView img = new ImageView(mcontext);
            img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Picasso.with(mcontext).load(Images.imageUrls[i]).into(img);
            views.add(img);
            //添加圆点指示器
            ImageView img_point = new ImageView(mcontext);
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
    }

    //
    public void initMiddleListView() {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 40; ++i) {
            stringList.add("====" + i + "------");
        }
        MyListViewAdapter myAdapter = new MyListViewAdapter(stringList, mcontext);
        listView.setAdapter(myAdapter);
//        setListViewHeight(listView);
    }
}
