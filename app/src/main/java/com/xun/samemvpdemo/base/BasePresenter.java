package com.xun.samemvpdemo.base;

import com.xun.samemvpdemo.model.DropDownAudioBean;
import com.xun.samemvpdemo.retrofit.ApiStores;
import com.xun.samemvpdemo.retrofit.AppClient;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by xunwang on 17/2/24.
 */

public class BasePresenter<V> {
    public V mvpView;
    protected ApiStores apiStores;
    private CompositeDisposable mCompositeSubscription;

    public void attachView(V mvpView) {
        this.mvpView = mvpView;
        apiStores = AppClient.retrofit().create(ApiStores.class);
    }


    public void detachView() {
        this.mvpView = null;
        onUnsubscribe();
    }


    //RXjava取消注册，以避免内存泄露
    public void onUnsubscribe() {
        if (mCompositeSubscription != null && !mCompositeSubscription.isDisposed()) {
            mCompositeSubscription.clear();
        }
    }


    public void addSubscription(Observable<DropDownAudioBean> observable, DisposableObserver disposableObserver) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeDisposable();
        }
        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(disposableObserver));
    }
}
