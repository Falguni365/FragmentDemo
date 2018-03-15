package com.example.akshay.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay on 13-02-2018.
 */

public class User_Home_Browse extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    private RecyclerView recyclerView;
    private MyAdepter adepter;
    private List<RecyclerItem> listItems;

    public User_Home_Browse() {

    }

    public static User_Home_Browse newInstance(int sectionNumber) {
        User_Home_Browse fragment = new User_Home_Browse();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user_home_browse, container, false);

//        recyclerView = (RecyclerView) getActivity().findViewById(R.id.recyclerView);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        listItems = new ArrayList<>();

//        for (int i = 0; i <= 10; i++) {
//
//            RecyclerView item = new RecyclerItem("Item " + (i + 1), "Welcome");
//            listItems.add(new RecyclerItem("Item " + (i + 1), "Welcome"));
//
//
//        }
//        adepter = new MyAdepter(listItems, this);
//        recyclerView.setAdapter(adepter);
        return rootView;
//    }
    }
}