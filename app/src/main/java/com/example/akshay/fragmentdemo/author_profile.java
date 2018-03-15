package com.example.akshay.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Akshay on 13-02-2018.
 */

public class author_profile extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    public author_profile() {

    }
    public static author_profile newInstance(int sectionNumber) {
        author_profile fragment = new author_profile();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_author_profile, container, false);
//        TextView textView = rootView.findViewById(R.id.section_lable1);
//        textView.setText("AKSHAY");
        return rootView;
    }

//    FirebaseAuth.getInstance().signOut();

}