package com.example.nutrilab;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class EditProfilActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofil);

        // Temukan ImageView di layout
        ImageView profileImageView = findViewById(R.id.img_profile);

        // Gunakan Glide untuk memuat gambar dengan transformasi bulat
        Glide.with(this)
                .load(R.drawable.azz) // Ganti dengan URL atau sumber gambar yang sesuai
                .apply(RequestOptions.circleCropTransform())
                .into(profileImageView);

    }

}
