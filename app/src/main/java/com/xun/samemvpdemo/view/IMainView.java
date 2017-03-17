package com.xun.samemvpdemo.view;

import com.xun.samemvpdemo.base.IBaseView;
import com.xun.samemvpdemo.model.BaseBean;

/**
 * Created by xunwang on 17/2/24.
 */

public interface IMainView extends IBaseView {
    void getDataSuccess(BaseBean model);

    void getDataFail(String msg);
}
