
package com.example.administrator.quarter.ui.sliding.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.quarter.MainActivity;
import com.example.administrator.quarter.R;
import com.example.administrator.quarter.bean.UserBean;
import com.example.administrator.quarter.component.DaggerHttpComponent;
import com.example.administrator.quarter.ui.base.BaseActivity;
import com.example.administrator.quarter.ui.sliding.reg.RegActivity;
import com.example.administrator.quarter.ui.sliding.wjpass.WjPassActivity;
import com.example.administrator.quarter.utils.SharedPreferencesUtils;

public class Login2Activity extends BaseActivity<LoginPresenter> implements View.OnClickListener, LoginContract.view {
    private ImageView mImg2;
    /**
     * 注册账号
     */
    private TextView mTvZhuce;
    private ImageView mImg1;
    private EditText mName;
    private EditText mPass;
    /**
     * 登陆
     */
    private Button mBtnTijiao;
    /**
     * 忘记密码
     */
    private TextView mTvWangjimima;
    /**
     * 游客登陆
     */
    private TextView mTvYouke;
    private int flay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Intent intent = getIntent();
//        flay = intent.getIntExtra("flay", -1);
        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_tijiao:
                String mobile = mName.getText().toString();
                String password = mPass.getText().toString();
                mPresenter.login(mobile, password);
                break;
            case R.id.tv_zhuce:
                Toast.makeText(Login2Activity.this,"点击",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Login2Activity.this, RegActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_youke:

                finish();
                break;
            case R.id.tv_wangjimima:
                Intent intent1 = new Intent(Login2Activity.this, WjPassActivity.class);
                startActivity(intent1);
                break;
        }
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_login2;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder().build().inject(this);
    }

    @Override
    public void initView(View view) {

    }


    public void initView() {
        mImg2 = (ImageView) findViewById(R.id.img2);
        mTvZhuce = (TextView) findViewById(R.id.tv_zhuce);
        mTvZhuce.setOnClickListener(this);
        mImg1 = (ImageView) findViewById(R.id.img1);
        mName = (EditText) findViewById(R.id.name);
        mPass = (EditText) findViewById(R.id.pass);
        mBtnTijiao = (Button) findViewById(R.id.btn_tijiao);
        mBtnTijiao.setOnClickListener(this);
        mTvWangjimima = (TextView) findViewById(R.id.tv_wangjimima);
        mTvWangjimima.setOnClickListener(this);
        mTvYouke = (TextView) findViewById(R.id.tv_youke);
        mTvYouke.setOnClickListener(this);
        mImg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void loginSuccess(UserBean userBean) {
        UserBean.DataBean data = userBean.getData();
        String mobile = data.getMobile();
        SharedPreferencesUtils.setParam(this, "uid", userBean.getData().getUid() + "");
        SharedPreferencesUtils.setParam(this, "name", userBean.getData().getUsername() + "");
        SharedPreferencesUtils.setParam(this, "iconUrl", userBean.getData().getIcon() + "");
        SharedPreferencesUtils.setParam(this, "token", userBean.getData().getToken() + "");



        Intent intent = new Intent(Login2Activity.this, MainActivity.class);
        startActivity(intent);
//        if (flay==1){
//            finish();
//            Intent intent = new Intent(Login2Activity.this, FollowActivity.class);
//            startActivity(intent);
//        }else if (flay==2) {
//
//
//        }else if(flay==3){
//            finish();
//            Intent intent = new Intent(Login2Activity.this, AddfavoriteActivity.class);
//            startActivity(intent);
//        }else  if(flay==4){
//            finish();
//            Intent intent = new Intent(Login2Activity.this, SerchfriendsActivity.class);
//            startActivity(intent);
//        }

    }
}
