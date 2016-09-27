package com.uestczhh.app.network;

import com.uestczhh.app.BaseApplication;
import com.uestczhh.app.common.ApiConstant;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhanghao on 2016/9/27.
 */
public class RetrofitManager {
    private RetrofitService mService;
    //设置缓存位两天
    private static final String CACHE_STALE_SEC = "60*60*24*2";

    /**
     * 查询缓存的Cache-Control设置，为if-only-cache时只查询缓存而不会请求服务器，max-stale可以配合设置缓存失效时间
     * max-stale 指示客户机可以接收超出超时期间的响应消息。如果指定max-stale消息的值，那么客户机可接收超出超时期指定值之内的响应消息。
     */
    private static final String CACHE_CONTROL_CACHE = "only-if-cached, max-stale=" + CACHE_STALE_SEC;

    /**
     * 查询网络的Cache-Control设置，头部Cache-Control设为max-age=0
     * (假如请求了服务器并在a时刻返回响应结果，则在max-age规定的秒数内，浏览器将不会发送对应的请求到服务器，数据由缓存直接返回)时则不会使用缓存而请求服务器
     */
    private static final String CACHE_CONTROL_AGE = "max-age=0";

    private static volatile OkHttpClient mOkHttpClient;

    private OkHttpClient getmOkHttpClient() {

        if (mOkHttpClient == null) {
            synchronized (RetrofitManager.class) {
                Cache cache = new Cache(new File(BaseApplication.getInstance().getCacheDir(), "retrofit_cache"), 1024 * 1024 * 100);
                if (mOkHttpClient == null) {
                    mOkHttpClient = new OkHttpClient.Builder().cache(cache)
                            .connectTimeout(6, TimeUnit.SECONDS)
                            .readTimeout(6, TimeUnit.SECONDS)
                            .writeTimeout(6, TimeUnit.SECONDS)
                            .addInterceptor(null)
                            .addNetworkInterceptor(null)
                            .build();
                }
            }
        }
        return mOkHttpClient;
    }

    //配置retrofit
    public RetrofitManager(int hostType) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiConstant.getHost(hostType))
                .client(getmOkHttpClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mService = retrofit.create(RetrofitService.class);
    }

}












