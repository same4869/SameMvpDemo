package com.xun.samemvpdemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxView;
import com.xun.samemvpdemo.R;
import com.xun.samemvpdemo.base.BaseMvpFragment;
import com.xun.samemvpdemo.model.BaseBean;
import com.xun.samemvpdemo.model.DropDownAudioBean;
import com.xun.samemvpdemo.presenter.MainPresenter;
import com.xun.samemvpdemo.setting.SharedSetting;
import com.xun.samemvpdemo.ui.CommWebViewActivity;

import javax.inject.Inject;

import butterknife.BindView;
import rx.functions.Action1;

import static com.xun.samemvpdemo.ui.CommWebViewActivity.COMMON_WEB_URL;

/**
 * Created by xunwang on 17/3/13.
 */

public class MusicFragment extends BaseMvpFragment {

    @BindView(R.id.test_btn)
    Button testBtn;
    @BindView(R.id.test_tv)
    TextView testTv;
    @BindView(R.id.open_web)
    Button openWeb;
    @BindView(R.id.test_share_setting)
    Button testShareSetting;
    @BindView(R.id.test_share_setting2)
    Button testShareSetting2;
    @Inject
    MainPresenter mainPresenter;

    public static MusicFragment newInstance() {
        Bundle args = new Bundle();
        MusicFragment fragment = new MusicFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_music, null);
        mainPresenter.attachView(this);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RxView.clicks(testBtn).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                Log.d("kkkkkkkk", "testBtn click");
                mainPresenter.loadDataByRetrofitRxjava();
            }
        });
        RxView.clicks(openWeb).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                String url = "http://xwang.space/";
                Intent intent = new Intent(getActivity(), CommWebViewActivity.class);
                intent.putExtra(COMMON_WEB_URL, url);
                startActivity(intent);
            }
        });
        RxView.clicks(testShareSetting).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                SharedSetting.setSavedPenAddress("我来自SameMvpDemo");
            }
        });
        RxView.clicks(testShareSetting2).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                testTv.setText(SharedSetting.getSavedPenAddress());
            }
        });
    }

    @Override
    public void getDataSuccess(BaseBean model) {
        if (model != null) {
            DropDownAudioBean dropDownAudioBean = (DropDownAudioBean) model;
            Toast.makeText(getActivity(), dropDownAudioBean.getList().get(0).getAdoContent(), Toast.LENGTH_SHORT)
                    .show();
        }
    }

    @Override
    public void getDataFail(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mainPresenter.detachView();
    }
}
