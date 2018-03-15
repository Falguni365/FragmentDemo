package com.example.akshay.fragmentdemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class User_Author extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter_Author viewPagerAdapterAuthor;

    private static final String ARG_SECTION_NUMBER = "section_number";

    public User_Author() {

    }

    public static User_Author newInstance(int sectionNumber) {
        User_Author fragment = new User_Author();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user_author, container, false);

        init(rootView);

        return rootView;

    }

    private void init(View rootView) {
        viewPager = (ViewPager) rootView.findViewById(R.id.viewPager1);
        tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
        viewPagerAdapterAuthor = new ViewPagerAdapter_Author(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapterAuthor);
        tabLayout.setupWithViewPager(viewPager);

    }
}