package com.example.administrator.quarter.ui.duanzi.contract;

import com.example.administrator.quarter.bean.AdBean;
import com.example.administrator.quarter.bean.DuanZiBean;
import com.example.administrator.quarter.bean.JokesBean;
import com.example.administrator.quarter.ui.Recommend.contract.GetAdContract;
import com.example.administrator.quarter.ui.base.BaseContract;

public interface DuanZiContract {
    interface View extends BaseContract.BaseView{
       void onSuccess(DuanZiBean duanZiBean);
    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void getDuanZi();

    }
}
