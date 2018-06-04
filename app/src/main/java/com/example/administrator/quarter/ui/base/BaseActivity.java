package com.example.administrator.quarter.ui.base;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.quarter.inter.IBase;

import javax.inject.Inject;

public abstract class BaseActivity <T extends BaseContract.BasePresenter> extends AppCompatActivity implements IBase,BaseContract.BaseView {
    @Inject
    protected T mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentLayout());
        inject();
        if (mPresenter!=null){
            mPresenter.attchView(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.detachView();
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }
}
