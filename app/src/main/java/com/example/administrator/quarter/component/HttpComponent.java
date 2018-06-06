package com.example.administrator.quarter.Component;

import com.example.administrator.quarter.Module.HttpModule;
import com.example.administrator.quarter.ui.Recommend.GuanZhuFragment;
import com.example.administrator.quarter.ui.Recommend.RecommendFragment;
import com.example.administrator.quarter.ui.duanzi.DuanZiFragment;

import dagger.Component;


@Component(modules = HttpModule.class)
public interface HttpComponent {
   void inject(RecommendFragment recommendFragment);

   void inject(GuanZhuFragment guanZhuFragment);

   void inject(DuanZiFragment duanZiFragment);

}
