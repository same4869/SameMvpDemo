package com.xun.samemvpdemo.setting;

import com.xun.samemvpdemo.app.SameMvpApplicationContext;

import commlib.xun.com.commlib.sharedsetting.CommSharedSettingOperator;

/**
 * Created by xunwang on 17/5/23.
 */

public class SharedSetting {
    private static final String TEST_OH = "test_oh";

    public static void setSavedPenAddress(String address) {
        CommSharedSettingOperator.save(SameMvpApplicationContext.application, TEST_OH, address, null);
    }

    public static String getSavedPenAddress() {
        return CommSharedSettingOperator.queryValue(SameMvpApplicationContext.application, TEST_OH);
    }
}
