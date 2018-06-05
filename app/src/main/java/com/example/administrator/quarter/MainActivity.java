package com.example.administrator.quarter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrator.quarter.ui.Recommend.RecommendFragment;
import com.example.administrator.quarter.ui.base.BaseActivity;
import com.example.administrator.quarter.ui.sliding.login.Login1Activity;
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
    private SlidingMenu menu;
    private LinearLayout lin;


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
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
       /* //滑动显示的布局文件
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);*/
        //触摸哪里可以发生滑动
        menu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
        //屏幕宽度
        int v = (int) (getResources().getDisplayMetrics().widthPixels * 0.66);
        //侧滑菜单和主界面相融合
        menu.setBehindWidth(v);
        //侧滑菜单显示的宽度
        menu.setFadeDegree(0.35f);

        //为侧滑菜单设置布局
        /* menu.setMenu(R.layout.sliding_left);*/
        View lview = LayoutInflater.from(MainActivity.this).inflate(R.layout.sliding_left, null);
        menu.setMenu(lview);
        //查找侧滑菜单里面的
       /* my_head = menu.findViewById(R.id.my_head);
        my_name = menu.findViewById(R.id.my_name);*/
        lin = menu.findViewById(R.id.lin1);
        lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login1Activity.class);
                startActivity(intent);

            }
        });
        /* my_head.setOnClickListener(this);*/
    }

    public void setLisenter() {

        mNameImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //打开侧滑菜单
                menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//全屏滑出
                menu.showMenu();
                menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);//不可以滑出,只可以点击

            }
        });

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
