package com.dh.qq.messagelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dh.qq.R;

import java.util.List;

public class MessageAdpater  extends BaseAdapter implements View.OnClickListener{

    private List<MessageBase> messageBaseList;
    private LayoutInflater inflater;

    public MessageAdpater() {
    }

    public MessageAdpater(List<MessageBase> messageBaseList, Context context) {
        this.messageBaseList = messageBaseList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return messageBaseList==null?0:messageBaseList.size();
    }

    @Override
    public Object getItem(int position) {
        return messageBaseList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if(convertView == null){
            //当前视图为空时，创建视图
            viewHolder=new ViewHolder();
            //加载布局的方法
            convertView=inflater.inflate(R.layout.item_message_segment,null);
            //初始化控件，使用id将转化过来的view对象内的子控件放到viewHolder对象中保存起来
            viewHolder.imageView=convertView.findViewById(R.id.message_friendhead);
            viewHolder.name=convertView.findViewById(R.id.message_friendname);
            viewHolder.simpleText=convertView.findViewById(R.id.message_simple);
            viewHolder.mesTime=convertView.findViewById(R.id.message_time);
            viewHolder.mesSum=convertView.findViewById(R.id.message_sum);
            //设置内容
            convertView.setTag(viewHolder);//通过setTag()方法获取viewHolder中存放的id对应的布局，并用其将convertView原来的值覆盖
        }
        else{
            viewHolder=(ViewHolder)convertView.getTag();
        }

        //获取应该显示的内容，到控件对应的位置
        MessageBase myBean = messageBaseList.get(position);
        //通过列表中的MyBean类型中的值设置viewHolder的内容，以达到id复用的目的
        viewHolder.imageView.setImageResource(myBean.getFriendHead());
        viewHolder.name.setText(myBean.getFriendNickname());
        viewHolder.simpleText.setText(myBean.getFriendSimple());
        viewHolder.mesTime.setText(myBean.getMessageTime());
        viewHolder.mesSum.setText(myBean.getMessageSum());

        //设置监听器
        viewHolder.imageView.setOnClickListener(this);
        //viewHolder.imageView.setTag(position);

        return convertView;
    }


    public class ViewHolder{
        ImageView imageView;
        TextView name;
        TextView simpleText;
        TextView mesTime;
        TextView mesSum;
    }

    interface I{
        void item(View view);
    }

    private I i;
    public void setI(I i){
        this.i=i;
    }
    @Override
    public void onClick(View v) {
        i.item(v);
    }

}
