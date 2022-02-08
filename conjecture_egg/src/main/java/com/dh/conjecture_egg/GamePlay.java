package com.dh.conjecture_egg;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class GamePlay extends Activity {
    private ImageView one,two,three;
    private Button over;
    private int egg,c;
    private AlertDialog dialog;
    private AlertDialog.Builder builder;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_play);
        initView();
    }


    private void initView(){
        one=findViewById(R.id.shoe_one);
        two=findViewById(R.id.shoe_two);
        three=findViewById(R.id.shoe_three);
        over=findViewById(R.id.over);

        egg=getRandomNum(0,3);

        builder=new AlertDialog.Builder(this)    //创建一个对话框对象，将它与当前activity窗口绑定
                .setIcon(R.mipmap.ic_launcher) //设置图标
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent intent=new Intent(GamePlay.this,GameStart.class);
                        startActivity(intent);
                        finish();
                    }
                }) //添加确定按钮
        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                over.setVisibility(View.VISIBLE);
            }
        }); //添加取消按钮
    }

    public void chose(View v){
        showEgg();
        switch (v.getId()){
            case R.id.shoe_one:
                c=0;
                break;
            case R.id.shoe_two:
                c=1;
                break;
            case R.id.shoe_three:
                c=2;
                break;
        }

        if (egg==c){
            builder.setMessage("答对了，是否再玩一次");
        }else{
            builder.setMessage("答错了，再试一次吧");
        }
        dialog=builder.create();
        dialog.show();
    }

    private void showEgg(){
        one.setImageResource(R.mipmap.shoewithoutegg);
        two.setImageResource(R.mipmap.shoewithoutegg);
        three.setImageResource(R.mipmap.shoewithoutegg);
        switch (egg){
            case 0:
                one.setImageResource(R.mipmap.shoewithegg);
                break;
            case 1:
                two.setImageResource(R.mipmap.shoewithegg);
                break;
            case 2:
                three.setImageResource(R.mipmap.shoewithegg);
                break;
        }
    }

    public void over(View v){
        finish();
    }

    /**
     * 生成随机整数（包含起始与终止范围）
     *
     * @author pan_junbiao
     * @param num1 起始范围参数
     * @param num2 终止范围参数
     * @return 随机整数
     */
    public static int getRandomNum(int num1, int num2)
    {
        int result = (int) (num1 + Math.random() * (num2 - num1 + 1));
        return result;
    }

}
