package com.xun.samemvpdemo.injector.module;

import android.content.Context;

import com.xun.samemvpdemo.base.BaseFragment;

import dagger.Module;
import dagger.Provides;


/**
 * Created by xunwang on 17/3/17.
 */

@Module
public class FragmentModule {

    private BaseFragment fragment;

    public FragmentModule(BaseFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    BaseFragment provideFragment() {
        return fragment;
    }

    @Provides
    Context provideContext() {
        return fragment.getContext();
    }
}
