package com.example.administrator.quarter.net;

import com.example.administrator.quarter.bean.JokesBean;

import io.reactivex.Observable;

public class JokesApi {
    private static JokesApi jokesApi;
    private JokesApiService jokesApiService;

    public JokesApi(JokesApiService jokesApiService) {
        this.jokesApiService = jokesApiService;
    }
    public static JokesApi getJokes(JokesApiService jokesApiService){
        if (jokesApi==null){
            jokesApi=new JokesApi(jokesApiService);
        }
        return jokesApi;
    }
    public Observable<JokesBean> getJokes(){
        return jokesApiService.getJokes();
    }
}
