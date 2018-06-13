package com.example.administrator.quarter.ui.Recommend.Presenter;

import com.example.administrator.quarter.bean.AdBean;
import com.example.administrator.quarter.bean.BaseBean;
import com.example.administrator.quarter.bean.JokesBean;
import com.example.administrator.quarter.net.AdApi;
import com.example.administrator.quarter.net.AddfavoriteApi;
import com.example.administrator.quarter.net.JokesApi;
import com.example.administrator.quarter.ui.Recommend.contract.GetAdContract;
import com.example.administrator.quarter.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class GetAdPresenter extends BasePresenter<GetAdContract.View> implements GetAdContract.Presenter {
    private AdApi adApi;
    private JokesApi jokesApi;
    private AddfavoriteApi addfavoriteApi;
    @Inject
    public GetAdPresenter(AdApi adApi, JokesApi jokesApi,AddfavoriteApi addfavoriteApi) {
        this.adApi = adApi;
        this.jokesApi = jokesApi;
        this.addfavoriteApi=addfavoriteApi;
    }




    @Override
    public void getAd() {
        adApi.getAd()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<AdBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AdBean adBean) {
                        if (mView!=null){
                            mView.onSuccess(adBean);
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void getJokes() {
        jokesApi.getJokes()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<JokesBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JokesBean jokesBean) {
                        if (mView!=null){
                            mView.onJokesSuccess(jokesBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void addCart(String uid, String wid, String token) {
        addfavoriteApi.getAddFavorite(uid,wid,token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Function<BaseBean, String>() {
                    @Override
                    public String apply(BaseBean baseBean) throws Exception {
                        return baseBean.getMsg();
                    }
                }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                if (mView != null) {
                    mView.onaddSuccess(s);
                }
            }
        });
    }
}
