package com.example.administrator.quarter.ui.make;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.quarter.R;
import com.example.administrator.quarter.ui.video.VideoActivity;

public class SuccessActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 前去看看！！
     */
    private Button mTiaoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        initView();
    }

    private void initView() {
        mTiaoBtn = (Button) findViewById(R.id.tiao_btn);
        mTiaoBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tiao_btn:
                Intent intent = new Intent(SuccessActivity.this, VideoActivity.class);
                startActivity(intent);
                break;
        }
    }
}
