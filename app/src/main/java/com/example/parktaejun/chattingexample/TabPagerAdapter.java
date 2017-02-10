package com.example.parktaejun.chattingexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.parktaejun.chattingexample.Fragment.ChatFragment;
import com.example.parktaejun.chattingexample.Fragment.OptionFragment;
import com.example.parktaejun.chattingexample.Fragment.PersonFragment;

/**
 * Created by parktaejun on 2017. 2. 10..
 */

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    private int tabCount;

    public TabPagerAdapter(FragmentManager fm, int tabCount){
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position){

        switch (position){
            case 0:
                PersonFragment personFragment = new PersonFragment();
                return personFragment;
            case 1:
                ChatFragment chatFragment = new ChatFragment();
                return chatFragment;
            case 2:
                OptionFragment optionFragment = new OptionFragment();
                return optionFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}