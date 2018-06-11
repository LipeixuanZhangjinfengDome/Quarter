package com.example.administrator.quarter.ui.sliding.follow;

import com.example.administrator.quarter.bean.FollowUsersBean;
import com.example.administrator.quarter.net.AddfavoriteApi;
import com.example.administrator.quarter.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MyFollowPresenter extends BasePresenter<MyFollowContract.view> implements MyFollowContract.presenter {
    AddfavoriteApi addfavoriteApi;
    @Inject
    public MyFollowPresenter(AddfavoriteApi addfavoriteApi) {
        this.addfavoriteApi = addfavoriteApi;
    }

    @Override
    public void getFollowUsers(String uid, String token) {
        addfavoriteApi.getFollowUsers(uid,token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<FollowUsersBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FollowUsersBean followUsersBean) {
                        if (mView!=null){
                            mView.getFollowUsers(followUsersBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
