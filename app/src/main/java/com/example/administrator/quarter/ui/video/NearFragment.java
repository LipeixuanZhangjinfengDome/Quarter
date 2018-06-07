package com.example.administrator.quarter.ui.video;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.administrator.quarter.Component.DaggerHttpComponent;
import com.example.administrator.quarter.R;
import com.example.administrator.quarter.bean.HotVideosBean;
import com.example.administrator.quarter.ui.base.BaseFragment;
import com.example.administrator.quarter.ui.video.adapter.HotAdapter;
import com.example.administrator.quarter.ui.video.contract.HotVideosContract;
import com.example.administrator.quarter.ui.video.presenter.HotVideosPresenter;
import com.example.administrator.quarter.utils.SpacesItemDecoration;

public class NearFragment extends BaseFragment<HotVideosPresenter> implements HotVideosContract.View {
    private View view;
    private RecyclerView mRlv;

    @Override
    public int getContentLayout() {
        return R.layout.near_layout;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder().build().inject(this);

    }

    @Override
    public void initView(View view) {
        mRlv = (RecyclerView) view.findViewById(R.id.rlv);
        mRlv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        mPresenter.getHotVideos("1", "491DD2892EEBAA6C42B869F30AF027AF");
    }

    @Override
    public void onHotVideosSuccess(HotVideosBean hotVideosBean) {
        HotAdapter hotAdapter = new HotAdapter(getContext(), hotVideosBean.getData());
        mRlv.setAdapter(hotAdapter);
        //设置item之间的间隔
        SpacesItemDecoration decoration=new SpacesItemDecoration(16);
        mRlv.addItemDecoration(decoration);
    }
}
