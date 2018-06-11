package com.example.administrator.quarter;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.quarter.ui.Recommend.TuiJianFragment;
import com.example.administrator.quarter.ui.duanzi.DuanZiFragment;
import com.example.administrator.quarter.ui.sliding.follow.FollowActivity;
import com.example.administrator.quarter.ui.sliding.login.Login1Activity;
import com.example.administrator.quarter.ui.sliding.messagenotification.XiaoXiActivity;
import com.example.administrator.quarter.ui.sliding.serchfriends.SerchfriendsActivity;
import com.example.administrator.quarter.ui.video.VideoFragment;
import com.example.administrator.quarter.utils.BottomBar;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FragmentManager fragmentManager;
    private SimpleDraweeView mNameImage;
    private ImageView mChuangzuo;
    private LinearLayout mLay;
    private FrameLayout mFlout;
    private SimpleDraweeView my_head;
    private TextView my_name;

    private SlidingMenu menu;
    private LinearLayout lin;
    private DuanZiFragment duanZiFragment;
    private TuiJianFragment tuiJianFragment;
    private LinearLayout follow;
    private LinearLayout sf;
    private LinearLayout mn;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        BottomBar bottomBar = findViewById(R.id.bottom_bar);
        bottomBar.setContainer(R.id.flout)
                .setTitleBeforeAndAfterColor("#999999", "#ff5d5e")
                .addItem(TuiJianFragment.class,
                        "推荐",
                        R.drawable.huione,
                        R.drawable.blueone)
                .addItem(DuanZiFragment.class,
                        "段子",
                        R.drawable.huitwo,
                        R.drawable.bluetwo)
                .addItem(VideoFragment.class,
                        "视频",
                        R.drawable.huithree,
                        R.drawable.bluethree)
                .build();
        getMenu();
        //设置点击事件
        setLisenter();

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
        View lview = LayoutInflater.from(MainActivity.this).inflate(R.layout.sliding_left, null);
        menu.setMenu(lview);
        //查找侧滑菜单里面的
        lin = menu.findViewById(R.id.account);
        lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login1Activity.class);
                startActivity(intent);

            }
        });
        follow = menu.findViewById(R.id.follow);
        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FollowActivity.class);
                startActivity(intent);
            }
        });
        sf = menu.findViewById(R.id.searchfriends);
        sf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SerchfriendsActivity.class);
                startActivity(intent);
            }
        });
        mn = menu.findViewById(R.id.messagenotification);
        mn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, XiaoXiActivity.class);
                startActivity(intent);
            }
        });

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
        Uri uri = Uri.parse("res://drawable/" + R.drawable.touxiang);
        mNameImage.setImageURI(uri);
        // mNameImage.setBackgroundResource(R.drawable.touxiang);
        mNameImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.name_image:
                break;
        }
    }

}
