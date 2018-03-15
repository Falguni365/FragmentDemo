package com.example.akshay.fragmentdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class user_bottomNavigationBar extends AppCompatActivity {

    private TextView mTextMessage;
    BottomNavigationView navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_bottom_navigation_bar);

        mTextMessage = (    TextView) findViewById(R.id.message);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
       // navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        setUpHomeFragment();

        navigation.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.navigation_home:
                                selectedFragment = User_Home.newInstance(1);
                                break;
                            case R.id.navigation_author:
                                selectedFragment = User_Author.newInstance(2);
                                break;
                            case R.id.navigation_add:
                                selectedFragment = User_Add.newInstance(3);
                                break;
                            case R.id.navigation_library:
                                selectedFragment = User_Library.newInstance(4);
                                break;
                            case R.id.navigation_profile:
                                selectedFragment = User_Profile.newInstance(5);
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_container_user, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });



    }

    private void setUpHomeFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack();
        fragmentManager.beginTransaction().add(R.id.frame_container_user, new User_Home()).commit();

    }
}