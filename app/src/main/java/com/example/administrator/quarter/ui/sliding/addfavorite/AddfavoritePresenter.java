package com.example.administrator.quarter.ui.sliding.addfavorite;

import com.example.administrator.quarter.bean.AddfavoriteBean;
import com.example.administrator.quarter.net.AddfavoriteApi;
import com.example.administrator.quarter.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AddfavoritePresenter extends BasePresenter<AddfavoriteContract.view> implements AddfavoriteContract.presenter {
    AddfavoriteApi addfavoriteApi;

    @Inject
    public AddfavoritePresenter(AddfavoriteApi addfavoriteApi) {
        this.addfavoriteApi = addfavoriteApi;
    }

    @Override
    public void getFavorites(String uid, String token) {
        addfavoriteApi.getFavorites(uid,token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<AddfavoriteBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AddfavoriteBean addfavoriteBean) {
                        if (mView!=null){
                            mView.getFavorites(addfavoriteBean);
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
