package com.juliarmanumar.kedaiwebsite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.juliarmanumar.kedaiwebsite.GmailKirim.KirimActivity;

public class MainActivity extends AppCompatActivity {

    CardView  card_website, card_design;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        card_website = findViewById(R.id.paketwebsite);
        card_design = findViewById(R.id.paketdesign);


        card_website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              Intent intent = new Intent(MainActivity.this, Home.class);
              startActivity(intent);
            }
        });


        card_design.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent designintent = new Intent(MainActivity.this, KirimActivity.class);
                startActivity(designintent);
            }
        });
    }




}
