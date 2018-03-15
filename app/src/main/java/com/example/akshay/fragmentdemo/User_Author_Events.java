package com.example.akshay.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class User_Author_Events extends Fragment{
    private static final String ARG_SECTION_NUMBER = "section_number";
    private DatabaseReference mDatabase;
    ArrayList<AuthorEvent> authorAuthorEventsArrayList;
    ListView listView;

    public User_Author_Events() {

    }

    public static User_Author_Events newInstance(int sectionNumber) {
        User_Author_Events fragment = new User_Author_Events();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_author_event, container, false);

        mDatabase = FirebaseDatabase.getInstance().getReference("Event Details");
        authorAuthorEventsArrayList = new ArrayList<AuthorEvent>();
        listView = (ListView) view.findViewById(R.id.userauthoreventlistview);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    AuthorEvent authorEvent = snapshot.getValue(AuthorEvent.class);
                    authorAuthorEventsArrayList.add(authorEvent);

                    String strbolg = authorEvent.getEventName();
                    String strlocation = authorEvent.getEventLocation();
                    String strdescription  = authorEvent.getEventDescription();


                    setdata(authorAuthorEventsArrayList);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return view;
    }
    private void setdata(ArrayList<AuthorEvent> authorAuthorEventsArrayList) {
        AuthorEventAdapter mAdapter = new AuthorEventAdapter(getActivity(), authorAuthorEventsArrayList);
        listView.setAdapter(mAdapter);


    }
}