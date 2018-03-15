package com.example.akshay.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class updateeventdetails extends Fragment {


    private static final String ARG_SECTION_NUMBER = "section_number";
    EditText event_name, event_place, event_description;
    Button signup_button;
    DatabaseReference mDatabase;

    public updateeventdetails() {

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
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_updateeventdetails, container, false);

        event_name = (EditText) view.findViewById(R.id.eventname);
        event_place = (EditText) view.findViewById(R.id.eventlocation);
        event_description = (EditText) view.findViewById(R.id.eventdescription);
        signup_button = (Button) view.findViewById(R.id.eventsubmitbtn);

        mDatabase = FirebaseDatabase.getInstance().getReference("Event Details");

        AddBtn();
        return view;
    }

    private void AddBtn() {

        signup_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

//                Log.e("_______userType______", "userType" + userType);


                String userid = mDatabase.push().getKey();
                UserData userData = new UserData();
                userData.setEventName(event_name.getText().toString());
                userData.setEventLocation(event_place.getText().toString());
                userData.setEventDescription(event_description.getText().toString());

                mDatabase.child(userid).setValue(userData);


                Toast.makeText(getActivity(), "Event Details Updated", Toast.LENGTH_LONG);
                clearData();
            }
        });
    }

    private void clearData() {


        event_name.getText().clear();
        event_place.getText().clear();
        event_description.getText().clear();


    }
}