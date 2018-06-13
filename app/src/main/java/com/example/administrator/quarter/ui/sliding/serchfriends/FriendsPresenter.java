package com.example.administrator.quarter.ui.sliding.serchfriends;

import com.example.administrator.quarter.bean.FriendsBean;
import com.example.administrator.quarter.bean.SouFriendsBean;
import com.example.administrator.quarter.net.AddfavoriteApi;
import com.example.administrator.quarter.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class FriendsPresenter extends BasePresenter<FriendsContract.view> implements FriendsContract.presenter{
    AddfavoriteApi addfavoriteApi;
    @Inject
    public FriendsPresenter( AddfavoriteApi addfavoriteApi) {
        this.addfavoriteApi=addfavoriteApi;
    }

    @Override
    public void randomFriends() {
        addfavoriteApi.randomFriends()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<FriendsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FriendsBean friendsBean) {
                        if (mView!=null){
                            mView.randomFriends(friendsBean);
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

    @Override
    public void searchFriends(String keywords) {
        addfavoriteApi.searchFriends(keywords)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<SouFriendsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SouFriendsBean souFriendsBean) {
                        if (mView!=null){
                            mView.searchFriends(souFriendsBean);
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
