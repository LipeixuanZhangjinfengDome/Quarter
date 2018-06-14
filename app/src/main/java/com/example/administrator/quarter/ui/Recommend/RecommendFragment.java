package com.example.administrator.quarter.ui.Recommend;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.quarter.R;
import com.example.administrator.quarter.bean.AdBean;
import com.example.administrator.quarter.bean.JokesBean;
import com.example.administrator.quarter.component.DaggerHttpComponent;
import com.example.administrator.quarter.ui.Recommend.Presenter.GetAdPresenter;
import com.example.administrator.quarter.ui.Recommend.adapter.RecommendAdapter;
import com.example.administrator.quarter.ui.Recommend.contract.GetAdContract;
import com.example.administrator.quarter.ui.base.BaseFragment;
import com.example.administrator.quarter.utils.GlideImageLoader;
import com.example.administrator.quarter.utils.SharedPreferencesUtils;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;


public  class RecommendFragment extends BaseFragment<GetAdPresenter> implements GetAdContract.View{
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
        mRlv = (RecyclerView) view.findViewById(R.id.rlv);
        mBanner.setImageLoader(new GlideImageLoader());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRlv.setLayoutManager(linearLayoutManager);
        String token = (String) SharedPreferencesUtils.getParam(getContext(), "token", "");
        String uid = (String) SharedPreferencesUtils.getParam(getContext(), "uid", "");
        mPresenter.getAd();
        mPresenter.getJokes();

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
    public void onJokesSuccess(final JokesBean jokesBean) {
        RecommendAdapter recommendAdapter = new RecommendAdapter(getContext(), jokesBean.getData(),mPresenter);
        mRlv.setAdapter(recommendAdapter);


    }

    @Override
    public void onaddSuccess(String str) {
        Toast.makeText(getContext(), str, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBanner.stopAutoPlay();
    }


}
