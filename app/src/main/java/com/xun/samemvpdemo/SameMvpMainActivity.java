package com.xun.samemvpdemo;

import android.os.Bundle;

import com.xun.samemvpdemo.base.BaseMvpActivity;
import com.xun.samemvpdemo.model.DropDownAudioBean;

public class SameMvpMainActivity extends BaseMvpActivity<MainPresenter> implements IMainView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_same_mvp_main);

    }

    @Override
    protected MainPresenter createPresenter() {
        return null;
    }

    @Override
    public void getDataSuccess(DropDownAudioBean model) {

    }

    @Override
    public void getDataFail(String msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
