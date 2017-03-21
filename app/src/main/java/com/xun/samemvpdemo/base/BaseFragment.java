package com.xun.samemvpdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.squareup.leakcanary.RefWatcher;
import com.xun.samemvpdemo.app.SameMvpApplicationLike;
import com.xun.samemvpdemo.injector.component.DaggerFragmentComponent;
import com.xun.samemvpdemo.injector.component.FragmentComponent;
import com.xun.samemvpdemo.injector.module.ActivityModule;
import com.xun.samemvpdemo.injector.module.FragmentModule;

import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by xunwang on 17/3/16.
 */

public class BaseFragment extends SupportFragment {
    protected View rootView;
    private FragmentComponent fragmentComponent;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = SameMvpApplicationLike.getRefWatcher(getActivity());
        refWatcher.watch(this);
    }

    public FragmentComponent getFragmentComponent() {
        if (fragmentComponent == null) {
            fragmentComponent = DaggerFragmentComponent.builder()
                    //.applicationComponent(App.getApplicationComponent())
                    .activityModule(new ActivityModule((BaseActivity) getActivity()))
                    .fragmentModule(new FragmentModule(this))
                    .build();
        }

        return fragmentComponent;
    }
}
