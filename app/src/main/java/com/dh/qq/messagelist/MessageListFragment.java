package com.dh.qq.messagelist;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dh.qq.R;

import java.util.ArrayList;
import java.util.List;

public class MessageListFragment extends Fragment implements AdapterView.OnItemClickListener,
        AdapterView.OnItemLongClickListener,MessageAdpater.I {

    private ImageView userTopHead;
    private TextView userTopNickname;
    private TextView userTopOnline;

    private ListView listView;
    private MessageAdpater messageAdpater;

    private View inflate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate=inflater.inflate(R.layout.fragment_message,null);
        initView();
        initMessageAdpater();
        initListener();


        return inflate;
    }

    private void initView(){
        userTopHead=inflate.findViewById(R.id.uers_head_message);
        userTopNickname=inflate.findViewById(R.id.user_nickname);
        userTopOnline=inflate.findViewById(R.id.user_online);
        listView=inflate.findViewById(R.id.message_list);

        userTopHead.setImageResource(R.mipmap.qqimg);
        userTopNickname.setText("廿六");
        userTopOnline.setText("手机在线-4G >");
    }

    private void initMessageAdpater(){
        this.messageAdpater=new MessageAdpater(getData(),getActivity());
        listView.setAdapter(messageAdpater);
    }

    private List<MessageBase> getData(){
        List<MessageBase> messageBaseList = new ArrayList<>();
        
        MessageBase messageBase = new MessageBase();
        messageBase.setFriendHead(R.mipmap.qqimg);
        messageBase.setFriendNickname("张三");
        messageBase.setFriendSimple("Hello");
        messageBase.setMessageTime("15:40");
        messageBase.setMessageSum("99+");

        messageBaseList.add(messageBase);

        return messageBaseList;
    }

    private void initListener(){
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
        messageAdpater.setI(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return true;
    }

    @Override
    public void item(View v) {
        int a;
        a=(int)v.getId();
        switch (a){/*
            case R.id.user_icon:
                Log.e("aaa","你点击了头像");
                setImg(v);
                startActivity(intent);
                break;
            case R.id.user_name:
                Log.e("bbb","你点击了昵称");
                break;
            case R.id.user_online:
                Log.e("ccc","你点击了在线状态");
                break;
            case R.id.user_content:
                Log.e("ddd","你点击了签名");
                break;*/
        }
    }
}
