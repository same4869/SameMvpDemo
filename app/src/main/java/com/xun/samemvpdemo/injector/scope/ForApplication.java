package com.xun.samemvpdemo.injector.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by 小鹿 on 2017/2/6.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ForApplication {
}
