package com.example.administrator.quarter.ui.sliding.addfavorite;

import com.example.administrator.quarter.bean.AddfavoriteBean;
import com.example.administrator.quarter.ui.base.BaseContract;

public interface AddfavoriteContract {
    interface view extends BaseContract.BaseView{
        void getFavorites(AddfavoriteBean addfavoriteBean);

    }
    interface presenter extends BaseContract.BasePresenter<view> {
        void getFavorites(String uid,String token);

    }
}
