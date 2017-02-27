package com.xun.samemvpdemo;

import android.os.Bundle;
import android.widget.Toast;

import com.xun.samemvpdemo.base.BaseMvpActivity;
import com.xun.samemvpdemo.model.DropDownAudioBean;

public class SameMvpMainActivity extends BaseMvpActivity<MainPresenter> implements IMainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_same_mvp_main);
        mvpPresenter.loadDataByRetrofitRxjava();
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void getDataSuccess(DropDownAudioBean model) {
        if (model != null) {
            Toast.makeText(getApplicationContext(), model.getList().get(0).getAdoContent(), Toast.LENGTH_LONG).show();
        }
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
