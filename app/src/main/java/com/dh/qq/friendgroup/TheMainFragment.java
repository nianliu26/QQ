package com.dh.qq.friendgroup;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.dh.qq.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class TheMainFragment extends Fragment implements ViewPager.OnPageChangeListener  {

    private View inflate;

    private RadioGroup radioGroup;
    private LinearLayoutManager linearLayoutManager;
    private ViewPager viewPager;
    private RecyclerView recyclerView;
    private String[] strings={"好友","分组","群聊","设备","订阅号"};
    private FriendRecyclerViewAdpater friendRecyclerViewAdpater;

    private int oncheck=1;



    private FriendListFragment friendListFragment;
    private FriendGroupFragment friendGroupFragment;
    private TalkGroupExpendListFragment talkGroupExpendListFragment;
    private EquipmentFragment equipmentFragment;
    private SubscriptionFragement subscriptionFragement;

    //播放点击动画
    //final Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.alpha);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate=inflater.inflate(R.layout.fragment_friend_main,null);
        initView();
        initListener();
        return inflate;
    }

    private void initView(){
        //radioGroup=inflate.findViewById(R.id.friend_chose_group);
        recyclerView=(RecyclerView) inflate.findViewById(R.id.friend_chose_group);
        viewPager=(ViewPager) inflate.findViewById(R.id.view_pager);

        linearLayoutManager=new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        friendRecyclerViewAdpater=new FriendRecyclerViewAdpater(getActivity(),list());
        recyclerView.setAdapter(friendRecyclerViewAdpater);

        friendRecyclerViewAdpater.setOnItemClickListener(new FriendRecyclerViewAdpater.OnItemClickListener() {
                                                             @Override
                                                             public void onItemClick(View view, int position) {
                                                                 if (position!=oncheck) {
                                                                     oncheck=position;
                                                                     viewPager.setCurrentItem(oncheck);
                                                                 }
                                                             }
                                                         });
        FragmentPagerAdapter fragmentPagerAdapter=new FriendPagerAdpater(getChildFragmentManager(),getFragments());
        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.setCurrentItem(oncheck);
    }

    private List<String> list(){
        List<String> list=new ArrayList<>();
        for (int i=0;i<strings.length;i++){
            list.add(strings[i]);
        }

        return list;
    }


    private List<Fragment> getFragments(){
        friendGroupFragment=new FriendGroupFragment();
        friendListFragment=new FriendListFragment();
        talkGroupExpendListFragment=new TalkGroupExpendListFragment();
        equipmentFragment=new EquipmentFragment();
        subscriptionFragement=new SubscriptionFragement();

        List<Fragment> fragments=new ArrayList<>();
        fragments.add(friendListFragment);
        fragments.add(friendGroupFragment);
        fragments.add(talkGroupExpendListFragment);
        fragments.add(equipmentFragment);
        fragments.add(subscriptionFragement);


        return fragments;
    }

    private void initListener(){
        //radioGroup.setOnCheckedChangeListener(this);
        viewPager.addOnPageChangeListener(this);
    }

    /**
     * RadioGroup点击事件
     * @param group
     * @param checkedId
     */
  /*  @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.friend_group_1:
                viewPager.setCurrentItem(0);
                break;
            case R.id.friend_group_2:
                viewPager.setCurrentItem(1);
                break;
            case R.id.friend_group_3:
                viewPager.setCurrentItem(2);
                break;
            case R.id.friend_group_4:
                viewPager.setCurrentItem(3);
                break;
        }
    }*/


    /**
     * ViewPager滑动事件
     * @param position
     * @param positionOffset
     * @param positionOffsetPixels
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        friendRecyclerViewAdpater.setIsCheck(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


}
