package com.example.nutrilab;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    private TextView txtFoodName, txtFoodInformation, txtCalorie, txtSugar, txtCarbo, txtFat, txtProtein;
    private ProgressBar progressCalories, progressCarbo, progressProtein, progressFat, progressSugar;
    private void initUI(){
        txtFoodName = findViewById(R.id.txt_food_name);
        txtFoodInformation = findViewById(R.id.txt_food_information);
        txtCalorie = findViewById(R.id.calories);
        txtSugar = findViewById(R.id.glucose);
        txtCarbo = findViewById(R.id.carbohydrate);
        txtFat = findViewById(R.id.fat);
        txtProtein = findViewById(R.id.protein);

        progressCalories = findViewById(R.id.progressBarCalories);
        progressCarbo = findViewById(R.id.progressBarCarbohydrate);
        progressProtein = findViewById(R.id.progressBarProtein);
        progressFat = findViewById(R.id.progressBarFat);
        progressSugar = findViewById(R.id.progressBarGlucose);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initUI();
        // Terima data dari Intent
        String foodName = getIntent().getStringExtra("foodName");
        String foodInformation = getIntent().getStringExtra("foodInformation");
        String calorie = getIntent().getStringExtra("calorie");
        String sugar = getIntent().getStringExtra("sugar");
        String carbohydrate = getIntent().getStringExtra("carbohydrate");
        String fat = getIntent().getStringExtra("fat");
        String protein = getIntent().getStringExtra("protein");

        // Tampilkan data pada TextView
        txtFoodName.setText(foodName);
        txtFoodInformation.setText(foodInformation);
        txtCalorie.setText(calorie);
        txtSugar.setText(sugar);
        txtCarbo.setText(carbohydrate);
        txtFat.setText(fat);
        txtProtein.setText(protein);
    }
}
