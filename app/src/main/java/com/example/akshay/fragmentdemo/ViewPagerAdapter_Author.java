package com.example.akshay.fragmentdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class ViewPagerAdapter_Author extends FragmentPagerAdapter {

    public ViewPagerAdapter_Author(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new User_Author_Blogs();
        } else if (position == 1) {
            fragment = new User_Author_Books();
        } else if (position == 2) {
            fragment = new User_Author_Events();
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0) {
            title = "Blogs";
        } else if (position == 1) {
            title = "Books";
        } else if (position == 2) {
            title = "Event";
        }

        return title;
    }
}
