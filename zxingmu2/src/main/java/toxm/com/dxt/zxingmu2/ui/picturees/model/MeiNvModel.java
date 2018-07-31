package toxm.com.dxt.zxingmu2.ui.picturees.model;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import toxm.com.dxt.zxingmu2.bean.MeiNvGson;
import toxm.com.dxt.zxingmu2.retrofit.ApiService;
import toxm.com.dxt.zxingmu2.retrofit.AppConfig;
import toxm.com.dxt.zxingmu2.retrofit.RetrofitWrapper;
import toxm.com.dxt.zxingmu2.ui.picturees.contract.MeiNvContract;

public class MeiNvModel implements MeiNvContract.Model {
    @Override
    public void loadData(final MeiNvContract.OnLoadFirstDataListener listener, int page) {
        ApiService apiService = RetrofitWrapper.getInstance().create(ApiService.class);
        apiService.getPictureData(AppConfig.APIKEY, "6", page)
                .subscribeOn(Schedulers.io())
                .map(new Func1<MeiNvGson, List<MeiNvGson.NewslistBean>>() {
                    @Override
                    public List<MeiNvGson.NewslistBean> call(MeiNvGson meiNvGson) {
                        List<MeiNvGson.NewslistBean> meiNvList = new ArrayList<>();
                        for (MeiNvGson.NewslistBean newslistBean : meiNvGson.getNewslist()) {
                            MeiNvGson.NewslistBean ml = new MeiNvGson.NewslistBean();
                            ml.setTitle(newslistBean.getTitle());
                            ml.setCtime(newslistBean.getCtime());
                            ml.setDescription(newslistBean.getDescription());
                            ml.setPicUrl(newslistBean.getPicUrl());
                            ml.setUrl(newslistBean.getUrl());
                            meiNvList.add(ml);
                        }
                        return meiNvList;
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<MeiNvGson.NewslistBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<MeiNvGson.NewslistBean> newslistBeans) {
                        listener.onSuccess(newslistBeans);//回调presenter中的onSuccess()
                    }
                });
    }
}








































