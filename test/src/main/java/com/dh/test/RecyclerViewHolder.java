package com.dh.test;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        textView=itemView.findViewById(R.id.test_text);
    }
}
