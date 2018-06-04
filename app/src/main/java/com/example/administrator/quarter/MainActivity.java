package com.example.administrator.quarter;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.quarter.ui.Recommend.RecommendFragment;
import com.example.administrator.quarter.ui.base.BaseActivity;
import com.facebook.drawee.view.SimpleDraweeView;
/*lipeixuan=李佩璇*/
public class MainActivity extends BaseActivity {

    private FragmentManager fragmentManager;
    private SimpleDraweeView mNameImage;
    private ImageView mChuangzuo;
    private LinearLayout mLay;
    private FrameLayout mFlout;
    /**
     * 推荐
     */
    private RadioButton mBtn1;
    /**
     * 段子
     */
    private RadioButton mBtn2;
    /**
     * 视频
     */
    private RadioButton mBtn3;
    private RadioGroup mRg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentLayout());
        initView();
        fragmentManager = getSupportFragmentManager();
        RecommendFragment recommendFragment = new RecommendFragment();
        fragmentManager.beginTransaction().replace(R.id.flout, recommendFragment).commit();
        //设置点击事件
        setLisenter();
    }

    private void setLisenter() {
    }

    private void initView() {
        mNameImage = (SimpleDraweeView) findViewById(R.id.name_image);
        mChuangzuo = (ImageView) findViewById(R.id.chuangzuo);
        mLay = (LinearLayout) findViewById(R.id.lay);
        mFlout = (FrameLayout) findViewById(R.id.flout);
        mBtn1 = (RadioButton) findViewById(R.id.btn1);
        mBtn2 = (RadioButton) findViewById(R.id.btn2);
        mBtn3 = (RadioButton) findViewById(R.id.btn3);
        mRg = (RadioGroup) findViewById(R.id.rg);
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void inject() {

    }

    @Override
    public void initView(View view) {

    }
}
