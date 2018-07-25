package toxm.com.dxt.lxiang1.util;

import android.os.Handler;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtils {

    public static HttpUtils httpUtils;
    DataCallback dataCallback;
    public static HttpUtils getHttpUtils() {
        if (httpUtils == null) {
            synchronized (HttpUtils.class) {
                httpUtils = new HttpUtils();
            }
        }
        return httpUtils;
    }

    public void setDataCallback(DataCallback dataCallback) {
        this.dataCallback = dataCallback;
    }

    public void getStrByNetWork(final int type, final String path, final Handler handler) {
        OkHttpClient client = new OkHttpClient.Builder().build();
        final Request request = new Request.Builder().url(path).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String str = response.body().string();
                if (dataCallback != null && str != null) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            dataCallback.setDataCallback(type, str);
                        }
                    });
                }
            }
        });

    }
}
