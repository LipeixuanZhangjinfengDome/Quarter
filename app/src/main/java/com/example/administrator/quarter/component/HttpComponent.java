package com.example.administrator.quarter.component;

import com.example.administrator.quarter.Module.HttpModule;
import com.example.administrator.quarter.ui.Recommend.GuanZhuFragment;
import com.example.administrator.quarter.ui.Recommend.RecommendFragment;
import com.example.administrator.quarter.ui.duanzi.DuanZiFragment;
import com.example.administrator.quarter.ui.sliding.addfavorite.AddfavoriteActivity;
import com.example.administrator.quarter.ui.sliding.follow.FollowActivity;
import com.example.administrator.quarter.ui.sliding.login.Login2Activity;
import com.example.administrator.quarter.ui.sliding.reg.RegActivity;
import com.example.administrator.quarter.ui.sliding.wjpass.WjPassActivity;
import com.example.administrator.quarter.ui.video.HotFragment;
import com.example.administrator.quarter.ui.video.NearFragment;

import dagger.Component;


@Component(modules = HttpModule.class)
public interface HttpComponent {
    void inject(RecommendFragment recommendFragment);

    void inject(GuanZhuFragment guanZhuFragment);

    void inject(DuanZiFragment duanZiFragment);

    void inject(HotFragment hotFragment);

    void inject(NearFragment nearFragment);

    void inject(FollowActivity followActivity);//关注

    void inject(AddfavoriteActivity addfavoriteActivity);//收藏

    void inject(Login2Activity login2Activity);

    void inject(RegActivity regActivity);
    void inject(WjPassActivity wjPassActivity);
}