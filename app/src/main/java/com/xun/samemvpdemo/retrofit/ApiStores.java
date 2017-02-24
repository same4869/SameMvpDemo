package com.xun.samemvpdemo.retrofit;


import com.xun.samemvpdemo.model.DropDownAudioBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by xunwang on 17/2/24.
 */

public interface ApiStores {
    //baseUrl
    String API_SERVER_URL = "";

    //加载天气
    @GET("http://appapi.tingtoutiao.com/myAppPro/audio/getDropDownAudio.do?cId=0")
    Observable<DropDownAudioBean> loadDataByRetrofitRxjava();
}
