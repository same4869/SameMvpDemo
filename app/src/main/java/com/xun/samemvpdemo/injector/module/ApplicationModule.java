package com.xun.samemvpdemo.injector.module;

import android.content.Context;

import com.xun.samemvpdemo.app.SameMvpApplication;
import com.xun.samemvpdemo.injector.scope.ForApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 小鹿 on 2017/2/4.
 */
@Module
public class ApplicationModule {
    private SameMvpApplication mApplication;

    public ApplicationModule(SameMvpApplication application) {
        this.mApplication = application;
    }

    @Provides
    @Singleton
    public SameMvpApplication provideApplication() {
        return mApplication;
    }

    @Provides
    @ForApplication
    Context provideContext() {
        return mApplication;
    }
}
