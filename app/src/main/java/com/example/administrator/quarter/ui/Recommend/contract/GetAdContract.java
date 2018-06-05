package com.example.administrator.quarter.ui.Recommend.contract;


import com.example.administrator.quarter.bean.AdBean;
import com.example.administrator.quarter.ui.base.BaseContract;

public interface GetAdContract {
    interface View extends BaseContract.BaseView{
        void onSuccess(AdBean adBean);
    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void getAd();
    }
}
