package com.xun.samemvpdemo.injector.component;

import com.xun.samemvpdemo.injector.module.ActivityModule;
import com.xun.samemvpdemo.injector.scope.ActivityScope;
import com.xun.samemvpdemo.ui.SameMvpMainActivity;

import dagger.Component;

/**
 * Created by xunwang on 17/3/17.
 */
@ActivityScope
@Component(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(SameMvpMainActivity sameMvpMainActivity);
}
