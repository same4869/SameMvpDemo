package com.xun.samemvpdemo.presenter;

import com.xun.samemvpdemo.view.IMainView;
import com.xun.samemvpdemo.base.BasePresenter;
import com.xun.samemvpdemo.model.DropDownAudioBean;
import com.xun.samemvpdemo.retrofit.ApiCallback;

import javax.inject.Inject;

/**
 * Created by xunwang on 17/2/24.
 */

public class MainPresenter extends BasePresenter<IMainView>{
    @Inject
    public MainPresenter() {
    }

    public void loadDataByRetrofitRxjava() {
        mvpView.showLoading();
        addSubscription(apiStores.loadDataByRetrofitRxjava(),
                new ApiCallback<DropDownAudioBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onSuccess(DropDownAudioBean model) {
                        mvpView.getDataSuccess(model);
                        mvpView.hideLoading();
                    }

                    @Override
                    public void onFailure(String msg) {
                        mvpView.getDataFail(msg);
                        mvpView.hideLoading();
                    }

                    @Override
                    public void onFinish() {

                    }

                });
    }
}
