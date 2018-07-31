package toxm.com.dxt.zxingmu2.ui.news.model;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import toxm.com.dxt.zxingmu2.bean.NewsGson;
import toxm.com.dxt.zxingmu2.retrofit.ApiService;
import toxm.com.dxt.zxingmu2.retrofit.AppConfig;
import toxm.com.dxt.zxingmu2.retrofit.RetrofitWrapper;
import toxm.com.dxt.zxingmu2.ui.news.contrant.NewsContract;

public class NewsModel implements NewsContract.Model{
    @Override
    public void loadData(int type, final NewsContract.OnLoadFirstDataListener listener, int page) {
        ApiService apiService = RetrofitWrapper.getInstance().create(ApiService.class);
        apiService.getNewsData(getTypeUrl(type), AppConfig.APIKEY,"10",page)
                .subscribeOn(Schedulers.io())
                .map(new Func1<NewsGson, List<NewsGson.NewslistBean>>() {
                    @Override
                    public List<NewsGson.NewslistBean> call(NewsGson newsGson) {
                        List<NewsGson.NewslistBean> newsList = new ArrayList<>();
                        for(NewsGson.NewslistBean newslistBean:newsGson.getNewslist()){
                            NewsGson.NewslistBean new1 = new NewsGson.NewslistBean();
                            new1.setTitle(newslistBean.getTitle());
                            new1.setCtime(newslistBean.getCtime());
                            new1.setDescription(newslistBean.getDescription());
                            new1.setPicUrl(newslistBean.getPicUrl().replace("_ss",""));
                            new1.setUrl(newslistBean.getUrl());
                            newsList.add(new1);
                        }
                        return newsList;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<NewsGson.NewslistBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onFailure("请求失败", e);
                    }

                    @Override
                    public void onNext(List<NewsGson.NewslistBean> newslistBeans) {
                      listener.onSuccess(newslistBeans);  //成功  数据传出去
                    }
                });
    }


    public static String getTypeUrl(int type){
        switch (type){
            case 0:
                return "social";
            case 1:
                return "guonei";
            case 2:
                return "world";
            case 3:
                return "huabian";
            case 4:
                return "tiyu";
            case 5:
                return "keji";
            case 6:
                return "health";
            default:
                return "social";
        }
    }
}
