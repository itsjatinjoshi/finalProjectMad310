package com.example.finalprojectmad310;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {
    ImageView Welcome_Logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Welcome_Logo= findViewById(R.id.Welcome_Logo);


        Animation ani = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        ani.setDuration(5000);

        Welcome_Logo.setAnimation(ani);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        animation.setDuration(5000);
        Welcome_Logo.setAnimation(animation);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash.this,MainActivity.class);
                startActivity(i);
                finish();

            }
        },10000);

    }
}
