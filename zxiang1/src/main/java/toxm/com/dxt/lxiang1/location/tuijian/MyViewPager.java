package toxm.com.dxt.lxiang1.location.tuijian;

import android.content.Context;
import android.graphics.PointF;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

//推荐里面的viewPager
public class MyViewPager extends ViewPager {

    //含有浮点型的点的坐标
    PointF down_p1=new PointF();
    PointF up_p2= new PointF();
    OnAdClickListener onAdClickListener;


    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setOnAdClickListener(OnAdClickListener onAdClickListener) {
        this.onAdClickListener = onAdClickListener;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                //表示自己处理事件，外层ViewPager不能干扰里面的ViewPager
                //获取按下的点（含有x,y坐标）
                down_p1.x = ev.getX();
                down_p1.y = ev.getY();

                getParent().requestDisallowInterceptTouchEvent(true);

                break;
            case MotionEvent.ACTION_MOVE:
                getParent().requestDisallowInterceptTouchEvent(true);
                //表示自己处理事件
                break;
            case MotionEvent.ACTION_UP:
                //获取抬起的点（）
                up_p2.x = ev.getX();
                up_p2.y = ev.getY();
                if(up_p2.x == down_p1.x&&up_p2.y==down_p1.y){
                    //点击了
//                    Log.d("========","hhhhh");
                    if(onAdClickListener!=null){
                        onAdClickListener.setOnAdClickListener();
                    }
                }else {
//                    Log.d("========","fdssssssssssssss");
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
//                getParent().requestDisallowInterceptTouchEvent(false);
                //正常处理，外层ViewPager和里层的ViewPager各自处理事件
                break;
        }
        return super.onTouchEvent(ev);
    }
}
