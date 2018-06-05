package com.example.administrator.quarter;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrator.quarter.ui.Recommend.RecommendFragment;
import com.example.administrator.quarter.ui.base.BaseActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/*lipeixuan=李佩璇*/
public class MainActivity extends BaseActivity {

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
        //侧滑菜单
        getMenu();
    }

    private void getMenu() {
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        //滑动显示的布局文件
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
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
        menu.setMenu(R.layout.sliding_left);
        my_head = menu.findViewById(R.id.my_head);
        my_name = menu.findViewById(R.id.my_name);
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
