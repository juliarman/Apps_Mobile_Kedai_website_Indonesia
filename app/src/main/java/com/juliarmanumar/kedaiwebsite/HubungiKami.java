package com.juliarmanumar.kedaiwebsite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.firestore.util.Util;

public class HubungiKami extends AppCompatActivity implements View.OnClickListener {


    Button ASupport, LCurhat, TSupport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hubungi_kami);
        getSupportActionBar().hide();

        ASupport = findViewById(R.id.adminsupport);
        LCurhat = findViewById(R.id.layanancurhat);
        TSupport = findViewById(R.id.technicalsupport);

        ASupport.setOnClickListener(this);
        LCurhat.setOnClickListener(this);
        TSupport.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){


            case R.id.adminsupport:

                String pesan = "Saya ingin tanya seputar harga website";
                String nomor = "+6281242400642";
                nomor = nomor.replace("+", "").replace(" ", "");
                Intent sendIntent = new Intent("android.intent.action.MAIN");
                sendIntent.putExtra("jid", nomor + "@s.whatsapp.net");
                sendIntent.putExtra(Intent.EXTRA_TEXT, pesan);
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setPackage("com.whatsapp");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);

                break;


            case R.id.layanancurhat:

                String pesan2 = "Saya ingin konsultasi seputar website saya.";
                String nomor2 = "+6281242400642";
                nomor2 = nomor2.replace("+", "").replace(" ", "");
                Intent sendIntent2 = new Intent("android.intent.action.MAIN");
                sendIntent2.putExtra("jid", nomor2 + "@s.whatsapp.net");
                sendIntent2.putExtra(Intent.EXTRA_TEXT, pesan2);
                sendIntent2.setAction(Intent.ACTION_SEND);
                sendIntent2.setPackage("com.whatsapp");
                sendIntent2.setType("text/plain");
                startActivity(sendIntent2);

                break;



            case R.id.technicalsupport:

               String pesan3 = "Saya ingin konsultasi seputar website saya.";
                String nomor3 = "+6281242400642";
                nomor3 = nomor3.replace("+", "").replace(" ", "");
                Intent sendIntent3 = new Intent("android.intent.action.MAIN");
                sendIntent3.putExtra("jid", nomor3 + "@s.whatsapp.net");
                sendIntent3.putExtra(Intent.EXTRA_TEXT, pesan3);
                sendIntent3.setAction(Intent.ACTION_SEND);
                sendIntent3.setPackage("com.whatsapp");
                sendIntent3.setType("text/plain");
                startActivity(sendIntent3);

                break;
        }

    }
}
