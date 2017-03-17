package com.xun.samemvpdemo.app;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.xun.samemvpdemo.config.Constants;

/**
 * Created by xunwang on 17/3/17.
 */

public class SameMvpApplication extends Application{
    private RefWatcher mRefWatcher;//leakCanary观察器

    @Override
    public void onCreate() {
        super.onCreate();
        installLeakCanary();
    }

    /**
     * 安装leakCanary检测内存泄露
     */
    protected void installLeakCanary() {
        this.mRefWatcher = Constants.USE_CANARY ? LeakCanary.install(this) : RefWatcher.DISABLED;
    }

    /**
     * 获得leakCanary观察器
     *
     * @param context
     * @return
     */
    public static RefWatcher getRefWatcher(Context context) {
        SameMvpApplication application = (SameMvpApplication) context.getApplicationContext();
        return application.mRefWatcher;
    }
}
