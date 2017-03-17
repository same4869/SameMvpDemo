package com.xun.samemvpdemo.injector.component;

import com.xun.samemvpdemo.fragment.MusicFragment;
import com.xun.samemvpdemo.injector.module.ActivityModule;
import com.xun.samemvpdemo.injector.module.FragmentModule;
import com.xun.samemvpdemo.injector.scope.ActivityScope;

import dagger.Component;

/**
 * Created by xunwang on 17/3/17.
 */
@ActivityScope
@Component(modules = {ActivityModule.class, FragmentModule.class})
public interface FragmentComponent extends ActivityComponent{
    void inject(MusicFragment musicFragment);
}
