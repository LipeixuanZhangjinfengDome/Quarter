package com.example.administrator.quarter.component;

import com.example.administrator.quarter.Module.HttpModule;
import com.example.administrator.quarter.ui.Recommend.RecommendFragment;

import dagger.Component;


@Component(modules = HttpModule.class)
public interface HttpComponent {
   void inject(RecommendFragment recommendFragment);

}
