package com.example.administrator.quarter.ui.Recommend;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.quarter.Module.HttpModule;
import com.example.administrator.quarter.R;
import com.example.administrator.quarter.bean.AdBean;
import com.example.administrator.quarter.component.DaggerHttpComponent;
import com.example.administrator.quarter.ui.Recommend.Presenter.GetAdPresenter;
import com.example.administrator.quarter.ui.Recommend.contract.GetAdContract;
import com.example.administrator.quarter.ui.base.BaseFragment;
import com.example.administrator.quarter.utils.GlideImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public  class RecommendFragment extends BaseFragment<GetAdPresenter> implements GetAdContract.View, View.OnClickListener {
    private View view;
    private Banner mBanner;
    private RecyclerView mRlv;

    @Override
    public int getContentLayout() {
        return R.layout.recommend_layout;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);

    }

    @Override
    public void initView(View view) {

        mBanner = (Banner) view.findViewById(R.id.banner);
        mBanner.setOnClickListener(this);
        mRlv = (RecyclerView) view.findViewById(R.id.rlv);
        mBanner.setImageLoader(new GlideImageLoader());
        mPresenter.getAd();
    }

    @Override
    public void onSuccess(AdBean adBean) {
        List<AdBean.DataBean> data = adBean.getData();
        List<String> images=new ArrayList<>();
        for (int i=0;i<data.size();i++){
            images.add(data.get(i).getIcon());
        }
        mBanner.setImages(images);
        mBanner.start();


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBanner.stopAutoPlay();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.banner:
                break;
        }
    }
}
