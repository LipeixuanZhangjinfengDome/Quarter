package com.example.administrator.quarter.Module;

import com.example.administrator.quarter.net.AdApi;
import com.example.administrator.quarter.net.AdApiService;
import com.example.administrator.quarter.net.Api;
import com.example.administrator.quarter.net.DuanZiApi;
import com.example.administrator.quarter.net.DuanZiApiService;
import com.example.administrator.quarter.net.HotVideosApi;
import com.example.administrator.quarter.net.HotVideosApiService;
import com.example.administrator.quarter.net.JokesApi;
import com.example.administrator.quarter.net.JokesApiService;
import com.example.administrator.quarter.net.MyInterceptor;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class HttpModule {
    @Provides
    OkHttpClient.Builder provideOkHttpClientBuilder(){
        return new OkHttpClient.Builder()
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS);

    }

    @Provides
    AdApi provideAdApi(OkHttpClient.Builder builder){
        builder.addInterceptor(new MyInterceptor());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        AdApiService adApiService = retrofit.create(AdApiService.class);
        return AdApi.getAdApi(adApiService);
    }

    @Provides
    JokesApi provideJokesApi(OkHttpClient.Builder builder){
        builder.addInterceptor(new MyInterceptor());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        JokesApiService jokesApiService = retrofit.create(JokesApiService.class);
        return JokesApi.getJokes(jokesApiService);
    }
    @Provides
    DuanZiApi provideDuanZiApi(OkHttpClient.Builder builder){
        builder.addInterceptor(new MyInterceptor());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        DuanZiApiService duanZiApiService = retrofit.create(DuanZiApiService.class);
        return DuanZiApi.getDuanZiApi(duanZiApiService);
    }
    @Provides
    HotVideosApi provideHotVideosApi(OkHttpClient.Builder builder){
        builder.addInterceptor(new MyInterceptor());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        HotVideosApiService hotVideosApiService = retrofit.create(HotVideosApiService.class);
        return HotVideosApi.getHotVideosApi(hotVideosApiService);
    }

}
