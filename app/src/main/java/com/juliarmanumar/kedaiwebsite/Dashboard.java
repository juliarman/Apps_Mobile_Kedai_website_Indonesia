package com.juliarmanumar.kedaiwebsite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class Dashboard extends AppCompatActivity {

    CarouselView slidehome;

    int[] gambar_slide = {R.drawable.jasawebsite23, R.drawable.jasadesign, R.drawable.jasaseo2};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        getSupportActionBar().hide();


        slidehome = findViewById(R.id.slidenya);
        slidehome.setPageCount(gambar_slide.length);

        slidehome.setImageListener(slidedashboard);
    }


    ImageListener slidedashboard  = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(gambar_slide[position]);
        }
    };
}
