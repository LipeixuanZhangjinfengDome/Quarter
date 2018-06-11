package com.example.administrator.quarter.ui.sliding.login;

import android.util.Log;

import com.example.administrator.quarter.bean.UserBean;
import com.example.administrator.quarter.net.ProjectApi;
import com.example.administrator.quarter.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter extends BasePresenter<LoginContract.view> implements LoginContract.presenter {
    ProjectApi projectApi;

    @Inject
    public LoginPresenter(ProjectApi projectApi) {
        this.projectApi = projectApi;
    }

    @Override
    public void login(String mobile, String password) {
        projectApi.login(mobile,password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserBean userBean) {
                        mView.loginSuccess(userBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        // Toast.makeText(LoginPresenter.this,"", Toast.LENGTH_SHORT).show();
                        Log.e("zzz","错误");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
