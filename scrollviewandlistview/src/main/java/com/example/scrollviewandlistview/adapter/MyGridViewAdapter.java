package com.example.scrollviewandlistview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.scrollviewandlistview.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Administrator on 2018/3/18 0018.
 */
public class MyGridViewAdapter extends BaseAdapter {
    String[] imgs;
    Context context;

    public MyGridViewAdapter(String[] imgs, Context context) {
        this.imgs = imgs;
        this.context = context;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public Object getItem(int position) {
        return imgs[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        //convertView是否为空以及setTag()
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.home_grid_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

//      viewHolder.textView.setText(stringList.get(position));
        Picasso.with(context).load(imgs[position])
                .placeholder(R.mipmap.ic_launcher)
                .into(viewHolder.imageView);
        return convertView;
    }
//ViewHolder查找控件，减少findViewById次数
    class ViewHolder {
        ImageView imageView;
        View itemView;
        public ViewHolder(View itemView) {
            this.itemView = itemView;
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
