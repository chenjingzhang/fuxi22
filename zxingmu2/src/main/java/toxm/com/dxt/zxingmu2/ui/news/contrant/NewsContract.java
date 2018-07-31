package toxm.com.dxt.zxingmu2.ui.news.contrant;

import java.util.List;

import toxm.com.dxt.zxingmu2.bean.NewsGson;

public interface NewsContract {


    interface View{
        void returnData(List<NewsGson.NewslistBean> datas);
    }

    interface OnLoadFirstDataListener{
        void  onSuccess(List<NewsGson.NewslistBean> list);
        void  onFailure(String str,Throwable e);
    }

    interface Presenter  {
        void loadData(int type, int page);
    }

    interface Model {
        void loadData( int type, OnLoadFirstDataListener listener,int page);
    }

}
