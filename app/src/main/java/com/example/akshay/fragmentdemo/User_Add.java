package com.example.akshay.fragmentdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class User_Add extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    public static final String mypreference = "mypref";
    SharedPreferences settings;

    public User_Add() {

    }

    public static User_Add newInstance(int sectionNumber) {
        User_Add fragment = new User_Add();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user_add, container, false);

        settings = getActivity().getSharedPreferences(mypreference, Context.MODE_PRIVATE); //1
        String text = settings.getString("EMAIL", null); //2
        Log.e("Email","____text____"+text);
        Toast.makeText(getActivity(), "email"+text, Toast.LENGTH_SHORT).show();

        return rootView;
    }
}