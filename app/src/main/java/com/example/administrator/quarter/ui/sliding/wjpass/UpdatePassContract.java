package com.example.administrator.quarter.ui.sliding.wjpass;

import com.example.administrator.quarter.bean.UpdatePassBean;
import com.example.administrator.quarter.ui.base.BaseContract;

public interface UpdatePassContract {
    interface view extends BaseContract.BaseView{
        void getPassSuccess(UpdatePassBean updatePassBean);

    }
    interface presenter extends BaseContract.BasePresenter<view> {
        void getPass(String mobile, String newPass);

    }
}
