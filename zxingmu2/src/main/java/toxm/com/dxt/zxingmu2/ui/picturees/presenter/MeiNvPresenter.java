package toxm.com.dxt.zxingmu2.ui.picturees.presenter;

import android.content.Context;

import java.util.List;

import toxm.com.dxt.zxingmu2.bean.MeiNvGson;
import toxm.com.dxt.zxingmu2.ui.picturees.contract.MeiNvContract;
import toxm.com.dxt.zxingmu2.ui.picturees.model.MeiNvModel;

public class MeiNvPresenter implements MeiNvContract.Presenter,MeiNvContract.OnLoadFirstDataListener{
   private MeiNvContract.View view;
   private MeiNvContract.Model model;
   private Context context;

    public MeiNvPresenter(MeiNvContract.View view, Context context) {
        this.view = view;
        this.model = new MeiNvModel();
    }

    @Override
    public void onSuccess(List<MeiNvGson.NewslistBean> list) {
         view.returnData(list);
    }

    @Override
    public void onFailure(String str, Exception e) {

    }

    @Override
    public void loadData(int page) {
      model.loadData(this,page);//调用Model中的loadData()获得数据
    }
}
