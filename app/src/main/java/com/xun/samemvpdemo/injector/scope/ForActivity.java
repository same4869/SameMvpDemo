package com.xun.samemvpdemo.injector.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by xunwang on 17/3/17.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ForActivity {
}
