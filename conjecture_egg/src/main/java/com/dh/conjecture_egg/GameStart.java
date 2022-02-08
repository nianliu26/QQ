package com.dh.conjecture_egg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class GameStart extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void gameStrat(View view){
        Intent intent=new Intent(this,GamePlay.class);
        startActivity(intent);
        finish();
    }
}
