package com.capstone.jeju.Activity;

import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;

import com.capstone.jeju.Adapter.TabPagerAdapter;
import com.capstone.jeju.Fragment.ToiletFragment;
import com.capstone.jeju.Fragment.TransportFragment;
import com.capstone.jeju.R;
import com.capstone.jeju.StaticViewPager;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView imageView;
    private TabLayout tabLayout;
    private StaticViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setToolbar();
        addTab();
        pageAdapter();

//        MapView mapView = new MapView(this);
//        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
//        mapViewContainer.addView(mapView);
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
        tabLayout.addTab(tabLayout.newTab().setText("교통정보"));
        tabLayout.addTab(tabLayout.newTab().setText("미세먼지"));
        tabLayout.addTab(tabLayout.newTab().setText("화장실 위치"));
    }

    public void pageAdapter() {
        viewPager = (StaticViewPager) findViewById(R.id.pager);
        final TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                Log.i("tab", String.valueOf(tab.getPosition()));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    ((TransportFragment)tabPagerAdapter.getItem(0)).removeMap();
                } else if(tab.getPosition() == 2) {
                    ((ToiletFragment)tabPagerAdapter.getItem(2)).removeMap();
                }
                Log.i("tab1", String.valueOf(tab.getPosition()));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Log.i("tab2", String.valueOf(tab.getPosition()));
            }
        });

        viewPager.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View arg0, MotionEvent arg1) {
                return true;
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
}
