package com.xun.samemvpdemo.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;

import com.xun.samemvpdemo.comm.SDCardListener;

import java.io.File;

/**
 * Created by xunwang on 17/3/16.
 */

public class UnInstallServer extends Service {
    SDCardListener[] listenners;

    @SuppressLint("SdCardPath")
    @Override
    public void onCreate() {
        SDCardListener[] listenners = {
                new SDCardListener("/data/data/com.xun.samemvpdemo", this),
                new SDCardListener(Environment.getExternalStorageDirectory() + File.separator + "test.txt", this)};
        this.listenners = listenners;

        for (SDCardListener listener : listenners) {
            listener.startWatching();
        }
        Log.d("kkkkkkkk", "启动service");
        File file = new File(Environment.getExternalStorageDirectory() + File.separator + "test.txt");

        if (file.exists())
            file.delete();
    }

    @Override
    public void onDestroy() {
        for (SDCardListener listener : listenners) {
            listener.stopWatching();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}


