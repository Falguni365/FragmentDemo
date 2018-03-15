package com.example.akshay.fragmentdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Akshay on 13-02-2018.
 */

public class ViewPagerAdapter_Library extends FragmentPagerAdapter {
    public ViewPagerAdapter_Library(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new User_Library_Desk();
        } else if (position == 1) {
            fragment = new User_Library_Shelf();
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
            title = "DESK";
        } else if (position == 1) {
            title = "SHELF";
        }

        return title;
    }
}
