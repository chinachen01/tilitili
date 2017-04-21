package com.focus.tilitili.component.net;


import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.focus.tilitili.BuildConfig;
import com.focus.tilitili.app.App;
import com.focus.tilitili.component.net.cookie.ClearableCookieJar;
import com.focus.tilitili.component.net.cookie.PersistentCookieJar;
import com.focus.tilitili.component.net.cookie.cache.SetCookieCache;
import com.focus.tilitili.component.net.cookie.persistence.SharedPrefsCookiePersistor;
import com.focus.tilitili.utils.SystemUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class HttpClient {
    private static final String BASE_HOST_URL = "https://api.douban.com/";

    private Retrofit mRetrofit;
    private ApiService mService;
    private static OkHttpClient okHttpClient;

    private static void initOkHttp() {
        if (okHttpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
                builder.addInterceptor(loggingInterceptor);
                builder.addNetworkInterceptor(new StethoInterceptor());
            }
            File cacheFile = new File(Constants.PATH_CACHE);
            Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
            Interceptor cacheInterceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    if (!SystemUtils.isNetworkConnected()) {
                        request = request.newBuilder()
                                .cacheControl(CacheControl.FORCE_CACHE)
                                .build();
                    }
                    Response response = chain.proceed(request);
                    /* 设置max-age为5分钟之后，这5分钟之内不管有没有网, 都读缓存。
                     * max-stale设置为5天，意思是，网络未连接的情况下设置缓存时间为1天 */
                    CacheControl cacheControl = new CacheControl.Builder()
                            .maxAge(5, TimeUnit.MINUTES)
                            .maxStale(5, TimeUnit.DAYS)
                            .build();

                    return response.newBuilder()
                            //在这里生成新的响应并修改它的响应头
                            .header("Cache-Control", cacheControl.toString())
                            .removeHeader("Pragma").build();
                }
            };
            ClearableCookieJar cookieJar = new PersistentCookieJar(
                    new SetCookieCache(), new SharedPrefsCookiePersistor(App.getInstance())
            );
            builder.addInterceptor(new MockInterceptor()) //mock data
//                    .addNetworkInterceptor(cacheInterceptor) //设置缓存
//                    .addInterceptor(new TokenInterceptor()) //add token
//                    .addInterceptor(cacheInterceptor)
//                    .cache(cache)
                    .cookieJar(cookieJar);

            //设置超时
            builder.connectTimeout(10, TimeUnit.SECONDS);
            builder.readTimeout(20, TimeUnit.SECONDS);
            builder.writeTimeout(20, TimeUnit.SECONDS);
            //错误重连
            builder.retryOnConnectionFailure(true);
            okHttpClient = builder.build();
        }
    }

    //构造方法私有
    private HttpClient() {
        initOkHttp();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_HOST_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mService = mRetrofit.create(ApiService.class);
    }

    public ApiService getApiService() {
        return mService;
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final HttpClient INSTANCE = new HttpClient();
    }

    //获取单例
    public static HttpClient getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void uploadFile(String path, File file, ProgressRequestBody.ProgressListener progressListener) {
        if (file == null) {
            return;
        }
        String mimeType = "";
        HashMap<String, RequestBody> map = new HashMap<>();
        map.put("size", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(file.length())));
        map.put("type", RequestBody.create(MediaType.parse("text/plain"), mimeType));
        map.put(String.format("file\"; filename=\"%s", file.getName()), new ProgressRequestBody(RequestBody.create(MediaType.parse("text/plain"), mimeType), progressListener));
        mService.putFile(path, map);
    }
}
