package com.example.akshay.fragmentdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class User_Author_Blogs extends Fragment{
    private static final String ARG_SECTION_NUMBER = "section_number";

    private DatabaseReference mDatabase;
    ArrayList<AuthorBlog> authorBlogArrayList;
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user_author_blog,container,false);

        mDatabase = FirebaseDatabase.getInstance().getReference("Author Blog");
        authorBlogArrayList = new ArrayList<AuthorBlog>();
        listView = (ListView) view.findViewById(R.id.userauthorbloglistview);

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