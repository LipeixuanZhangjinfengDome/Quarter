package com.example.administrator.quarter.ui.sliding.addfavorite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.quarter.R;
import com.example.administrator.quarter.bean.AddfavoriteBean;
import com.example.administrator.quarter.component.DaggerHttpComponent;
import com.example.administrator.quarter.ui.base.BaseActivity;
import com.example.administrator.quarter.ui.sliding.login.Login2Activity;
import com.example.administrator.quarter.utils.SharedPreferencesUtils;

import java.util.List;

public class AddfavoriteActivity extends BaseActivity<AddfavoritePresenter> implements View.OnClickListener,AddfavoriteContract.view {

    private ImageView mImg;
    private TextView mFanhui;
    private TextView mShanchu;
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
            case R.id.shanchu:

                break;
        }
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_addfavorite;
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
        mShanchu = (TextView) findViewById(R.id.shanchu);
        mShanchu.setOnClickListener(this);
        mRv = (RecyclerView) findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.addItemDecoration(new DividerItemDecoration(this,RecyclerView.VERTICAL));
        String uid = (String) SharedPreferencesUtils.getParam(AddfavoriteActivity.this, "uid", "-1");
        String token = (String) SharedPreferencesUtils.getParam(AddfavoriteActivity.this, "token", "");

        if ("-1".equals(uid)){
            Intent intent = new Intent(AddfavoriteActivity.this, Login2Activity.class);
            intent.putExtra("flay",3);
            startActivity(intent);
        }else {
            mPresenter.getFavorites(uid, token);
        }

    }

    @Override
    public void getFavorites(AddfavoriteBean addfavoriteBean) {
        Toast.makeText(AddfavoriteActivity.this,"获取成功",Toast.LENGTH_SHORT).show();
        List<AddfavoriteBean.DataBean> data = addfavoriteBean.getData();
        Log.e("zzzzzz",data.size()+"");
        AddfavoriteAdapter adapter = new AddfavoriteAdapter(AddfavoriteActivity.this, data);
        mRv.setAdapter(adapter);
    }
}
