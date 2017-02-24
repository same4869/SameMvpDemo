package com.xun.samemvpdemo;

import com.xun.samemvpdemo.base.IBaseView;
import com.xun.samemvpdemo.model.DropDownAudioBean;

/**
 * Created by xunwang on 17/2/24.
 */

public interface IMainView extends IBaseView {
    void getDataSuccess(DropDownAudioBean model);

    void getDataFail(String msg);
}
