package com.example.administrator.quarter.ui.base;

public interface BaseContract {
    interface BasePresenter<T extends BaseView>{
        void attchView(T view);

        void detachView();

    }
    interface BaseView{
        void showLoading();

        void dismissLoading();
    }

}
