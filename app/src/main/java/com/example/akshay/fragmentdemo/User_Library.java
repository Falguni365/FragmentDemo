package com.example.akshay.fragmentdemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class User_Library extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter_Library viewPagerAdapterL;

    private static final String ARG_SECTION_NUMBER = "section_number";
    public User_Library() {

    }

    public static User_Library newInstance(int sectionNumber) {
        User_Library fragment = new User_Library();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user_library, container, false);

        init(rootView);

        return rootView;
    }

    private void init(View rootView) {
        viewPager = (ViewPager) rootView.findViewById(R.id.viewPager2);
        tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
        viewPagerAdapterL = new ViewPagerAdapter_Library(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapterL);
        tabLayout.setupWithViewPager(viewPager);

    }
}