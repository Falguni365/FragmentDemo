package com.example.akshay.fragmentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class registrationActivity extends AppCompatActivity implements View.OnClickListener {

    Button signup_button, login_button;
    RadioButton user_button;
    RadioGroup groupRadio;
    EditText first_name, last_name, email_id, phone_number, registration_password;
    DatabaseReference mDatabase, nDatabase;
    FirebaseDatabase firebaseDatabase;
    String userType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Firebase.setAndroidContext(this);
        signup_button = (Button) findViewById(R.id.registrationSignup);
        login_button = (Button) findViewById(R.id.registrationLogin);
        first_name = (EditText) findViewById(R.id.restrationName);
        last_name = (EditText) findViewById(R.id.restrationSurname);
        email_id = (EditText) findViewById(R.id.restrationEmail);
        phone_number = (EditText) findViewById(R.id.restrationPhoneNumber);
        registration_password = (EditText) findViewById(R.id.registrationPassword);
        mDatabase = FirebaseDatabase.getInstance().getReference("user");

        //  signup_button.setOnClickListener(this);
        login_button.setOnClickListener(this);

        groupRadio = (RadioGroup) findViewById(R.id.rg);

        AddBtn();
    }

    private void AddBtn() {

        signup_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                int radioId = groupRadio.getCheckedRadioButtonId();
                user_button = (RadioButton) findViewById(radioId);
                userType = user_button.getText().toString();


                Log.e("_______userType______", "userType" + userType);

                if (!userType.isEmpty() && !userType.equals("")) {

                    String userid = mDatabase.push().getKey();
                    UserData userData = new UserData();
                    userData.setFirstName(first_name.getText().toString());
                    userData.setLastName(last_name.getText().toString());
                    userData.setEmail(email_id.getText().toString());
                    userData.setPhoneNo(phone_number.getText().toString());
                    userData.setPassword(registration_password.getText().toString());
                    userData.setUserType(userType);
                    mDatabase.child(userid).setValue(userData);


                    clearData();
                    Toast.makeText(registrationActivity.this, "Registration Succesfully Done", Toast.LENGTH_LONG).show();
//                    startActivity(new Intent(registrationActivity.this, loginActivity.class));

                    Toast.makeText(registrationActivity.this, "Go to Login Page now", Toast.LENGTH_LONG).show();


                } else {
                    Toast.makeText(registrationActivity.this, "Select who you are !", Toast.LENGTH_LONG).show();

                }


            }
        });


    }

    private void clearData() {

        groupRadio.clearCheck();
        first_name.getText().clear();
        last_name.getText().clear();
        email_id.getText().clear();
        phone_number.getText().clear();
        registration_password.getText().clear();

    }

    @Override
    public void onClick(View view) {
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(registrationActivity.this, loginActivity.class));
            }
        });


    }


}
