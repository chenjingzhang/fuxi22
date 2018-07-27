package toxm.com.dxt.lxiang1.me;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import toxm.com.dxt.lxiang1.R;

public class MeAdapter extends RecyclerView.Adapter<MeAdapter.MyViewHolder> {
    List<Newsm.StoriesBean> list;
    Context context;

    public MeAdapter(List<Newsm.StoriesBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.me_news_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Newsm.StoriesBean storiesBean = list.get(position);
        holder.tv_author.setText(storiesBean.getTitle());
        holder.tv_title.setText(storiesBean.getGa_prefix());
        List<String> listImg =   storiesBean.getImages();
        Picasso.with(context).load(listImg.get(0)).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_author;
        TextView tv_title;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_author = itemView.findViewById(R.id.tv_item_me);
            tv_title = itemView.findViewById(R.id.tv_item_detail_me);
            imageView = itemView.findViewById(R.id.iv_item_me);
        }
    }
}
