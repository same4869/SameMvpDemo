package com.xun.samemvpdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xun.samemvpdemo.R;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by xunwang on 17/3/13.
 */

public class VideoFragment extends SupportFragment {

    public static VideoFragment newInstance() {
        Bundle args = new Bundle();
        VideoFragment fragment = new VideoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_video, null);
        return rootView;
    }
}
