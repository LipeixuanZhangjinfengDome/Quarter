package com.example.administrator.quarter.ui.video;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.quarter.R;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class VideoActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImg1;
    private ImageView mImg2;
    private ImageView mImg3;
    private ImageView mImg4;
    private ImageView mImg5;
    private JCVideoPlayerStandard mVideoStart;
    private TextView mTv1;
    private TextView mTv2;
    /**
     * 拿起手机速来抢个沙发吧！~
     */
    private TextView mTv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        initView();
        Intent intent = getIntent();
        String bean = intent.getStringExtra("bean");
        mVideoStart.setUp(bean, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "");
        Glide.with(getApplicationContext()).load("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640")
                .into(mVideoStart.thumbImageView);

        mImg2.setTag(1);
        mImg3.setTag(1);
        mImg4.setTag(1);


    }

    private void initView() {
        mImg1 = (ImageView) findViewById(R.id.img1);
        mImg2 = (ImageView) findViewById(R.id.img2);
        mImg3 = (ImageView) findViewById(R.id.img3);
        mImg4 = (ImageView) findViewById(R.id.img4);
        mImg5 = (ImageView) findViewById(R.id.img5);
        mVideoStart = (JCVideoPlayerStandard) findViewById(R.id.video_start);
        mTv1 = (TextView) findViewById(R.id.tv1);
        mTv2 = (TextView) findViewById(R.id.tv2);
        mTv3 = (TextView) findViewById(R.id.tv3);
        mImg1.setOnClickListener(this);
        mImg2.setOnClickListener(this);
        mImg3.setOnClickListener(this);
        mImg4.setOnClickListener(this);
        mImg5.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.img1:


                break;
            case R.id.img2:
                int tag = (int) mImg2.getTag();
                if (tag==1) {
                    mImg2.setBackgroundResource(R.drawable.oneleft);

                    mImg2.setTag(2);
                }else {
                    mImg2.setBackgroundResource(R.drawable.xin);
                    mImg2.setTag(1);
                }
                break;
                case R.id.img3:
                int tag1 = (int) mImg3.getTag();
                if (tag1==1) {
                    mImg3.setBackgroundResource(R.drawable.heicheck);

                    mImg3.setTag(2);
                }else {
                    mImg3.setBackgroundResource(R.drawable.lie);
                    mImg3.setTag(1);
                }
                break;
                /*case R.id.img4:
                int tag = (int) mImg4.getTag();
                if (tag==1) {
                    mImg4.setBackgroundResource(R.drawable.oneleft);

                    mImg4.setTag(2);
                }else {
                    mImg4.setBackgroundResource(R.drawable.xin);
                    mImg4.setTag(1);
                }
                break;*/
            case R.id.img5:
                break;
        }
    }
}
