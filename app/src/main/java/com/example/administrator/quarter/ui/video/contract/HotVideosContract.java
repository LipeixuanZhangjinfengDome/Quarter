package com.example.administrator.quarter.ui.video.contract;

import com.example.administrator.quarter.bean.AdBean;
import com.example.administrator.quarter.bean.HotVideosBean;
import com.example.administrator.quarter.bean.JokesBean;
import com.example.administrator.quarter.ui.Recommend.contract.GetAdContract;
import com.example.administrator.quarter.ui.base.BaseContract;

public interface HotVideosContract {
    interface View extends BaseContract.BaseView{
        void onHotVideosSuccess(HotVideosBean hotVideosBean);

    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void getHotVideos(String page,String token);

    }
}
