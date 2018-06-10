package com.example.administrator.quarter.net;

import com.example.administrator.quarter.bean.RegBean;
import com.example.administrator.quarter.bean.UpdatePassBean;
import com.example.administrator.quarter.bean.UserBean;

import io.reactivex.Observable;

public class ProjectApi {
    private static ProjectApi projectApi;
    private ProjectApiService projectApiService;
    private ProjectApi(ProjectApiService projectApiService) {
        this.projectApiService=projectApiService;
    }

    public static ProjectApi getProjectApi(ProjectApiService projectApiService){
        if (projectApi==null){
            projectApi=new ProjectApi(projectApiService);
        }
        return projectApi;
    }
    public Observable<UserBean> login(String mobile, String password){
        return projectApiService.login(mobile,password);
    }

    public Observable<RegBean> reg(String mobile, String password) {
        return projectApiService.reg(mobile, password);
    }

    public Observable<UpdatePassBean> getPass(String mobile, String newPass){
        return projectApiService.getPass(mobile, newPass);
    }

}
