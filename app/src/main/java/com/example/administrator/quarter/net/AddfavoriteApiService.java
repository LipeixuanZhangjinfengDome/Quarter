package com.example.administrator.quarter.net;

import com.example.administrator.quarter.bean.AddfavoriteBean;
import com.example.administrator.quarter.bean.BaseBean;
import com.example.administrator.quarter.bean.FollowUsersBean;
import com.example.administrator.quarter.bean.HotFollowBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AddfavoriteApiService {
    //关注
    @FormUrlEncoded
    @POST("quarter/getFollowUsers")
    Observable<FollowUsersBean> getFollowUsers(@Field("uid") String uid,
                                               @Field("token") String token);

    //热门关注
    @FormUrlEncoded
    @POST("quarter/getHotVideos")
    Observable<HotFollowBean> getHotVideos(@Field("page") String page,
                                           @Field("token") String token);

    //我的收藏
    @FormUrlEncoded
    @POST("quarter/getFavorites")
    Observable<AddfavoriteBean> getFavorites(@Field("uid") String uid, @Field("token") String token);

    //收藏
    @FormUrlEncoded
    @POST("quarter/addFavorite")
    Observable<BaseBean> getAddFavorite(@Field("uid") String uid, @Field("wid") String wid, @Field("token") String token);

}
