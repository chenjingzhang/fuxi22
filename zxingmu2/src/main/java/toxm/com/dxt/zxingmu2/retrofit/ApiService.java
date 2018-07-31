package toxm.com.dxt.zxingmu2.retrofit;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;
import toxm.com.dxt.zxingmu2.bean.MeiNvGson;
import toxm.com.dxt.zxingmu2.bean.NewsGson;

public interface ApiService {

    @GET("{type}/")
    Observable<NewsGson> getNewsData(@Path("type") String type, @Query("key")String key, @Query("num") String num, @Query("page") int page);

    @GET("meinv/")
    Observable <MeiNvGson> getPictureData(@Query("key")String key, @Query("num") String num, @Query("page") int page);
}
