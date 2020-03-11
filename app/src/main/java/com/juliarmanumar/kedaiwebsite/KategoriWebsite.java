package com.juliarmanumar.kedaiwebsite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.juliarmanumar.kedaiwebsite.GmailKirim.KirimActivity;
import com.juliarmanumar.kedaiwebsite.ListPaketWebsite.List_Paket_Website;

public class KategoriWebsite extends AppCompatActivity implements View.OnClickListener {

    Button btn_bisnis, btn_instansi, btn_otomotif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori_website);
        getSupportActionBar().hide();


        btn_bisnis = findViewById(R.id.btn_business);
        btn_instansi = findViewById(R.id.paketinstansi);
        btn_otomotif = findViewById(R.id.paketotomotif);


        btn_bisnis.setOnClickListener(this);
        btn_instansi.setOnClickListener(this);
        btn_otomotif.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {



        switch (v.getId()){

            case R.id.btn_business:

                Intent paketbisnis = new Intent(KategoriWebsite.this, List_Paket_Website.class);
                startActivity(paketbisnis);
                break;


            case R.id.paketinstansi:

                String pesan2 = "##FORM PEMESANAN##\n" +
                        "\n" +
                        "Nama:   ---------------------\n" +
                        "Alamat: ---------------------\n" +
                        "Email :   ---------------------\n" +
                        "No Hp:  --------------------\n" +
                        "Jenis Jasa: -----------------\n" +
                        "Jenis Paket ----------------\n" +
                        "\n" +
                        "Detail Pesanan: ---------------------------------\n" +
                        "---------------------------------";
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

            case R.id.paketotomotif:

                Intent btnotomotif = new Intent(KategoriWebsite.this, ListPaketWebOtomotif.class);
                startActivity(btnotomotif);

                break;



        }

    }
}
