package com.example.administrator.quarter.ui.sliding.follow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.quarter.R;
import com.example.administrator.quarter.bean.FollowUsersBean;
import com.example.administrator.quarter.component.DaggerHttpComponent;
import com.example.administrator.quarter.ui.base.BaseActivity;
import com.example.administrator.quarter.ui.sliding.follow.hotfollow.HotFollowActivity;
import com.example.administrator.quarter.ui.sliding.login.Login2Activity;
import com.example.administrator.quarter.utils.SharedPreferencesUtils;

import java.util.List;

public class FollowActivity extends BaseActivity<MyFollowPresenter> implements View.OnClickListener,MyFollowContract.view {

    private ImageView mImg;
    private TextView mFanhui;
    private TextView mRemen;
    private RecyclerView mRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.fanhui:
                finish();
                break;
            case R.id.remen:

                Intent intent = new Intent(FollowActivity.this, HotFollowActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_follow;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder().build().inject(this);
    }

    @Override
    public void initView(View view) {

    }

    public void initView() {
        mImg = (ImageView) findViewById(R.id.img);
        mFanhui = (TextView) findViewById(R.id.fanhui);
        mFanhui.setOnClickListener(this);
        mRemen = (TextView) findViewById(R.id.remen);
        mRemen.setOnClickListener(this);
        mRv = (RecyclerView) findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.addItemDecoration(new DividerItemDecoration(this,RecyclerView.VERTICAL));
        String uid = (String) SharedPreferencesUtils.getParam(FollowActivity.this, "uid", "-1");
        String token = (String) SharedPreferencesUtils.getParam(FollowActivity.this, "token", "");
        if ("-1".equals(uid)){
            Intent intent = new Intent(FollowActivity.this, Login2Activity.class);
            intent.putExtra("flay",1);
            startActivity(intent);
        }else {
            mPresenter.getFollowUsers(uid, token);
        }
    }

    @Override
    public void getFollowUsers(FollowUsersBean followUsersBean) {
        Toast.makeText(FollowActivity.this,"获取成功",Toast.LENGTH_SHORT).show();
        List<FollowUsersBean.DataBean> data = followUsersBean.getData();
        MyFollowAdapter adapter = new MyFollowAdapter(FollowActivity.this,data);
        mRv.setAdapter(adapter);
    }
}
