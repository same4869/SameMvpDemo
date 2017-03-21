package com.xun.samemvpdemo.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.leakcanary.RefWatcher;
import com.xun.samemvpdemo.app.SameMvpApplicationLike;
import com.xun.samemvpdemo.injector.component.ActivityComponent;
import com.xun.samemvpdemo.injector.component.DaggerActivityComponent;
import com.xun.samemvpdemo.injector.module.ActivityModule;

import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by xunwang on 17/2/24.
 */

public abstract class BaseActivity extends SupportActivity {
    public Activity mActivity;
    public ProgressDialog progressDialog;
    private ActivityComponent mActivityComponent;

    protected abstract void initView();

    protected abstract void initData();

    protected abstract int getLayoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        RefWatcher refWatcher = SameMvpApplicationLike.getRefWatcher(this);
        refWatcher.watch(this);
        ButterKnife.bind(this);
        mActivity = this;
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        mActivity = this;
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        mActivity = this;
    }

    public ProgressDialog showProgressDialog() {
        progressDialog = new ProgressDialog(mActivity);
        progressDialog.setMessage("加载中");
        progressDialog.show();
        return progressDialog;
    }

    public void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    public ActivityComponent getActivityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
//                    .applicationComponent(App.getApplicationComponent())
                    .activityModule(new ActivityModule(this))
                    .build();
        }
        return mActivityComponent;
    }
}
