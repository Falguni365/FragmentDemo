package com.example.akshay.fragmentdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class author_bottomNavigationBar extends AppCompatActivity {

    private TextView mTextMessage;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_Feed:
//                    mTextMessage.setText(R.string.title_home);
                    author_feed fragment = author_feed.newInstance(1);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame_container_author, fragment)
                            .commit();

                    return true;
                case R.id.navigation_Blog:
//                    mTextMessage.setText(R.string.title_dashboard);
                    author_blog fragment1 = author_blog.newInstance(1);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame_container_author, fragment1)
                            .commit();
                    return true;

                case R.id.navigation_Updates:
//                    mTextMessage.setText(R.string.title_notifications);
                    author_updates fragment2 = author_updates.newInstance(1);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame_container_author, fragment2)
                            .commit();
                    return true;
                case R.id.navigation_profile_author:
//                    mTextMessage.setText(R.string.title_notifications);
                    User_Profile fragment3 = User_Profile.newInstance(1);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame_container_author, fragment3)
                            .commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_bottom_navigation_bar);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
