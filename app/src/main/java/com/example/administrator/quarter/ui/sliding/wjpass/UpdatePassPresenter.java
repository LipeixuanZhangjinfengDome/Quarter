package com.example.administrator.quarter.ui.sliding.wjpass;

import com.example.administrator.quarter.bean.UpdatePassBean;
import com.example.administrator.quarter.net.ProjectApi;
import com.example.administrator.quarter.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UpdatePassPresenter  extends BasePresenter<UpdatePassContract.view> implements UpdatePassContract.presenter{
    ProjectApi projectApi;
    @Inject
    public UpdatePassPresenter(ProjectApi projectApi) {
        this.projectApi=projectApi;
    }

    @Override
    public void getPass(String mobile, String newPass) {
        projectApi.getPass(mobile, newPass)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UpdatePassBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UpdatePassBean updatePassBean) {
                        if (mView!=null){
                            mView.getPassSuccess(updatePassBean);
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
