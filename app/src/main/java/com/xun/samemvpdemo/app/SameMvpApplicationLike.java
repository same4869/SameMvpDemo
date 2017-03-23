package com.xun.samemvpdemo.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.DefaultApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.xun.samemvpdemo.injector.component.ApplicationComponent;
import com.xun.samemvpdemo.injector.component.DaggerApplicationComponent;
import com.xun.samemvpdemo.injector.module.ApplicationModule;

/**
 * Created by xunwang on 17/3/21.
 */

@DefaultLifeCycle(application = "com.xun.samemvpdemo.app.SameMvpApplication",
        flags = ShareConstants.TINKER_ENABLE_ALL,
        loadVerifyFlag = false)
public class SameMvpApplicationLike extends DefaultApplicationLike {
    //    private static RefWatcher mRefWatcher;//leakCanary观察器
    private static ApplicationComponent mApplicationComponent;

    public SameMvpApplicationLike(Application application, int tinkerFlags, boolean tinkerLoadVerifyFlag, long
            applicationStartElapsedTime, long applicationStartMillisTime, Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime,
                applicationStartMillisTime, tinkerResultIntent);
    }

    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);

        SameMvpApplicationContext.application = (SameMvpApplication) getApplication();
        SameMvpApplicationContext.context = getApplication();

        TinkerInstaller.install(this);
        //在初始化的时候调用加载补丁的方法,路径是实际补丁放的位置
        TinkerInstaller.onReceiveUpgradePatch(this.getApplication(), Environment.getExternalStorageDirectory()
                .getAbsolutePath() + "/patch_signed_7zip.apk");

//        installLeakCanary();
        setupInjector();
    }

    private void setupInjector() {
        mApplicationComponent = DaggerApplicationComponent.builder().
                applicationModule(new ApplicationModule(SameMvpApplicationContext.application))
                .build();
    }

    /**
     * 安装leakCanary检测内存泄露
     */
//    protected void installLeakCanary() {
//        this.mRefWatcher = Constants.USE_CANARY ? LeakCanary.install(SameMvpApplicationContext.application) :
// RefWatcher.DISABLED;
//    }

    /**
     * 获得leakCanary观察器
     *
     * @param context
     * @return
     */
//    public static RefWatcher getRefWatcher(Context context) {
//        return mRefWatcher;
//    }
}
