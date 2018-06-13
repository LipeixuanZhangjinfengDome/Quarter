package com.example.administrator.quarter.ui.make;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.quarter.MainActivity;
import com.example.administrator.quarter.R;
import com.facebook.drawee.view.SimpleDraweeView;

public class MakeActivity extends AppCompatActivity implements View.OnClickListener {

    private SimpleDraweeView mDz;
    private SimpleDraweeView mSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make);
        initView();
    }

    private void initView() {
        mDz = (SimpleDraweeView) findViewById(R.id.dz);
        mDz.setOnClickListener(this);
        mSp = (SimpleDraweeView) findViewById(R.id.sp);
        mSp.setOnClickListener(this);

        Uri uri = Uri.parse("res://drawable/" + R.drawable.dz);
        mDz.setImageURI(uri);
        Uri uri1 = Uri.parse("res://drawable/" + R.drawable.sp);
        mSp.setImageURI(uri1);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.dz:
                Intent intent= new Intent(MakeActivity.this,MakeVideoActivity.class);
                startActivity(intent);
                break;
            case R.id.sp:
                Intent intent1= new Intent(MakeActivity.this,MakeDuanZiActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
