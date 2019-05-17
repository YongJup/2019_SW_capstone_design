package com.capstone.jeju.Adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.capstone.jeju.Fragment.MiseFragment;
import com.capstone.jeju.Fragment.ToiletFragment;
import com.capstone.jeju.Fragment.TransportFragment;

import net.daum.mf.map.api.MapView;

public class TabPagerAdapter extends FragmentPagerAdapter {
    private int tabCount;
    private MiseFragment miseFragment;
    private TransportFragment transportFragment;
    private ToiletFragment toiletFragment;

    public TabPagerAdapter(FragmentManager fragmentManager, int tabCount) {
        super(fragmentManager);
        this.tabCount = tabCount;
        miseFragment = new MiseFragment();
        transportFragment = new TransportFragment();
        toiletFragment = new ToiletFragment();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return transportFragment;
            case 1:
                return miseFragment;
            case 2:
                return toiletFragment;
            default :
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "교통상황";
            case 1:
                return "미세먼지";
            case 2:
                return "화장실 위치";
            default :
                return null;
        }
    }

    public int getCount() {
        return tabCount;
    }
}
