package toxm.com.dxt.zxingmu2.ui.picturees.contract;

import java.util.List;

import toxm.com.dxt.zxingmu2.bean.MeiNvGson;

public interface MeiNvContract {

    interface View{
        void returnData(List<MeiNvGson.NewslistBean> datas);
    }

    interface OnLoadFirstDataListener{
        void  onSuccess(List<MeiNvGson.NewslistBean> list);
        void  onFailure(String str, Exception e);
    }

    interface Presenter  {
        void loadData( int page);
    }

    interface Model {
        void loadData(OnLoadFirstDataListener listener, int page);
    }

}
