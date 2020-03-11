package com.juliarmanumar.kedaiwebsite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PaketDesain extends AppCompatActivity {

    Button btn_desain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paket_desain);
        getSupportActionBar().hide();

        btn_desain = findViewById(R.id.pesandesain);

        btn_desain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pesan2 = "##FORM PEMESANAN##\\n\" +\n" +
                        "                        \"\\n\" +\n" +
                        "                        \"Nama:   ---------------------\\n\" +\n" +
                        "                        \"Alamat: ---------------------\\n\" +\n" +
                        "                        \"Email :   ---------------------\\n\" +\n" +
                        "                        \"No Hp:  --------------------\\n\" +\n" +
                        "                        \"Jenis Jasa: -----------------\\n\" +\n" +
                        "                        \"Jenis Paket ----------------\\n\" +\n" +
                        "                        \"\\n\" +\n" +
                        "                        \"Detail Pesanan: ---------------------------------\\n\" +\n" +
                        "                        \"---------------------------------";
                String nomor2 = "+6281242400642";
                nomor2 = nomor2.replace("+", "").replace(" ", "");
                Intent sendIntent2 = new Intent("android.intent.action.MAIN");
                sendIntent2.putExtra("jid", nomor2 + "@s.whatsapp.net");
                sendIntent2.putExtra(Intent.EXTRA_TEXT, pesan2);
                sendIntent2.setAction(Intent.ACTION_SEND);
                sendIntent2.setPackage("com.whatsapp");
                sendIntent2.setType("text/plain");
                startActivity(sendIntent2);
            }
        });

    }
}
