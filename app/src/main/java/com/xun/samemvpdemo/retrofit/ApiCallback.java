package com.xun.samemvpdemo.retrofit;

import rx.Subscriber;

/**
 * Created by xunwang on 17/2/24.
 */

public abstract class ApiCallback<M> extends Subscriber<M> {

    public abstract void onSuccess(M model);

    public abstract void onFailure(String msg);

    public abstract void onFinish();


    @Override
    public void onError(Throwable e) {
        onFailure(e.getMessage());
        onFinish();
    }

    @Override
    public void onNext(M model) {
        onSuccess(model);
        onFinish();
    }
}
