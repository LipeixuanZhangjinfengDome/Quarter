package com.example.administrator.quarter.ui.sliding.follow;

import com.example.administrator.quarter.bean.FollowUsersBean;
import com.example.administrator.quarter.ui.base.BaseContract;

public interface MyFollowContract {
    interface view extends BaseContract.BaseView{
        void getFollowUsers(FollowUsersBean followUsersBean);

    }
    interface presenter extends BaseContract.BasePresenter<view> {
        void getFollowUsers(String uid, String token);

    }
}
