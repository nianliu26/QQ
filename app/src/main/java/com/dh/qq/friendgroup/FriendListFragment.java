package com.dh.qq.friendgroup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dh.qq.R;

import java.util.ArrayList;
import java.util.List;

public class FriendListFragment extends Fragment {

    private ListView listView;
    private FriendListAdpater friendListAdpater;

    private View inflate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate=inflater.inflate(R.layout.fregment_friend_list,null);
        initView();

        return inflate;
    }

    private void initView(){
        listView=inflate.findViewById(R.id.frien_friendlist);
        friendListAdpater=new FriendListAdpater(getInformations(),getActivity());
        listView.setAdapter(friendListAdpater);
    }

    private List<FriendInformation> getInformations(){
        List<FriendInformation> friendInformations=new ArrayList<>();

        FriendInformation information=new FriendInformation();
        information.setHead(R.mipmap.qqimg);
        information.setNickname("张三");
        information.setOnline("WIFI在线");
        information.setCount("这货没有签名");

        friendInformations.add(information);

        return friendInformations;
    }


}
