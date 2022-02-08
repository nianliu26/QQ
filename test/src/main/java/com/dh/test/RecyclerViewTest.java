package com.dh.test;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewTest extends Activity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_recyclerview);
        recyclerView=findViewById(R.id.test_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(RecyclerViewTest.this,RecyclerView.HORIZONTAL,false));
        recyclerView.setAdapter(new RecyclerViewTestAdpater(RecyclerViewTest.this));
    }
}
