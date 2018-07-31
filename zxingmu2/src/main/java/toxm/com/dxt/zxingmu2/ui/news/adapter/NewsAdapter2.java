package toxm.com.dxt.zxingmu2.ui.news.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import toxm.com.dxt.zxingmu2.R;
import toxm.com.dxt.zxingmu2.bean.NewsGson;
import toxm.com.dxt.zxingmu2.util.PictureUtil;

public class NewsAdapter2 extends RecyclerView.Adapter<NewsAdapter2.MyViewHolder> {
    List<NewsGson.NewslistBean> list;
    Context context;
    LayoutInflater inflater;
    private NewsGson.NewslistBean newslistBean;

    public NewsAdapter2(List<NewsGson.NewslistBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.news_recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        newslistBean = list.get(position);

  /*    mTv_name.setText(data.getTitle());
        mTv_sign.setText(data.getCtime());
        PictureUtil.showImage(mImg_face,getContext(),data.getPicUrl());*/
        holder.mTv_sign.setText(newslistBean.getCtime());
        holder.mTv_name.setText(newslistBean.getTitle());
        Glide.with(context).load(newslistBean.getPicUrl()).into(holder.mImg_face);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mTv_name;
        private ImageView mImg_face;
        private TextView mTv_sign;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTv_name  = itemView.findViewById(R.id.person_name);
            mImg_face = itemView.findViewById(R.id.person_face);
            mTv_sign = itemView.findViewById(R.id.person_sign);
        }
    }
}
