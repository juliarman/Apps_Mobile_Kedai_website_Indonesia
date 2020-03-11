package com.juliarmanumar.kedaiwebsite;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Parcelable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.juliarmanumar.kedaiwebsite.GmailKirim.KirimActivity;
import com.juliarmanumar.kedaiwebsite.GmailKirim.KirimTask;

import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterPaket extends FirestoreRecyclerAdapter <Paket, AdapterPaket.PaketHolder> {



    public AdapterPaket(@NonNull FirestoreRecyclerOptions<Paket> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final PaketHolder holder, int position, @NonNull final Paket model) {

        holder.nm_paket.setText(model.getNama_paket());
        holder.hrg_paket.setText(model.getHarga_paket());
        holder.desk_paket.setHtml(model.getDeskripsi_paket());
        holder.jn_paket.setText(model.getJenis_paket());

        holder.btn_pesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String namapaket = holder.nm_paket.getText().toString();

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
                v.getContext().startActivity(sendIntent2);


                /*Intent intent = new Intent(v.getContext(), KirimActivity.class);
                intent.putExtra("namapaket", namapaket);
                v.getContext().startActivity(intent);

                 */


            }
        });
    }

    @NonNull
    @Override
    public PaketHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_hargapaket, parent, false);
        return new PaketHolder(view);
    }

    class PaketHolder extends RecyclerView.ViewHolder{

        TextView nm_paket;
        TextView hrg_paket;
        HtmlTextView desk_paket;
        TextView jn_paket;
        Button btn_pesan;
        Button sendmail;
        EditText nama;
        EditText paketdipilih;
        TextView bori;


        public PaketHolder(@NonNull View itemView) {
            super(itemView);



            nm_paket = itemView.findViewById(R.id.nama_paket);
            hrg_paket = itemView.findViewById(R.id.harga_paket);
            desk_paket = itemView.findViewById(R.id.deskripsi_paket);
            jn_paket = itemView.findViewById(R.id.jenis_paket);
            btn_pesan = itemView.findViewById(R.id.btn_pesansekarang);
            bori = itemView.findViewById(R.id.editText4);

        }
    }

    public void form_pesanan(){



    }
}
