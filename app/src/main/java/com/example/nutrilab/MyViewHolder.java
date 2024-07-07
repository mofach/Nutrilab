package com.example.nutrilab;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView foodNames, foodCalories, foodCarbohydrates, foodProteins, foodFat, foodGlucose;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        foodNames = itemView.findViewById(R.id.food_name);
        foodCalories = itemView.findViewById(R.id.calories);
        foodCarbohydrates = itemView.findViewById(R.id.carbohydrates);
        foodProteins = itemView.findViewById(R.id.proteins);
        foodFat = itemView.findViewById(R.id.fat);
        foodGlucose = itemView.findViewById(R.id.glucose);
    }
}
