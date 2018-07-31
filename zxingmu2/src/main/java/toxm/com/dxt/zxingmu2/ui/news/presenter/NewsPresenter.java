package toxm.com.dxt.zxingmu2.ui.news.presenter;

import android.content.Context;

import java.util.List;

import toxm.com.dxt.zxingmu2.bean.NewsGson;
import toxm.com.dxt.zxingmu2.ui.news.contrant.NewsContract;
import toxm.com.dxt.zxingmu2.ui.news.model.NewsModel;

public class NewsPresenter implements NewsContract.Presenter,NewsContract.OnLoadFirstDataListener{
    private NewsContract.View view;
    private NewsContract.Model model;
    private Context context;

    public NewsPresenter(NewsContract.View view, Context context) {
        this.view = view;
        this.model = new NewsModel();//获取数据
        this.context = context;
    }

    @Override
    public void onSuccess(List<NewsGson.NewslistBean> list) {
        view.returnData(list);
    }

    @Override
    public void onFailure(String type, Throwable e) {

    }

    @Override
    public void loadData(int type, int page) { //获取数据
       model.loadData(type,this,page);
    }
}



























