package com.example.administrator.quarter.ui.sliding.login;

import com.example.administrator.quarter.bean.UserBean;
import com.example.administrator.quarter.ui.base.BaseContract;

public interface LoginContract {
    interface view extends BaseContract.BaseView{
        void loginSuccess(UserBean userBean);
       /* String getName();
        String getPass();*/
    }
    interface presenter extends BaseContract.BasePresenter<view> {
        void login(String mobile, String password);
    }
}
