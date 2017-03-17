package com.xun.samemvpdemo.injector.module;

import com.xun.samemvpdemo.model.UserBean;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xunwang on 17/3/17.
 */

@Module
//标识该类提供依赖
public class UserModule {
    @Singleton
    @Provides
        //告诉Dagger我们想要构造对象并提供这些依赖
    UserBean provideUser() {
        return new UserBean("周杰伦", 38);
    }
}
