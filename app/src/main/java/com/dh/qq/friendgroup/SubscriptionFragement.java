package com.dh.qq.friendgroup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dh.qq.R;

public class SubscriptionFragement extends Fragment {

    private View inflate;
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate=inflater.inflate(R.layout.activity_main,null);
        initView();
        return inflate;
    }

    private void initView(){
        textView=inflate.findViewById(R.id.mainactivity);
        textView.setText("这里是订阅号");
    }
}
