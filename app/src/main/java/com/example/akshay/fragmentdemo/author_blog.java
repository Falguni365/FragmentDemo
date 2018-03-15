package com.example.akshay.fragmentdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Akshay on 13-02-2018.
 */

public class author_blog extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    public static final String mypreference = "mypref";
    SharedPreferences settings;


    Button submit_button, previous_blog;
    EditText bloghere;
//    TextView email_id;

    DatabaseReference mDatabase, nDatabase;
    FirebaseDatabase firebaseDatabase;

    public author_blog() {

    }

    public static author_blog newInstance(int sectionNumber) {
        author_blog fragment = new author_blog();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        //  DEFINING DATABASE WHERE DATA WILL GET STORED IN FIREBASE
        mDatabase = FirebaseDatabase.getInstance().getReference("Author Blog");


        View view = inflater.inflate(R.layout.fragment_author_blog, container, false);

        //******************************************************************************************


        settings = getActivity().getSharedPreferences(mypreference, Context.MODE_PRIVATE); //1


        //FETCHING EMAIL STRING FROM SHARED-PREF.
        final String EmaiID = settings.getString("EMAIL", null); //2


        //******************************************************************************************


        submit_button = (Button) view.findViewById(R.id.blogsubmit);
        previous_blog = (Button) view.findViewById(R.id.previousBlogs);
        bloghere = (EditText) view.findViewById(R.id.blog_here);


        //SUBMIT BUTTON WILL SUBMIT BLOG PLUS USER'S EMAIL-ID TO FIREBASE
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userid = mDatabase.push().getKey();
                AuthorBlog authorBlog = new AuthorBlog();
                authorBlog.setBlog(bloghere.getText().toString());
                authorBlog.setEmailID(EmaiID);

//                authorBlog.setUserType(userType);
                mDatabase.child(userid).setValue(authorBlog);


                Toast.makeText(getActivity(), "Blog Submitted", Toast.LENGTH_SHORT).show();

                bloghere.getText().clear();
            }
        });

        //TO CHECK PREVIOUS WRITTEN BLOG
        previous_blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }

}