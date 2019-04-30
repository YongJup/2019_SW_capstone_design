package com.capstone.jeju.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.capstone.jeju.Fragment.MiseFragment;
import com.capstone.jeju.Fragment.ToiletFragment;
import com.capstone.jeju.Fragment.TransportFragment;

public class TabPagerAdapter extends FragmentPagerAdapter {
    private int tabCount;

    public TabPagerAdapter(FragmentManager fragmentManager, int tabCount) {
        super(fragmentManager);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                MiseFragment miseFragment = new MiseFragment();
                return miseFragment;
            case 1:
                TransportFragment transportFragment = new TransportFragment();
                return transportFragment;
            case 2:
                ToiletFragment toiletFragment = new ToiletFragment();
                return toiletFragment;
            default :
                return null;
        }
    }

    public int getCount() {
        return tabCount;
    }
}
