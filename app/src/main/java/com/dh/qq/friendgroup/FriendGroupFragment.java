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
import java.util.regex.Pattern;

public class FriendGroupFragment extends Fragment {

    private ExpandableListView listView;
    private FriendGroupAdpetar friendGroupAdpetar;

    private View inflate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate=inflater.inflate(R.layout.fragment_friend_group,null);
        initView();


        return inflate;
    }

    private void initView(){
        listView=inflate.findViewById(R.id.friend_expand_group);
        friendGroupAdpetar=new FriendGroupAdpetar(getData(),getActivity());
        listView.setAdapter(friendGroupAdpetar);
    }

    private List<FriendGroupBase> getData(){
        List<FriendGroupBase> friendGroupBaseList = new ArrayList<>();

        //************************************group1***********************************************************
         FriendGroupBase tenCentBean=new FriendGroupBase();
         tenCentBean.setGroupName("2018级计算机科学与技术三班");

         List<FriendInformation> childList=new ArrayList<>();
         FriendInformation child=new FriendInformation();
         child.setHead(R.mipmap.qqimg);
         child.setNickname("邓辉");
         child.setOnline("[wifi在线]");
         child.setCount("这货没有签名");
         childList.add(child);

         child=new FriendInformation();
         child.setHead(R.mipmap.qqimg);
         child.setNickname("陈科宇");
         child.setOnline("[4G在线]");
         child.setCount(" ");
         childList.add(child);

         child=new FriendInformation();
         child.setHead(R.mipmap.qqimg);
         child.setNickname("谭秋涛");
         child.setOnline("[5G在线]");
         child.setCount("没有人能击垮你，除非你自甘懦弱");
         childList.add(child);

         tenCentBean.setFriendInformations(childList);


         tenCentBean.setOnlineParson(""+getOnlinePerson(tenCentBean.getFriendInformations()));
         tenCentBean.setTatolPerson(""+tenCentBean.getFriendInformations().size());
         friendGroupBaseList.add(tenCentBean);
         //******************************************group2****************************************************/
        tenCentBean=new FriendGroupBase();
        tenCentBean.setGroupName("家人");

        childList=new ArrayList<>();
        child=new FriendInformation();
        child.setHead(R.mipmap.user);
        child.setNickname("妈");
        child.setOnline("[wifi在线]");
        child.setCount("人生就是糊涂的，所有的快乐和幸福都藏在糊涂中，一旦清醒了所有的快乐和幸福也就跟着烟消云散了。");
        childList.add(child);

        child=new FriendInformation();
        child.setHead(R.mipmap.qqimg);
        child.setNickname("爸爸");
        child.setOnline("[离线请留言]");
        child.setCount("认认真真做事，踏踏实实做人。");
        childList.add(child);

        tenCentBean.setFriendInformations(childList);
        tenCentBean.setOnlineParson(""+getOnlinePerson(tenCentBean.getFriendInformations()));
        tenCentBean.setTatolPerson(""+tenCentBean.getFriendInformations().size());
        friendGroupBaseList.add(tenCentBean);

        return friendGroupBaseList;
    }

    private int getOnlinePerson(List<FriendInformation> list){
        int personSum=0;

        for(FriendInformation c:list){
            if(!isOnline(c)) personSum++;
        }
        if (personSum>list.size()) personSum=list.size();
        return personSum;
    }

    private boolean isOnline(FriendInformation child){
        String re=".{0,}离线.{0,}";
        return Pattern.matches(re,child.getOnline());
    }
}
