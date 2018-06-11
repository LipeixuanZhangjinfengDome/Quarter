package com.example.administrator.quarter.ui.sliding.reg;

import com.example.administrator.quarter.bean.RegBean;
import com.example.administrator.quarter.net.ProjectApi;
import com.example.administrator.quarter.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RegPresenter extends BasePresenter<RegContract.View> implements RegContract.Presenter{
    ProjectApi projectApi;
    @Inject
    public RegPresenter(ProjectApi projectApi) {
        this.projectApi=projectApi;
    }

    @Override
    public void reg(String mobile, String password) {
        projectApi.reg(mobile,password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<RegBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegBean regBean) {
                        mView.regSuccess();
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
