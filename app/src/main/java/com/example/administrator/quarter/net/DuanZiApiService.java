package com.example.administrator.quarter.net;

import com.example.administrator.quarter.bean.DuanZiBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface DuanZiApiService {
    @GET("quarter/getJokes")
    Observable<DuanZiBean> getDuanZi();
}
