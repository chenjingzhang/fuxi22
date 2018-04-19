package com.example.scrollviewandlistview.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.scrollviewandlistview.R;

import java.util.List;

/**
 * Created by Administrator on 2018/3/18 0018.
 */
public class MyListViewAdapter extends BaseAdapter {
    List<String> stringList;
    Context context;

    public MyListViewAdapter(List<String> stringList, Context context) {
        this.stringList = stringList;
        this.context = context;
    }

    @Override
    public int getCount() {
        Log.d("=====","ffds"+stringList.size());
        return stringList.size();
    }

    @Override
    public Object getItem(int position) {
        return stringList.get(position);
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
            convertView = LayoutInflater.from(context).inflate(R.layout.home_list_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Log.d("======","fdsf"+stringList.get(position));
        viewHolder.textView.setText(stringList.get(position));
        return convertView;
    }
//ViewHolder查找控件，减少findViewById次数
    class ViewHolder {
        TextView textView;
        View itemView;

        public ViewHolder(View itemView) {
            this.itemView = itemView;
            textView = (TextView) itemView.findViewById(R.id.textView);
        }

    }
}
