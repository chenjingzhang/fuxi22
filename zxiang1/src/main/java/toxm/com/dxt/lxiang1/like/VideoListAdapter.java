package toxm.com.dxt.lxiang1.like;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import toxm.com.dxt.lxiang1.R;

public class VideoListAdapter extends BaseAdapter {
    String[] videoUrls = {"http://2449.vod.myqcloud.com/2449_43b6f696980311e59ed467f22794e792.f20.mp4",
            "http://2449.vod.myqcloud.com/2449_ded7b566b37911e5942f0b208e48548d.f20.mp4"};
    String[] videoThumbs = {"http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640",
            "http://p.qpic.cn/videoyun/0/2449_ded7b566b37911e5942f0b208e48548d_2/640"};
    String[] videoTitles = {"一行代码", "视频播放"};

    int[] videoIndexs = {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0};
    Context context;

    public VideoListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return videoIndexs.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (null == convertView) {
            viewHolder = new ViewHolder();
            LayoutInflater mInflater = LayoutInflater.from(context);
            convertView = mInflater.inflate(R.layout.like_video_item, null);
            viewHolder.jcVideoPlayer = (JCVideoPlayer) convertView.findViewById(R.id.videoplayer);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.jcVideoPlayer.setUp(
                videoUrls[videoIndexs[position]],
                videoThumbs[videoIndexs[position]],
                videoTitles[videoIndexs[position]]);
        return convertView;
    }

    class ViewHolder {
        JCVideoPlayer jcVideoPlayer;
    }
}
