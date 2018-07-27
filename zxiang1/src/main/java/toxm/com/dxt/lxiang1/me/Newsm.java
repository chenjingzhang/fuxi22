package toxm.com.dxt.lxiang1.me;

import java.util.List;

public class Newsm {


    /**
     * date : 20180726
     * stories : [{"images":["https://pic4.zhimg.com/v2-ebb0f8e290ba8a6753a6aa24733bd00f.jpg"],"type":0,"id":9691101,"ga_prefix":"072610","title":"火星上发现了液态水湖？我仔细读完原文，发现不一定"},{"images":["https://pic1.zhimg.com/v2-972f4608ce47022ab3aa1e470c0cd024.jpg"],"type":0,"id":9690988,"ga_prefix":"072609","title":"「空有上进心，却没执行力」，我有个对策"},{"images":["https://pic4.zhimg.com/v2-3068e19917b324438d4fad2de318c0df.jpg"],"type":0,"id":9691047,"ga_prefix":"072608","title":"大学生如何充分利用起 MacBook Pro？"},{"images":["https://pic2.zhimg.com/v2-84dca630c671efe358a30b37fdcc4e11.jpg"],"type":0,"id":9691041,"ga_prefix":"072607","title":"今年「反常」的百日咳发病人数，也开始让人疑心起来"},{"images":["https://pic4.zhimg.com/v2-8083c14fb6ffe64148084486d4dd6c97.jpg"],"type":0,"id":9689425,"ga_prefix":"072607","title":"初入职场的新人，什么行为或者话会让老员工反感？"},{"images":["https://pic2.zhimg.com/v2-66e3a89053b52c7ec94209b3fb77b5b9.jpg"],"type":0,"id":9689796,"ga_prefix":"072607","title":"突然被关进精神病院，如何证明你是正常人？"},{"images":["https://pic2.zhimg.com/v2-fe7b0acf96a300b588efa86205de27f1.jpg"],"type":0,"id":9691021,"ga_prefix":"072606","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic1.zhimg.com/v2-9cfe40c7657dc3ae98952a20edc48934.jpg","type":0,"id":9691101,"ga_prefix":"072610","title":"火星上发现了液态水湖？我仔细读完原文，发现不一定"},{"image":"https://pic2.zhimg.com/v2-fe7d02998e0f928877345c62465a4db1.jpg","type":0,"id":9691047,"ga_prefix":"072608","title":"大学生如何充分利用起 MacBook Pro？"},{"image":"https://pic1.zhimg.com/v2-3d2c7922d266739a9f68308f932b9488.jpg","type":0,"id":9691041,"ga_prefix":"072607","title":"今年「反常」的百日咳发病人数，也开始让人疑心起来"},{"image":"https://pic2.zhimg.com/v2-3652583d28068a2d778769a4bc22b129.jpg","type":0,"id":9690988,"ga_prefix":"072609","title":"「空有上进心，却没执行力」，我有个对策"},{"image":"https://pic2.zhimg.com/v2-27abb0dcdb6d378ae37088dc85509cb5.jpg","type":0,"id":9689796,"ga_prefix":"072607","title":"突然被关进精神病院，如何证明你是正常人？"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic4.zhimg.com/v2-ebb0f8e290ba8a6753a6aa24733bd00f.jpg"]
         * type : 0
         * id : 9691101
         * ga_prefix : 072610
         * title : 火星上发现了液态水湖？我仔细读完原文，发现不一定
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic1.zhimg.com/v2-9cfe40c7657dc3ae98952a20edc48934.jpg
         * type : 0
         * id : 9691101
         * ga_prefix : 072610
         * title : 火星上发现了液态水湖？我仔细读完原文，发现不一定
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
