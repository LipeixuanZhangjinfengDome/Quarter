package com.example.administrator.quarter.ui.video;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.quarter.R;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMWeb;

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
    private Uri uri;
    private ImageView mImage1;
    private ImageView mImage2;
    private ImageView mImage3;
    private ImageView mImage4;
    private int one=1;
    private int two=2;

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
        uri = Uri.parse("res://drawable/" + R.drawable.touxiang);
        mImg5.setImageURI(uri);
        mVideoStart.setTag(1);
        mImage1.setTag(1);
        mImage2.setTag(1);

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
        mImage1 = (ImageView) findViewById(R.id.image1);
        mImage2 = (ImageView) findViewById(R.id.image2);
        mImage3 = (ImageView) findViewById(R.id.image3);
        mImage4 = (ImageView) findViewById(R.id.image4);


        mVideoStart.thumbImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag = (int) mVideoStart.getTag();
                if (tag == 1) {
                    mImage1.setVisibility(View.VISIBLE);
                    mImage2.setVisibility(View.VISIBLE);
                    mImage3.setVisibility(View.VISIBLE);
                    mImage4.setVisibility(View.VISIBLE);
                    mVideoStart.setTag(2);
                } else {
                    mImage1.setVisibility(View.GONE);
                    mImage2.setVisibility(View.GONE);
                    mImage3.setVisibility(View.GONE);
                    mImage4.setVisibility(View.GONE);
                    mVideoStart.setTag(1);
                }

            }
        });
        mImage1.setOnClickListener(this);
        mImage2.setOnClickListener(this);
        mImage3.setOnClickListener(this);
        mImage4.setOnClickListener(this);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
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
                finish();
                break;
            case R.id.img2:
                if (two == 1) {
                    return;
                } else {
                    if (one == 1) {
                        mImg2.setBackgroundResource(R.drawable.oneleft);
                        one=2;
                    } else {
                        mImg2.setBackgroundResource(R.drawable.xin);
                        one=1;
                    }
                }

                break;
            case R.id.img3:
                if (one == 2) {
                    return;
                } else {
                    if (two == 2) {
                        mImg3.setBackgroundResource(R.drawable.heicheck);
                       two=1;
                    } else {
                        mImg3.setBackgroundResource(R.drawable.lie);
                        two=2;
                    }
                }
                break;
            case R.id.img4:
                UMWeb umWeb = new UMWeb("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640");
                new ShareAction(VideoActivity.this).withMedia(umWeb).setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.QZONE)
                        .setCallback(shareListener).open();

                break;
            case R.id.img5:
                break;
            case R.id.image1:
                int tag2 = (int) mImage1.getTag();
                if (tag2==1){
                    mImage1.setBackgroundResource(R.drawable.oneleft);
                    mImage1.setTag(2);
                }else {
                    mImage1.setBackgroundResource(R.drawable.xin);
                    mImage1.setTag(1);
                }
                break;
            case R.id.image2:
                int tag3 = (int) mImage2.getTag();
                if (tag3==1){
                    mImage2.setBackgroundResource(R.drawable.huione);
                    mImage2.setTag(2);
                }else {
                    mImage2.setBackgroundResource(R.drawable.blueone);
                    mImage2.setTag(1);
                }
                break;
            case R.id.image3:
                UMWeb umWeb1 = new UMWeb("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640");
                new ShareAction(VideoActivity.this).withMedia(umWeb1).setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.QZONE)
                        .setCallback(shareListener).open();

                break;
            case R.id.image4:

                break;
        }
    }



    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(VideoActivity.this, "成功了", Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(VideoActivity.this, "失败" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(VideoActivity.this, "取消 了", Toast.LENGTH_LONG).show();

        }
    };
}
