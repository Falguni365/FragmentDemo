package com.example.akshay.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class User_Library_Shelf extends Fragment{
    private static final String ARG_SECTION_NUMBER = "section_number";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user_library_shelf, container, false);
//        TextView textView = rootView.findViewById(R.id.section_lable1);
//        textView.setText("AKSHAY");
        return rootView;
    }
}