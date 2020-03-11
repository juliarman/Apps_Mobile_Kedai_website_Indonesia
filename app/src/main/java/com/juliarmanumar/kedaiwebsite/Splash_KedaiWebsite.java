package com.juliarmanumar.kedaiwebsite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash_KedaiWebsite extends AppCompatActivity {

    Handler kedai_splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__kedai_website);

        kedai_splash = new Handler();
        kedai_splash.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent splash = new Intent(Splash_KedaiWebsite.this, Home.class);
                startActivity(splash);

            }
        }, 3000);

        getSupportActionBar().hide();
    }
}
