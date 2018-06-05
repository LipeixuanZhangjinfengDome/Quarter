package com.example.administrator.quarter.net;

import com.example.administrator.quarter.bean.AdBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface AdApiService {
    @GET("quarter/getAd")
    Observable<AdBean> getAd();
}
