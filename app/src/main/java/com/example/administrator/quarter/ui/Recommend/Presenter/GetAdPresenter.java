package com.example.administrator.quarter.ui.Recommend.Presenter;

import com.example.administrator.quarter.bean.AdBean;
import com.example.administrator.quarter.net.AdApi;
import com.example.administrator.quarter.ui.Recommend.contract.GetAdContract;
import com.example.administrator.quarter.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GetAdPresenter extends BasePresenter<GetAdContract.View> implements GetAdContract.Presenter {
    private AdApi adApi;
    @Inject
    public GetAdPresenter(AdApi adApi) {
        this.adApi = adApi;
    }

    @Override
    public void getAd() {
        adApi.getAd()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<AdBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AdBean adBean) {
                        if (mView!=null){
                            mView.onSuccess(adBean);
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
