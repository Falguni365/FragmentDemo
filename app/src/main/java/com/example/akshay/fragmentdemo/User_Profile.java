package com.example.akshay.fragmentdemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class User_Profile extends Fragment {

    public static final String mypreference = "mypref";
    SharedPreferences settings;

    private static final String ARG_SECTION_NUMBER = "section_number";


    TextView user_name, last_name, email_id, phone_number;
    Button signoutbtn;

    public User_Profile() {

    }


    public static User_Profile newInstance(int sectionNumber) {
        User_Profile fragment = new User_Profile();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);

        return fragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);

        user_name = (TextView) view.findViewById(R.id.firstname);
        last_name = (TextView) view.findViewById(R.id.userlastname);
        email_id = (TextView) view.findViewById(R.id.emailid);
        phone_number = (TextView) view.findViewById(R.id.phoneNumber);

        signoutbtn = (Button) view.findViewById(R.id.signout);

        settings = getActivity().getSharedPreferences(mypreference, Context.MODE_PRIVATE); //1
        String FirstName = settings.getString("UserName", null); //2
        String LastName = settings.getString("LastName", null); //2
        String EmailID = settings.getString("EMAIL", null); //2
        String PhoneNumber = settings.getString("PhoneNumber", null); //2


        user_name.setText(FirstName);
        last_name.setText(LastName);
        email_id.setText(EmailID);
        phone_number.setText(PhoneNumber);

        Log.e("Email", "____text____" + EmailID);
        Log.e("First Name", "____text____" + FirstName);
        Log.e("Last name", "____text____" + LastName);
        Log.e("Ph No.", "____text____" + PhoneNumber);
//        Toast.makeText(getActivity(), "email"+EmailID, Toast.LENGTH_SHORT).show();

        signoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), loginActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}