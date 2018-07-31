package toxm.com.dxt.zxingmu2.bean;

import java.util.List;

public class MeiNvGson {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2018-06-02 09:00","title":"东方韵 (14)","description":"华声美女","picUrl":"http://image.hnol.net/c/2018-06/02/08/201806020808105641-239867.jpg","url":"http://bbs.voc.com.cn/mm/meinv-8400446-0-1.html"},{"ctime":"2018-06-02 09:00","title":"昆山秋水","description":"华声美女","picUrl":"http://image.hnol.net/c/2018-06/02/08/201806020812372681-239867.jpg","url":"http://bbs.voc.com.cn/mm/meinv-8400448-0-1.html"},{"ctime":"2018-06-01 10:00","title":"安妮","description":"华声美女","picUrl":"http://image.hnol.net/c/2018-06/01/09/201806010900031431-239867.jpg","url":"http://bbs.voc.com.cn/mm/meinv-8398621-0-1.html"},{"ctime":"2018-06-01 09:00","title":"东方韵 (13)","description":"华声美女","picUrl":"http://image.hnol.net/c/2018-06/01/08/201806010850463251-239867.jpg","url":"http://bbs.voc.com.cn/mm/meinv-8398614-0-1.html"},{"ctime":"2018-05-31 20:00","title":"☆成熟女人\u2026\u2026[再作TD GoGo 106p]\u2026\u2026第993辑","description":"华声美女","picUrl":"http://image.hnol.net/c/2018-05/31/19/20180531191115961-1559530.jpg","url":"http://bbs.voc.com.cn/mm/meinv-8397911-0-1.html"},{"ctime":"2018-05-31 10:00","title":"雨后的阳光","description":"华声美女","picUrl":"http://image.hnol.net/c/2018-05/31/09/201805310907078531-239867.jpg","url":"http://bbs.voc.com.cn/mm/meinv-8396562-0-1.html"}]
     */

    private int code;
    private String msg;
    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        /**
         * ctime : 2018-06-02 09:00
         * title : 东方韵 (14)
         * description : 华声美女
         * picUrl : http://image.hnol.net/c/2018-06/02/08/201806020808105641-239867.jpg
         * url : http://bbs.voc.com.cn/mm/meinv-8400446-0-1.html
         */

        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
