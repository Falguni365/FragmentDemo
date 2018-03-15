package com.example.akshay.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Akshay on 13-02-2018.
 */

public class User_Home_Feed extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    private DatabaseReference mDatabase;
    ArrayList<AuthorBlog> authorBlogArrayList;
    ListView listView;


    public User_Home_Feed() {

    }

    public static User_Home_Feed newInstance(int sectionNumber) {
        User_Home_Feed fragment = new User_Home_Feed();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user_home_feed,container,false);

        mDatabase = FirebaseDatabase.getInstance().getReference("Author Blog");
        authorBlogArrayList = new ArrayList<AuthorBlog>();
        listView = (ListView) view.findViewById(R.id.userhomefeedlistview);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    AuthorBlog authorBlog = snapshot.getValue(AuthorBlog.class);
                    authorBlogArrayList.add(authorBlog);

                    String strbolg = authorBlog.getBlog();
                    Log.e("strbolg", "---------strbolg---------" + strbolg);
                    setdata(authorBlogArrayList);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        return view;
    }

    private void setdata(ArrayList<AuthorBlog> authorBlogArrayList) {
        AuthorBlogAdapter mAdapter = new AuthorBlogAdapter(getActivity(), authorBlogArrayList);
        listView.setAdapter(mAdapter);


    }
}