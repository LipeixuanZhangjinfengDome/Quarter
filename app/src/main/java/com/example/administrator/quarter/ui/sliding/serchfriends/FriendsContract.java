package com.example.administrator.quarter.ui.sliding.serchfriends;

import com.example.administrator.quarter.bean.FriendsBean;
import com.example.administrator.quarter.bean.SouFriendsBean;
import com.example.administrator.quarter.ui.base.BaseContract;

public interface FriendsContract {
    interface view extends BaseContract.BaseView{
        void randomFriends(FriendsBean friendsBean);
        void searchFriends(SouFriendsBean souFriendsBean);
    }
    interface presenter extends BaseContract.BasePresenter<view> {
        void randomFriends();
        void searchFriends(String keywords);
    }
}
