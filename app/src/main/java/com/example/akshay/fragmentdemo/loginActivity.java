package com.example.akshay.fragmentdemo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class loginActivity extends AppCompatActivity implements View.OnClickListener {


    //    private Keystore store;//Holds our key pairs
    Button login_button, signup_button;
    //    RadioButton author_button, user_button;
    EditText user_Name, login_password;

    DatabaseReference mDatabase;
    FirebaseDatabase firebaseDatabase;
    String userid;
    public static final String mypreference = "mypref";
    SharedPreferences settings;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        Firebase.setAndroidContext(this);
        mDatabase = FirebaseDatabase.getInstance().getReference("user");
        userid = mDatabase.push().getKey();

        Toast.makeText(loginActivity.this, "Welcome to AUTHOR JUNCTION", Toast.LENGTH_SHORT).show();


        login_button = (Button) findViewById(R.id.loginbutton);
        signup_button = (Button) findViewById(R.id.loginSignUpButton);

        user_Name = (EditText) findViewById(R.id.loginUserID);
        login_password = (EditText) findViewById(R.id.loginUserPassword);

        login_button.setOnClickListener(this);
        signup_button.setOnClickListener(this);


    }
    public void onBackPressed() {
        //do nothing

        final AlertDialog.Builder builder = new AlertDialog.Builder(loginActivity.this);
        builder.setMessage("Are you sure you want to exit ?");
        builder.setCancelable(true);
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    @Override
    public void onClick(View view) {

        // IT WILL CHECK WHOLE DATABASE FOR MATCHINIG NAME AND PASSWORD

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                mDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                            // SHARED-PREF. HERE ALL THE DETAILS FROM FIREBASE WILL GET STORED IN EACH VARIALBLE
                            UserData userData = snapshot.getValue(UserData.class);

                            String username = userData.getFirstName();
                            String lastname = userData.getLastName();
                            String phoneNumber = userData.getPhoneNo();
                            String email = userData.getEmail();


                            String datatype = userData.getUserType();
                            String password = userData.getPassword();

//                            Log.e("LOGIN DATA", "email" + email + "\nUser Type " + datatype + " Password " + password);

                            if (user_Name.getText().toString().equals(email) && login_password.getText().toString().equals(password)) {


                                String strEmail = userData.getEmail();
                                String strUserName = userData.getFirstName();
                                String strLastName = userData.getLastName();
                                String strPhoneNumber = userData.getPhoneNo();
                                String strPassword = userData.getPassword();


                                settings = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
                                editor = settings.edit();

                                // IT WILL STORE DATA IN EDITOR IN THE FORM OF STRING
                                editor.putString("EMAIL", strEmail);
                                editor.putString("UserName", strUserName);
                                editor.putString("LastName", strLastName);
                                editor.putString("PhoneNumber", strPhoneNumber);
                                editor.putString("Password  ", strPassword);

                                editor.commit();

                                //  IF ITS AUTHOR, IT WILL BE LOGGED IN INTO AUTHOR'S LAYOUT
                                if (datatype.equals("Author")) {
                                    startActivity(new Intent(loginActivity.this, author_bottomNavigationBar.class));
                                    Toast.makeText(loginActivity.this, "Hey there Author", Toast.LENGTH_SHORT).show();
//                                    SaveInfo(view);

                                }
                                //  IF ITS USER, IT WILL BE LOGGED IN INTO USER'S LAYOUT
                                else {
                                    startActivity(new Intent(loginActivity.this, user_bottomNavigationBar.class));
                                    Toast.makeText(loginActivity.this, "Hey there User", Toast.LENGTH_SHORT).show();
//                                    SaveInfo(view);

                                }


                                // UPDATE CODE FOR INVALID USER NAME AND PASSWORD
                            }


                        }


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

        // REDIRECT TO SIGN-UP PAGE
        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginActivity.this, registrationActivity.class));
                Toast.makeText(loginActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
            }
        });

    }

}