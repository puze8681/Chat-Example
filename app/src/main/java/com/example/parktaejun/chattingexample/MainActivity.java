package com.example.parktaejun.chattingexample;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);

        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.click_person).setTag("person"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.unclick_chat).setTag("chat"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.unclick_option).setTag("option"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("친구");

        TabPagerAdapter pagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                switch (tabLayout.getSelectedTabPosition()){
                    case 0:
                        getSupportActionBar().setTitle("친구");
                        tab.setIcon(R.mipmap.click_person);
                        break;
                    case 1:
                        getSupportActionBar().setTitle("채팅");
                        tab.setIcon(R.drawable.click_chat);
                        break;
                    case 2:
                        getSupportActionBar().setTitle("설정");
                        tab.setIcon(R.mipmap.click_option);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                switch (tabLayout.getSelectedTabPosition()){
                    case 0:
                        tab.setIcon(R.mipmap.unclick_person);
                        break;
                    case 1:
                        tab.setIcon(R.drawable.unclick_chat);
                        break;
                    case 2:
                        tab.setIcon(R.mipmap.unclick_option);
                        break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
