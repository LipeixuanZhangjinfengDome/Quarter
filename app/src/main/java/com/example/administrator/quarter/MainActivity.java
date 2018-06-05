package com.example.administrator.quarter;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrator.quarter.ui.Recommend.RecommendFragment;
import com.example.administrator.quarter.ui.Recommend.TuiJianFragment;
import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private SimpleDraweeView mNameImage;
    private ImageView mChuangzuo;
    private LinearLayout mLay;
    private FrameLayout mFlout;
    private SimpleDraweeView my_head;
    private TextView my_name;
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
        setContentView(R.layout.activity_main);
        initView();
        fragmentManager = getSupportFragmentManager();
        TuiJianFragment tuiJianFragment = new TuiJianFragment();
        fragmentManager.beginTransaction().replace(R.id.flout, tuiJianFragment).commit();
        //设置点击事件
        setLisenter();

    }

    private void getMenu() {

    }

    public void setLisenter() {


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
        Uri uri = Uri.parse("http://tx.haiqq.com/uploads/allimg/160812/102GJ358-9.jpg");
        mNameImage.setImageURI(uri);
    }

    /*@Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void inject() {

    }

    @Override
    public void initView(View view) {

    }*/
}
