package com.example.administrator.quarter.ui.sliding.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.quarter.R;

public class Login1Activity extends AppCompatActivity {

    private TextView ol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        ol = findViewById(R.id.otherlogin);
        ol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login1Activity.this, Login2Activity.class);
                startActivity(intent);
            }
        });
    }
}
