package toxm.com.dxt.lxiang1.location.tuijian;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class MyCustomListView extends ListView {

    public MyCustomListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int h =MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, h);
    }
}
