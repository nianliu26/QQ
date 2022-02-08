package com.dh.qq;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.dh.qq.R;
import com.dh.qq.friendgroup.TheMainFragment;
import com.dh.qq.friendshare.FriendShareFragment;
import com.dh.qq.messagelist.MessageListFragment;
import com.dh.qq.news.NewsFragment;

public class MainScreenActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener{


    private RadioGroup radioGroup;

    private TheMainFragment theMainFragment;
    private MessageListFragment messageListFragment;
    private NewsFragment newsFragment;
    private FriendShareFragment friendShareFragment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        initView();
        initListener();
        setFragment();
    }

    private void initView(){
        radioGroup=findViewById(R.id.radiogroup1);
    }
    private void initFragment(){

        hideFragment(theMainFragment);
        hideFragment(messageListFragment);
        hideFragment(newsFragment);
        hideFragment(friendShareFragment);
    }

    private void setFragment(){
        theMainFragment=new TheMainFragment();
        messageListFragment=new MessageListFragment();
        newsFragment=new NewsFragment();
        friendShareFragment=new FriendShareFragment();

        addFragment(theMainFragment);
        addFragment(messageListFragment);
        addFragment(newsFragment);
        addFragment(friendShareFragment);

        hideFragment(theMainFragment);
        hideFragment(messageListFragment);
        hideFragment(newsFragment);
        hideFragment(friendShareFragment);

        showFragment(messageListFragment);
    }

    private void initListener(){
        radioGroup.setOnCheckedChangeListener(this);
    }

    //添加
    private void addFragment(Fragment fragment){
        if(fragment != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            //FragmentManager fragmentManager = getFragmentManager();
            androidx.fragment.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.screen_framelayout,fragment);
            fragmentTransaction.commit();
        }
    }

    //隐藏
    private void hideFragment(Fragment fragment){
        if(fragment != null){
            androidx.fragment.app.FragmentManager fragmentManager = getSupportFragmentManager();
            //FragmentManager fragmentManager = getFragmentManager();
            androidx.fragment.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.hide(fragment);
            fragmentTransaction.commit();
        }
    }


    private void showFragment(Fragment fragment){
        if(fragment != null){
            androidx.fragment.app.FragmentManager fragmentManager = getSupportFragmentManager();
            //FragmentManager fragmentManager = getFragmentManager();
            androidx.fragment.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.show(fragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.radiobutton_01:
                initFragment();
                showFragment(messageListFragment);
                break;
            case R.id.radiobutton_02:
                initFragment();
                showFragment(theMainFragment);
                break;
            case R.id.radiobutton_03:
                initFragment();
                showFragment(newsFragment);
                break;
            case R.id.radiobutton_04:
                initFragment();
                showFragment(friendShareFragment);
                break;
        }
    }
}
