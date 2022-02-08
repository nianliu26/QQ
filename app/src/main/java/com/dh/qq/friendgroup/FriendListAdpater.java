package com.dh.qq.friendgroup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dh.qq.R;
import com.dh.qq.messagelist.MessageAdpater;

import java.util.List;

public class FriendListAdpater extends BaseAdapter implements View.OnClickListener{

    private List<FriendInformation> friendInformations;
    private LayoutInflater inflater;

    public FriendListAdpater() {
    }

    public FriendListAdpater(List<FriendInformation> friendInformations, Context context) {
        this.friendInformations = friendInformations;
        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return friendInformations.size();
    }

    @Override
    public Object getItem(int position) {
        return friendInformations.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView=inflater.inflate(R.layout.item_friend_segment,null);
            viewHolder.head=convertView.findViewById(R.id.friend_friendhead);
            viewHolder.nickname=convertView.findViewById(R.id.friend_friendname);
            viewHolder.online=convertView.findViewById(R.id.friend_online);
            viewHolder.count=convertView.findViewById(R.id.friend_count);

            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder)convertView.getTag();
        }
        FriendInformation friendInformation=friendInformations.get(position);

        viewHolder.head.setImageResource(friendInformation.getHead());
        viewHolder.nickname.setText(friendInformation.getNickname());
        viewHolder.online.setText(friendInformation.getOnline());
        viewHolder.count.setText(friendInformation.getCount());



        return convertView;
    }


    private class ViewHolder{
        private ImageView head;
        private TextView nickname;
        private TextView online;
        private TextView count;
    }

    interface I{
        void item(View view);
    }

    private FriendListAdpater.I i;
    public void setI(FriendListAdpater.I i){
        this.i=i;
    }

    @Override
    public void onClick(View v) {
        i.item(v);
    }

}
