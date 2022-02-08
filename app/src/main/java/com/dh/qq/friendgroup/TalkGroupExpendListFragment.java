package com.dh.qq.friendgroup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dh.qq.R;

import java.util.ArrayList;
import java.util.List;

public class TalkGroupExpendListFragment extends Fragment {


    private View inflate;
    private ExpandableListView expandableListView;
    private TalkGroupExpendListAdpater talkGroupExpendListAdpater;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate=inflater.inflate(R.layout.fragment_friend_talkgroup_expend_list,null);
        initVIew();


        return inflate;
    }

    private void initVIew(){
        expandableListView=inflate.findViewById(R.id.friend_talkgroup_expend_list);
        talkGroupExpendListAdpater=new TalkGroupExpendListAdpater(getData(),getActivity());
        expandableListView.setAdapter(talkGroupExpendListAdpater);
    }

    private List<FriendGroupBase> getData(){
        List<FriendGroupBase> list=new ArrayList<>();
        FriendGroupBase friendGroupBase=new FriendGroupBase();


        friendGroupBase.setGroupName("未命名的群聊");
        friendGroupBase.setOnlineParson("");
        friendGroupBase.setTatolPerson("0");
        List<FriendInformation> friendInformations=new ArrayList<>();
        list.add(friendGroupBase);

        friendGroupBase=new FriendGroupBase();


        friendGroupBase.setGroupName("我加入的群聊");
        friendGroupBase.setOnlineParson("");
        friendGroupBase.setTatolPerson("2");

        friendInformations=new ArrayList<>();
        FriendInformation friendInformation=new FriendInformation();
        friendInformation.setHead(R.mipmap.qqimg);
        friendInformation.setNickname("群一");
        friendInformation.setCount("");
        friendInformation.setOnline("");
        friendInformations.add(friendInformation);

        friendInformation=new FriendInformation();
        friendInformation.setHead(R.mipmap.qqimg);
        friendInformation.setNickname("群二");
        friendInformation.setCount("");
        friendInformation.setOnline("");
        friendInformations.add(friendInformation);
        friendGroupBase.setFriendInformations(friendInformations);

        list.add(friendGroupBase);

        friendGroupBase=new FriendGroupBase();


        friendGroupBase.setGroupName("我管理的的群聊");
        friendGroupBase.setOnlineParson("");
        friendGroupBase.setTatolPerson("0");
        friendInformations=new ArrayList<>();
        list.add(friendGroupBase);


        return list;

    }
}
