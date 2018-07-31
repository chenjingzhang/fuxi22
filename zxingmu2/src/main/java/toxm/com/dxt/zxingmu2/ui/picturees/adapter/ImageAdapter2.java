package toxm.com.dxt.zxingmu2.ui.picturees.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;
import toxm.com.dxt.zxingmu2.R;
import toxm.com.dxt.zxingmu2.bean.MeiNvGson;

public class ImageAdapter2 extends RecyclerView.Adapter<ImageAdapter2.MyViewHolder> {
    List<MeiNvGson.NewslistBean> newslistBean;
    Context context;
    LayoutInflater inflater;
    private MeiNvGson.NewslistBean newslistBean1;

    public ImageAdapter2(List<MeiNvGson.NewslistBean> newslistBean, Context context) {
        this.newslistBean = newslistBean;
        this.context = context;
        inflater =LayoutInflater.from(context);
    }

    @Override
    public ImageAdapter2.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.prcturees_item, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageAdapter2.MyViewHolder holder, int position) {
        newslistBean1 = newslistBean.get(position);
        String image = newslistBean1.getPicUrl();
        Glide.with(context).load(image).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        Log.d("sss","newslistBean.size()"+newslistBean.size());
        return newslistBean == null?0:newslistBean.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.picture_item_iv);
        }
    }
}
