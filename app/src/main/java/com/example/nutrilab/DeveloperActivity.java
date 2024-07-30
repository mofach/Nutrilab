package com.example.nutrilab;


import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


public class DeveloperActivity extends AppCompatActivity {

    private ImageView gilang, aqil, gerry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_developer);

        gilang = findViewById(R.id.img_1);
        aqil = findViewById(R.id.img_2);
        gerry = findViewById(R.id.img_3);

        int gambar1 = R.drawable.aqilm;
        int gambar2 = R.drawable.gerry;
        int gambar3 = R.drawable.gilang;

        RequestOptions requestOptions = new RequestOptions().circleCrop();

        Glide.with(this)
                .load(gambar1)
                .apply(requestOptions)
                .into(aqil);

        Glide.with(this)
                .load(gambar2)
                .apply(requestOptions)
                .into(gerry);

        Glide.with(this)
                .load(gambar3)
                .apply(requestOptions)
                .into(gilang);
    }
}