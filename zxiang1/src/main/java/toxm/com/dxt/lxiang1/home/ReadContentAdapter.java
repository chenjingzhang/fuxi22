package toxm.com.dxt.lxiang1.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import toxm.com.dxt.lxiang1.R;

public class ReadContentAdapter extends BaseAdapter {
    List<MainReadBean> objectList;
    Context context;

    public ReadContentAdapter(List<MainReadBean> objectList, Context context) {
        this.objectList = objectList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return objectList.size();
    }

    @Override
    public MainReadBean getItem(int position) {
        return objectList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_item_reading, null);
            viewHolder = new ViewHolder(convertView);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        int type = objectList.get(position).getType();
        Object obj = objectList.get(position).getOo();
        if (type == 0) {
            //短篇
            MainReadContentData.DataBean.EssayBean eassay = (MainReadContentData.DataBean.EssayBean) obj;
            viewHolder.img_type.setImageResource(R.mipmap.essay_image);
            viewHolder.tv_title.setText(eassay.getHp_title());
            viewHolder.tv_author.setText(eassay.getAuthor().get(0).getUser_name());
            viewHolder.tv_content.setText(eassay.getGuide_word());
        } else if (type == 1) {
            //连载
            MainReadContentData.DataBean.SerialBean serial = (MainReadContentData.DataBean.SerialBean) obj;
            viewHolder.img_type.setImageResource(R.mipmap.serial_image);
            viewHolder.tv_title.setText(serial.getTitle());
            viewHolder.tv_author.setText(serial.getAuthor().getUser_name());
            viewHolder.tv_content.setText(serial.getExcerpt());
        } else if (type == 2) {
            //问答
            MainReadContentData.DataBean.QuestionBean question = (MainReadContentData.DataBean.QuestionBean) obj;
            viewHolder.img_type.setImageResource(R.mipmap.question_image);
            viewHolder.tv_title.setText(question.getQuestion_title());
            viewHolder.tv_author.setText(question.getAnswer_title());
            viewHolder.tv_content.setText(question.getAnswer_content());
        }
        return convertView;
    }

    class ViewHolder {
        TextView tv_title;
        TextView tv_content;
        TextView tv_author;
        ImageView img_type;
        View itemView;

        public ViewHolder(View itemView) {
            this.itemView = itemView;
            tv_title = (TextView) itemView.findViewById(R.id.tv_author);
            tv_content = (TextView) itemView.findViewById(R.id.tv_content1);
            tv_author = (TextView) itemView.findViewById(R.id.tv_date);
            img_type = (ImageView) itemView.findViewById(R.id.img_type);
            itemView.setTag(this);
        }
    }
}
