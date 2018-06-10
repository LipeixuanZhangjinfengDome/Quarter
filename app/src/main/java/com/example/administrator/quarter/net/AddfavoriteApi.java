package com.example.administrator.quarter.net;

import com.example.administrator.quarter.bean.AddfavoriteBean;
import com.example.administrator.quarter.bean.FollowUsersBean;

import io.reactivex.Observable;

public class AddfavoriteApi {
    private static AddfavoriteApi addfavoriteApi;
    private AddfavoriteApiService addfavoriteApiService;

    public AddfavoriteApi(AddfavoriteApiService addfavoriteApiService) {
        this.addfavoriteApiService = addfavoriteApiService;
    }

    public static AddfavoriteApi getAddfavoriteApi(AddfavoriteApiService addfavoriteApiService){
        if (addfavoriteApi==null){
            addfavoriteApi=new AddfavoriteApi(addfavoriteApiService);
        }
        return addfavoriteApi;
    }
    public Observable<FollowUsersBean> getFollowUsers(String uid, String token){
        return addfavoriteApiService.getFollowUsers(uid,token);
    }
    /*public Observable<HotFollowBean> getHotVideos(String page, String token){
        return addfavoriteApiService.getHotVideos(page, token);
    }*/
    public Observable<AddfavoriteBean> getFavorites(String uid, String token){
        return addfavoriteApiService.getFavorites(uid,token);
    }
}
