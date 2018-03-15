package com.example.akshay.fragmentdemo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class displayPreviousBlogs extends Fragment {

    // TO DISPLAY PREVIOUS BLLOGS  IN LIST VIEW.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user_author_blog, container, false);
        String[] menuItems = {};
        ListView listView = (ListView) view.findViewById(R.id.bloglist);

        ArrayAdapter<String> listViewAdepter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems
        );

        listView.setAdapter(listViewAdepter);
        return view;
    }
}