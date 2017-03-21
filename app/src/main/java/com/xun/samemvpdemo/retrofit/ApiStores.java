package com.xun.samemvpdemo.retrofit;


import com.xun.samemvpdemo.model.DropDownAudioBean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by xunwang on 17/2/24.
 */

public interface ApiStores {
    //baseUrl
    String API_SERVER_URL = "http://appapi.tingtoutiao.com/myAppPro/";

    @GET("audio/getDropDownAudio.do?cId=0")
    Observable<DropDownAudioBean> loadDataByRetrofitRxjava();
}
