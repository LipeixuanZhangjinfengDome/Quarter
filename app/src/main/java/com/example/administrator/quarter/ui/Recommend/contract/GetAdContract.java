package com.example.administrator.quarter.ui.Recommend.contract;


import com.example.administrator.quarter.bean.AdBean;
import com.example.administrator.quarter.bean.JokesBean;
import com.example.administrator.quarter.ui.base.BaseContract;

public interface GetAdContract {
    interface View extends BaseContract.BaseView{
        void onSuccess(AdBean adBean);

        void onJokesSuccess(JokesBean jokesBean);
        void onaddSuccess(String str);

    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void getAd();

        void getJokes();

        void addCart(String uid, String wid, String token);
    }
}
