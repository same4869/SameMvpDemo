package com.xun.samemvpdemo.base;

import android.os.Bundle;
import android.view.View;

import com.xun.samemvpdemo.IMainView;

/**
 * Created by xunwang on 17/3/16.
 */

public abstract class BaseMvpFragment<P extends BasePresenter> extends BaseFragment implements IMainView{
    protected P mvpPresenter;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mvpPresenter = createPresenter();
    }

    protected abstract P createPresenter();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
