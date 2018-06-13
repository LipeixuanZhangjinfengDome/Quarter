package com.example.administrator.quarter.net;

import com.example.administrator.quarter.bean.AddfavoriteBean;
import com.example.administrator.quarter.bean.BaseBean;
import com.example.administrator.quarter.bean.FollowUsersBean;
import com.example.administrator.quarter.bean.FriendsBean;
import com.example.administrator.quarter.bean.SouFriendsBean;

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
    public  Observable<FriendsBean> randomFriends(){
        return addfavoriteApiService.randomFriends();
    }
    public  Observable<SouFriendsBean> searchFriends(String keywords){
        return addfavoriteApiService.searchFriends(keywords);
    }
    public Observable<BaseBean> getAddFavorite(String uid, String wid, String token){
        return addfavoriteApiService.getAddFavorite(uid,wid,token);
    }

}
