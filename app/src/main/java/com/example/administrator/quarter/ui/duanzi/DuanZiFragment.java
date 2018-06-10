package com.example.administrator.quarter.ui.duanzi;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.administrator.quarter.R;
import com.example.administrator.quarter.bean.DuanZiBean;
import com.example.administrator.quarter.component.DaggerHttpComponent;
import com.example.administrator.quarter.ui.base.BaseFragment;
import com.example.administrator.quarter.ui.duanzi.adapter.DuanZiAdapter;
import com.example.administrator.quarter.ui.duanzi.contract.DuanZiContract;
import com.example.administrator.quarter.ui.duanzi.presenter.DuanZiPresenter;

public class DuanZiFragment extends BaseFragment<DuanZiPresenter> implements DuanZiContract.View {
    private View view;
    private RecyclerView mRlv;

    @Override
    public int getContentLayout() {
        return R.layout.duanzi_layout;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);

    }

    @Override
    public void initView(View view) {

        mRlv = (RecyclerView) view.findViewById(R.id.rlv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRlv.setLayoutManager(linearLayoutManager);
        mPresenter.getDuanZi();
    }


    @Override
    public void onSuccess(DuanZiBean duanZiBean) {
        DuanZiAdapter duanZiAdapter = new DuanZiAdapter(getContext(), duanZiBean.getData());
        mRlv.setAdapter(duanZiAdapter);

    }
}
