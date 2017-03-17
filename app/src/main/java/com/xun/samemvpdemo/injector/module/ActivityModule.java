package com.xun.samemvpdemo.injector.module;

import android.content.Context;

import com.xun.samemvpdemo.base.BaseActivity;
import com.xun.samemvpdemo.injector.scope.ForActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xunwang on 17/3/17.
 */

@Module
public class ActivityModule {

    private BaseActivity mActivity;

    public ActivityModule(BaseActivity activity) {
        mActivity = activity;
    }

    @Provides
    BaseActivity provideActivity() {
        return mActivity;
    }

    @Provides
    @ForActivity
    Context providesContext() {
        return mActivity;
    }
}