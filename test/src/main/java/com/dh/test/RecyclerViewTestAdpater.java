package com.dh.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewTestAdpater extends RecyclerView.Adapter<RecyclerViewTestAdpater.RecyclerViewViewHolder> {

    private Context context;

    public RecyclerViewTestAdpater() {
    }

    public RecyclerViewTestAdpater(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewTestAdpater.RecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerViewViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recyclerview_test,null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewTestAdpater.RecyclerViewViewHolder holder, int position) {
        holder.textView.setText("hello world");
    }


    @Override
    public int getItemCount() {
        return 30;
    }

    class RecyclerViewViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;

        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.test_text);
        }
    }
}
