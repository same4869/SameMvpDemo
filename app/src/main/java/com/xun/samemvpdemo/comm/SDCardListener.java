package com.xun.samemvpdemo.comm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.FileObserver;
import android.util.Log;

import org.json.JSONObject;

/**
 * Created by xunwang on 17/3/16.
 */

public class SDCardListener extends FileObserver {
    private String path;
    private final Context mContext;
    private String url = "http://www.baidu.com";


    public SDCardListener(String parentpath, Context context) {
        super(parentpath);
        this.path = parentpath;
        this.mContext = context;
    }

    @Override
    public void onEvent(int event, String path) {
        int action = event & FileObserver.ALL_EVENTS;
        switch (action) {

            case FileObserver.DELETE:
                doPost();
                Log.d("kkkkkkkk", "用户卸载！！！");
                break;

        }
    }

    //应用卸载后打开一个网页的方法
    protected void openBrowser() {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }

    /**
     * 通过get方式提交,请求后台
     */
    public void doPost() {

        //获得用户的信息
        try {
            SharedPreferences sharedPreferences = mContext.getSharedPreferences("loginUser",
                    Activity.MODE_PRIVATE);
            String userData = sharedPreferences.getString("loginJson", "");
            Log.e("userData:", userData);
            if (!userData.equals("")) {
                JSONObject jsonObject = new JSONObject(userData);
                String user_id = jsonObject.getString("user_id");
                String httpurl = url + "?" + "user_id=" + user_id;
            } else {
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
