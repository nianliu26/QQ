package com.dh.qq.friendgroup;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dh.qq.R;

import java.util.List;

public class FriendGroupAdpetar extends BaseExpandableListAdapter {

    private List<FriendGroupBase> friendGroupBaseList;
    private LayoutInflater layoutInflater;

    public FriendGroupAdpetar() {
    }

    public FriendGroupAdpetar(List<FriendGroupBase> friendGroupBaseList, Context context) {
        this.friendGroupBaseList = friendGroupBaseList;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return friendGroupBaseList==null?0:friendGroupBaseList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return friendGroupBaseList.get(groupPosition).getFriendInformations().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return friendGroupBaseList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return friendGroupBaseList.get(groupPosition).getFriendInformations().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolderGrouop viewHolderGrouop = null;
        if (convertView==null){
            viewHolderGrouop=new ViewHolderGrouop();

            convertView=layoutInflater.inflate(R.layout.item_friend_expend_listgroup,null);
            viewHolderGrouop.groupName=convertView.findViewById(R.id.friend_group_name);
            viewHolderGrouop.onlineParson=convertView.findViewById(R.id.friendgroup_online_person);

            convertView.setTag(viewHolderGrouop);
        }else {
            viewHolderGrouop=(ViewHolderGrouop)convertView.getTag();
        }
        FriendGroupBase friendGroupBase=friendGroupBaseList.get(groupPosition);
        viewHolderGrouop.groupName.setText(friendGroupBase.getGroupName());
        viewHolderGrouop.onlineParson.setText(friendGroupBase.getOnlineParson()+"/"+friendGroupBase.getTatolPerson());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolderChild viewHolderChild = null;
        if (convertView==null){
            viewHolderChild=new ViewHolderChild();
            convertView=layoutInflater.inflate(R.layout.item_friend_segment,null);

            viewHolderChild.imageView=convertView.findViewById(R.id.friend_friendhead);
            viewHolderChild.nickname=convertView.findViewById(R.id.friend_friendname);
            viewHolderChild.online=convertView.findViewById(R.id.friend_online);
            viewHolderChild.simple=convertView.findViewById(R.id.friend_count);

            convertView.setTag(viewHolderChild);
        }else {
            viewHolderChild=(ViewHolderChild)convertView.getTag();
        }
        FriendInformation friendInformation=friendGroupBaseList.get(groupPosition).getFriendInformations().get(childPosition);
        viewHolderChild.imageView.setImageResource(friendInformation.getHead());
        viewHolderChild.nickname.setText(friendInformation.getNickname());
        viewHolderChild.online.setText(friendInformation.getOnline());
        viewHolderChild.simple.setText(friendInformation.getCount());



        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private class ViewHolderGrouop{
        private TextView groupName;
        private TextView onlineParson;

    }

    private class ViewHolderChild{
        private ImageView imageView;
        private TextView nickname;
        private TextView online;
        private TextView simple;

    }
}
