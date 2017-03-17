package com.xun.samemvpdemo.fragment;

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

import javax.inject.Inject;

import butterknife.BindView;
import rx.functions.Action1;

/**
 * Created by xunwang on 17/3/13.
 */

public class MusicFragment extends BaseMvpFragment {

    @BindView(R.id.test_btn)
    Button testBtn;
    @BindView(R.id.test_tv)
    TextView testTv;
    //    @Inject
//    UserBean user1;
//    @Inject
//    UserBean user2;
//    UserComponent userComponent;
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
        //完成对User的注入
//        userComponent = DaggerUserComponent.builder().build();
//        userComponent.inject(this);
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
                //根据注入的User对象设置TextView
//                testTv.setText(user1.getName() + ":" + user1.getAge() + ":" + user1.toString() + "\n" + user2.getName
//                        () + ":" + user2.getAge() + ":" + user2.toString());
            }
        });
    }

//    @Override
//    protected BasePresenter createPresenter() {
//        return new MainPresenter(this);
//    }

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

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mainPresenter.detachView();
    }
}
