package com.example.administrator.quarter.net;

import com.example.administrator.quarter.bean.AdBean;
import com.example.administrator.quarter.bean.DuanZiBean;

import io.reactivex.Observable;

public class DuanZiApi {
    private static DuanZiApi duanZiApi;
    private DuanZiApiService duanZiApiService;

    public DuanZiApi(DuanZiApiService duanZiApiService) {
        this.duanZiApiService = duanZiApiService;
    }
    public static DuanZiApi getDuanZiApi(DuanZiApiService duanZiApiService){
        if (duanZiApi==null){
            duanZiApi=new DuanZiApi(duanZiApiService);
        }
        return duanZiApi;
    }
    public Observable<DuanZiBean> getDuanzi(){
        return duanZiApiService.getDuanZi();
    }
}
