package com.xun.samemvpdemo.injector.component;

import com.xun.samemvpdemo.app.SameMvpApplication;
import com.xun.samemvpdemo.injector.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by 小鹿 on 2017/2/4.
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    SameMvpApplication application();
}
