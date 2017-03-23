package com.xun.samemvpdemo.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.xun.samemvpdemo.R;
import com.xun.samemvpdemo.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by xunwang on 17/3/22.
 */

public class CommWebViewActivity extends BaseActivity {
    public static final String COMMON_WEB_URL = "common_web_url";
    public static final String COMMON_WEB_TITLE = "common_web_title";

    @BindView(R.id.common_webview)
    WebView commonWebView;

    private String url;

    @Override
    public int getLayoutId() {
        return R.layout.activity_comm_webview;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        url = intent.getStringExtra(COMMON_WEB_URL);

        commonWebView = (WebView) findViewById(R.id.common_webview);
        initSetting();

        MyWebChromeClient myWebChromeClient = new MyWebChromeClient();
        commonWebView.setWebChromeClient(myWebChromeClient);
        commonWebView.setWebViewClient(new MyWebViewClient());
        commonWebView.loadUrl(url);
    }

    @Override
    public void initData() {

    }

    private void initSetting() {
        WebSettings settings = commonWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        settings.setAppCacheEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setBuiltInZoomControls(false);
        settings.setSupportZoom(false);
        settings.setDomStorageEnabled(true);
        settings.setUseWideViewPort(true);
    }

    private class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (commonWebView.canGoBack()) {
            commonWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    class MyWebChromeClient extends WebChromeClient {
    }
}
