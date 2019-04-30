package com.capstone.jeju;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.support.v7.widget.Toolbar;

import com.capstone.jeju.Adapter.TabPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView imageView;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setToolbar();
        addTab();
        pageAdapter();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        imageView = (ImageView) findViewById(R.id.main_title);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
    }

    public void setToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    public void addTab() {
        tabLayout.addTab(tabLayout.newTab().setText("미세먼지"));
        tabLayout.addTab(tabLayout.newTab().setText("교통정보"));
        tabLayout.addTab(tabLayout.newTab().setText("화장실 위치"));
    }

    public void pageAdapter() {
        viewPager = (ViewPager) findViewById(R.id.pager);
        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
