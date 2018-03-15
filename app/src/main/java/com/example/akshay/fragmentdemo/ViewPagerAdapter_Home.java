package com.example.akshay.fragmentdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class ViewPagerAdapter_Home extends FragmentPagerAdapter {

    public ViewPagerAdapter_Home(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new User_Home_Feed();
        } else if (position == 1) {
            fragment = new User_Home_Browse();
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0) {
            title = "News Feed";
        } else if (position == 1) {
            title = "BROWSE";
        }

        return title;
    }
}
