package com.example.whatsapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.whatsapp.R;
import com.example.whatsapp.ui.adapter.MainViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {


    private ViewPager2 mainViewpager;
    private MainViewPagerAdapter viewpagerAdapter;
    private TabLayout tablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewpager();
    }

    public void initViewpager()
    {
        viewpagerAdapter=new MainViewPagerAdapter(getSupportFragmentManager(),
                this.getLifecycle(),3);
        mainViewpager=findViewById(R.id.mainViewpager);
        mainViewpager.setAdapter(viewpagerAdapter);
        tablayout=findViewById(R.id.tab_layout);
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mainViewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mainViewpager.registerOnPageChangeCallback(onPageChangeCallback);
    }

    private ViewPager2.OnPageChangeCallback onPageChangeCallback=new ViewPager2.OnPageChangeCallback() {
        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            tablayout.selectTab(tablayout.getTabAt(position));
        }
    };


        @Override
        protected void onDestroy() {
            super.onDestroy();
            mainViewpager.unregisterOnPageChangeCallback(onPageChangeCallback);
        }

}

