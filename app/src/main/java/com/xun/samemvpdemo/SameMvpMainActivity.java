package com.xun.samemvpdemo;

import android.support.annotation.IdRes;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.xun.samemvpdemo.base.BaseMvpActivity;
import com.xun.samemvpdemo.fragment.MusicFragment;
import com.xun.samemvpdemo.fragment.NewsFragment;
import com.xun.samemvpdemo.fragment.VideoFragment;
import com.xun.samemvpdemo.model.DropDownAudioBean;

import java.util.ArrayList;
import java.util.List;

import me.yokeyword.fragmentation.SupportFragment;

public class SameMvpMainActivity extends BaseMvpActivity<MainPresenter> implements IMainView {
    private List<SupportFragment> fragments = new ArrayList<>();
    private BottomBar bottomBar;

    @Override
    protected void initView() {
        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
    }

    @Override
    protected void initData() {
        fragments.add(MusicFragment.newInstance());
        fragments.add(NewsFragment.newInstance());
        fragments.add(VideoFragment.newInstance());
        loadMultipleRootFragment(R.id.contentContainer, 0
                , fragments.get(0)
                , fragments.get(1)
                , fragments.get(2)
        );
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_favorites) {
                    showHideFragment(fragments.get(0));
                } else if (tabId == R.id.tab_nearby) {
                    showHideFragment(fragments.get(1));
                } else if (tabId == R.id.tab_friends) {
                    showHideFragment(fragments.get(2));
                }
            }
        });
        mvpPresenter.loadDataByRetrofitRxjava();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_same_mvp_main;
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void getDataSuccess(DropDownAudioBean model) {
        if (model != null) {
            Toast.makeText(getApplicationContext(), model.getList().get(0).getAdoContent(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void getDataFail(String msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
