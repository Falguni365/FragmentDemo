package com.example.akshay.fragmentdemo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class splash_screen extends AppCompatActivity {
    TextView welcome,author_junction;
    Animation frombottom,fromtop;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        welcome=(TextView)findViewById(R.id.welcome_splash);
        author_junction=(TextView)findViewById(R.id.author_junction_splash);

        frombottom= AnimationUtils.loadAnimation(this,R.animator.frombottom);
        fromtop=AnimationUtils.loadAnimation(this,R.animator.fromtop);

        author_junction.setAnimation(frombottom);
        welcome.setAnimation(fromtop);

        startActivity(new Intent(splash_screen.this,loginActivity.class));
    }
}
