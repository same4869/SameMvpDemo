package com.xun.samemvpdemo.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by xunwang on 17/2/24.
 */

public class BaseActivity extends AppCompatActivity{
    public Activity mActivity;
    public ProgressDialog progressDialog;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        mActivity = this;
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
            // progressDialog.hide();会导致android.view.WindowLeaked
            progressDialog.dismiss();
        }
    }
}
