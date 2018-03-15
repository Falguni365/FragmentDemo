package com.example.akshay.fragmentdemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class User_Home extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter_Home viewPagerAdapterA;

    private static final String ARG_SECTION_NUMBER = "section_number";

    public static User_Home newInstance(int sectionNumber) {
        User_Home fragment = new User_Home();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user_home, container, false);

        init(rootView);
       // setUpHomeFragment();

        return rootView;

    }

    private void init(View rootView) {
        viewPager = (ViewPager) rootView.findViewById(R.id.viewPager);
        tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
        viewPagerAdapterA = new ViewPagerAdapter_Home(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapterA);
        tabLayout.setupWithViewPager(viewPager);

    }

   /* private void setUpHomeFragment() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.popBackStack();
        fragmentManager.beginTransaction().add(R.id.frame_container_user, new User_Home()).commit();
4
    }*/

}
