package com.xun.samemvpdemo.base;

import android.os.Bundle;

/**
 * Created by xunwang on 17/2/24.
 */

public abstract class BaseMvpActivity<P extends BasePresenter> extends BaseActivity implements IBaseView {
    protected P mvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mvpPresenter = createPresenter();
        super.onCreate(savedInstanceState);
    }

    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }
    }

    public void showLoading() {
        showProgressDialog();
    }

    public void hideLoading() {
        dismissProgressDialog();
    }

}
