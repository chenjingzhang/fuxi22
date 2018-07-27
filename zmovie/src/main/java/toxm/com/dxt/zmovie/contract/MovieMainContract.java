package toxm.com.dxt.zmovie.contract;

import android.widget.ImageView;

import java.util.List;

import io.reactivex.Observable;
import toxm.com.dxt.zmovie.base.BasePresenter;
import toxm.com.dxt.zmovie.base.IBaseFragment;
import toxm.com.dxt.zmovie.bean.HotMovieBean;
import toxm.com.dxt.zmovie.bean.SubjectsBean;

public interface MovieMainContract {

    abstract class MovieMainPresenter extends BasePresenter<IMovieMainModel, IMovieMainView> {

        public abstract void loadHotMovieList();//加载最新的最热电影
        public abstract void onItemClick(int position, SubjectsBean item, ImageView imageView);//item点击事件
        public abstract void onHeaderClick();//Header被点击
    }

    interface IMovieMainModel extends IBaseModel {
        Observable<HotMovieBean> getHotMovieList();//获取最热电影
    }

    public interface IBaseModel {
    }


    interface IMovieMainView extends IBaseFragment {
        /**
         * 更新界面list
         *
         * @param list list
         */
        void updateContentList(List<SubjectsBean> list);

        /**
         * 显示网络错误
         */
        void showNetworkError();
    }

}
