package com.example.akshay.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class User_Author_Books extends Fragment{
        private static final String ARG_SECTION_NUMBER = "section_number";

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_user_author_book,container,false);
          /*  String[] menuItems = {"New","Books","Ovwe","Here","New","Books","Ovwe","Here","New","Books","Ovwe","Here","New","Books","Ovwe","Here"};
             ListView listView = (ListView) view.findViewById(R.id.userauthorbooklistview);

//        CardView card_view = (CardView) view.findViewById(R.id.cardViews);
            ArrayAdapter<String> listViewAdepter = new ArrayAdapter<String>(
                    getActivity(),
                    android.R.layout.simple_list_item_1,
                    menuItems
            );
            listView.setAdapter(listViewAdepter);*/
            return view;
        }
}