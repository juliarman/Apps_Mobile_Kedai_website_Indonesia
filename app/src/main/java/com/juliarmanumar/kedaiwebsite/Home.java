package com.juliarmanumar.kedaiwebsite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

public class Home extends AppCompatActivity implements View.OnClickListener {

    CardView PWebsite, HubungiKami, PDesain, PSeoIklan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        PWebsite = findViewById(R.id.paketwebsite);
        HubungiKami = findViewById(R.id.hubungikami);
        PDesain = findViewById(R.id.paketdesain);
        PSeoIklan = findViewById(R.id.paketseoiklann);

        PWebsite.setOnClickListener(this);
        HubungiKami.setOnClickListener(this);
        PDesain.setOnClickListener(this);
        PSeoIklan.setOnClickListener(this);

        getSupportActionBar().hide();


       /* BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottombarr);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.bertanya, "Bertanya"))
                .addItem(new BottomNavigationItem(R.drawable.petunjuk, "Petunjuk"))
                .addItem(new BottomNavigationItem(R.drawable.testimoni, "Testimoni"))
                .initialise();

        */
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.paketwebsite:

                Intent IntentPwebsite = new Intent(Home.this, KategoriWebsite.class);
                startActivity(IntentPwebsite);
                break;


            case R.id.paketseoiklann:

                Intent intentpaketseoiklan = new Intent(Home.this, PaketSEOIklan.class);
                startActivity(intentpaketseoiklan);
                break;

            case R.id.hubungikami:

                Intent Intenthubungikami = new Intent(Home.this, HubungiKami.class);
                startActivity(Intenthubungikami);
                break;


            case R.id.paketdesain:

                Intent intentpaketdesign = new Intent(Home.this, PaketDesain.class);
                startActivity(intentpaketdesign);

                break;
        }

    }
}
