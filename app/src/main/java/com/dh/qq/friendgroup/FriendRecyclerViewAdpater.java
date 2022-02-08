package com.dh.qq.friendgroup;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dh.qq.R;

import java.util.ArrayList;
import java.util.List;

public class FriendRecyclerViewAdpater extends RecyclerView.Adapter<FriendRecyclerViewAdpater.FriendRecyclerViewHolder> {

    private Context context;
    private List<String> stringList;
    private List<Boolean> isCheck;

    //自定义点击事件和长按事件
    private FriendRecyclerViewAdpater.OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(FriendRecyclerViewAdpater.OnItemClickListener mOnItemClickListener)
    {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public FriendRecyclerViewAdpater(Context context,List<String> list) {
        this.context = context;
        this.stringList=list;
        isCheck=new ArrayList<>();
        for(int i = 0;i<list.size();i++){
            isCheck.add(false);
        }
        isCheck.set(1,true);
    }

    public void setIsCheck(int position){
        for(int i = 0;i<isCheck.size();i++){
            isCheck.set(i,false);
        }
        isCheck.set(position,true);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public FriendRecyclerViewAdpater.FriendRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root=LayoutInflater.from(context).inflate(R.layout.item_friend_chose_button_view,null);
        FriendRecyclerViewHolder friendRecyclerViewHolder=new FriendRecyclerViewHolder(root);

        return friendRecyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FriendRecyclerViewAdpater.FriendRecyclerViewHolder holder, int position) {
        holder.textView.setText(stringList.get(position).toString());
        setClickListener(holder,position);

        holder.itemView.setTag(holder.textView);

        if (isCheck.get(position)){
            holder.textView.setTextColor(Color.parseColor("#FFFFFF"));
            holder.textView.setBackgroundResource(R.drawable.shape_text_to_button_uncheck_theme);
        }else {
            holder.textView.setTextColor(Color.parseColor("#000000"));
            holder.textView.setBackgroundResource(R.color.white);
        }
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }



    class FriendRecyclerViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public FriendRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.friend_list_group_name);
        }
    }

    //设置点击事件
    private void setClickListener(final FriendRecyclerViewHolder holder, int position) {
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getLayoutPosition();
                    setIsCheck(pos);
                    mOnItemClickListener.onItemClick(holder.itemView,pos);
                }
            });
        }
    }
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
        //void onItemLongClick(View view , int position);
    }

}
