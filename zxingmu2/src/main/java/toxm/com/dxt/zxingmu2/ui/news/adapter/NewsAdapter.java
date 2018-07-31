package toxm.com.dxt.zxingmu2.ui.news.adapter;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import toxm.com.dxt.zxingmu2.R;
import toxm.com.dxt.zxingmu2.bean.NewsGson;
import toxm.com.dxt.zxingmu2.util.PictureUtil;

public class NewsAdapter extends RecyclerArrayAdapter<NewsGson.NewslistBean>{
    public NewsAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsViewHolder(parent);
    }

    class NewsViewHolder extends BaseViewHolder<NewsGson.NewslistBean>{
        private TextView mTv_name;
        private ImageView mImg_face;
        private TextView mTv_sign;

        public NewsViewHolder(ViewGroup parent) {
            super(parent,R.layout.news_recycler_item);
            mTv_name = $(R.id.person_name);
            mTv_sign = $(R.id.person_sign);
            mImg_face = $(R.id.person_face);
        }

        @Override
        public void setData(NewsGson.NewslistBean data) {
            mTv_name.setText(data.getTitle());
            mTv_sign.setText(data.getCtime());
            PictureUtil.showImage(mImg_face,getContext(),data.getPicUrl());
        }
    }
}
