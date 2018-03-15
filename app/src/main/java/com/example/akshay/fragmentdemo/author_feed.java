package com.example.akshay.fragmentdemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Akshay on 13-02-2018.
 */

public class author_feed extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    SharedPreferences settings;
    private DatabaseReference mDatabase;
    ArrayList<AuthorBlog> authorBlogArrayList;
    ListView listView;
    TextView user_name;

    public author_feed() {

    }

    public static author_feed newInstance(int sectionNumber) {
        author_feed fragment = new author_feed();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_author_feed, container, false);

        user_name = (TextView) rootView.findViewById(R.id.blogername);

        mDatabase = FirebaseDatabase.getInstance().getReference("Author Blog");
        authorBlogArrayList = new ArrayList<AuthorBlog>();
        listView = (ListView) rootView.findViewById(R.id.authorfeed);

        mDatabase.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    final AuthorBlog authorBlog = snapshot.getValue(AuthorBlog.class);
                    authorBlogArrayList.add(authorBlog);


                    final String strbolg = authorBlog.getBlog();
                    final String stremail = authorBlog.getEmailID();
//                    Log.e("strbolg", "---------strbolg---------" + strbolg);
//                    Log.e("stremail", "---------strbolg---------" + stremail);
                    setdata(authorBlogArrayList);


                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return rootView;
    }

    private void setdata(ArrayList<AuthorBlog> authorBlogArrayList) {
        AuthorBlogAdapter mAdapter = new AuthorBlogAdapter(getActivity(), authorBlogArrayList);
        listView.setAdapter(mAdapter);


    }

}