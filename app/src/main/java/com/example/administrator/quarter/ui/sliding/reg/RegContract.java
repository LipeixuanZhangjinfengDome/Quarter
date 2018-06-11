package com.example.administrator.quarter.ui.sliding.reg;

import com.example.administrator.quarter.ui.base.BaseContract;

public interface RegContract {
    interface View extends BaseContract.BaseView {
        void regSuccess();
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void reg(String mobile, String password);
    }
}
