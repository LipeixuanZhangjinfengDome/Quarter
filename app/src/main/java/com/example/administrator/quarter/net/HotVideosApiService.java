package com.example.administrator.quarter.net;

import com.example.administrator.quarter.bean.HotVideosBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface HotVideosApiService {
    @FormUrlEncoded
    @POST("quarter/getHotVideos")
    Observable<HotVideosBean> getHotVideo(@Field("type") String type,@Field("token") String token);


}
