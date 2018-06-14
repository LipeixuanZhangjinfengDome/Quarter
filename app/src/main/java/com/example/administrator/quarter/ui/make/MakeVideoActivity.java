package com.example.administrator.quarter.ui.make;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.quarter.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

public class MakeVideoActivity extends AppCompatActivity {

    private ImageView mBankImage;
    private ImageView mChuangzuo;
    private LinearLayout mLay;
    private SimpleDraweeView mZuopinImage;
    private String url="http://img.soogif.com/D6W5ASKlBjXFk1emwHgsMhqnoSuLV83e.gif";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_video);
        initView();
    }

    private void initView() {
        mBankImage = (ImageView) findViewById(R.id.bank_image);
        mChuangzuo = (ImageView) findViewById(R.id.chuangzuo);
        mLay = (LinearLayout) findViewById(R.id.lay);
        mZuopinImage = (SimpleDraweeView) findViewById(R.id.zuopin_image);
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(url)
                .setAutoPlayAnimations(true)
                .build();
        mZuopinImage.setController(controller);

    }
}
