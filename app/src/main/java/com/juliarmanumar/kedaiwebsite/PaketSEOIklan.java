package com.juliarmanumar.kedaiwebsite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class PaketSEOIklan extends AppCompatActivity {


    private FirebaseFirestore database = FirebaseFirestore.getInstance();
    private CollectionReference reference = database.collection("Paket SEO IKLAN");
    private AdapterPaket adapterPaket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paket_seoiklan);
        getSupportActionBar().hide();

        SeoIklan();

    }

    private void SeoIklan(){
        Query query = reference.orderBy("nama_paket", Query.Direction.DESCENDING);


        FirestoreRecyclerOptions<Paket> options = new FirestoreRecyclerOptions.Builder<Paket>()
                .setQuery(query, Paket.class)
                .build();

        adapterPaket = new AdapterPaket(options);

        RecyclerView recyclerView = findViewById(R.id.daftarpaketseoiklan);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterPaket);


    }


    @Override
    protected void onStart() {
        super.onStart();
        adapterPaket.startListening();
    }


    @Override
    protected void onStop() {
        super.onStop();
        adapterPaket.stopListening();

    }
}
