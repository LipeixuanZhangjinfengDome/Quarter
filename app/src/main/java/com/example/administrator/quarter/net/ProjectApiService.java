package com.example.administrator.quarter.net;

import com.example.administrator.quarter.bean.RegBean;
import com.example.administrator.quarter.bean.UpdatePassBean;
import com.example.administrator.quarter.bean.UserBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ProjectApiService {
    @FormUrlEncoded
    @POST("user/login")
    Observable<UserBean> login(@Field("mobile") String mobile,
                               @Field("password") String password);

    //注册
    @FormUrlEncoded
    @POST("quarter/register")
    Observable<RegBean> reg(@Field("mobile") String mobile,
                            @Field("password") String password);

    @FormUrlEncoded
    @POST("quarter/getPass")
    Observable<UpdatePassBean> getPass(@Field("mobile") String mobile, @Field("newPass") String newPass);
}
