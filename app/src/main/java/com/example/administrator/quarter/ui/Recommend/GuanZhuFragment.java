package com.example.administrator.quarter.ui.Recommend;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.quarter.R;
import com.example.administrator.quarter.bean.AdBean;
import com.example.administrator.quarter.bean.JokesBean;
import com.example.administrator.quarter.component.DaggerHttpComponent;
import com.example.administrator.quarter.ui.Recommend.Presenter.GetAdPresenter;
import com.example.administrator.quarter.ui.Recommend.adapter.RecommendAdapter;
import com.example.administrator.quarter.ui.Recommend.contract.GetAdContract;
import com.example.administrator.quarter.ui.base.BaseFragment;

public class GuanZhuFragment extends BaseFragment<GetAdPresenter> implements GetAdContract.View {
    private View view;
    private ImageView mImage;
    private RecyclerView mRlv;

    @Override
    public int getContentLayout() {
        return R.layout.guanzhu_layout;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);

    }

    @Override
    public void initView(View view) {

        mImage = (ImageView) view.findViewById(R.id.image);
        mRlv = (RecyclerView) view.findViewById(R.id.rlv);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRlv.setLayoutManager(linearLayoutManager);
        mImage.setBackgroundResource(R.drawable.belle);

        mPresenter.getJokes();
    }

    @Override
    public void onSuccess(AdBean adBean) {

    }

    @Override
    public void onJokesSuccess(JokesBean jokesBean) {
        RecommendAdapter recommendAdapter = new RecommendAdapter(getContext(), jokesBean.getData(),mPresenter);
        mRlv.setAdapter(recommendAdapter);

    }

    @Override
    public void onaddSuccess(String str) {

    }


}
