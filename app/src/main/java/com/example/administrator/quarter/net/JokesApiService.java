package com.example.administrator.quarter.net;

import com.example.administrator.quarter.bean.JokesBean;

import io.reactivex.Observable;
import retrofit2.http.GET;


public interface JokesApiService {
        @GET("quarter/getVideos?page=6")
        Observable<JokesBean> getJokes();
}
