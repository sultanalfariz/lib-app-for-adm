package com.example.asus.ublib_admin.Service;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Config {

    public static final String base_url = "http://192.168.1.3/ublib/public/api/";
    public static Retrofit builder(Context context) {
        OkHttpClient.Builder okhttpBuilder = new OkHttpClient().newBuilder();
        okhttpBuilder.connectTimeout(60, TimeUnit.SECONDS);
        okhttpBuilder.writeTimeout(60, TimeUnit.SECONDS);
        okhttpBuilder.readTimeout(60, TimeUnit.SECONDS);

        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(context.getCacheDir(), cacheSize);
        okhttpBuilder.cache(cache);

        //{
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)//Base url cek di class ContohService
                .client(okhttpBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
        //} yg ku kurungi ni penting pasti di pakai untuk menghubungkan android lwan service phpnya

    }
}
