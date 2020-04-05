package com.hilal.cryptomoneyapp.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    static Retrofit retrofit;

    public static OkHttpClient okHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                Request originalRequest = chain.request();

                Request.Builder builder = originalRequest.newBuilder().header("Authorization", "com.hilal.cryptomoneyapp");

                Request newRequest = builder.build();
                return chain.proceed(newRequest);
            }
        }).build();
        return okHttpClient;
    }

    public static Retrofit retrofitClient() {
        Gson gson = new GsonBuilder().setLenient().create();
        String BASE_URL = "https://api.coinranking.com/";
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }
}