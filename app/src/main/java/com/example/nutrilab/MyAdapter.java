package com.example.nutrilab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context context;
    List<Item> items;

    public MyAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.foodNames.setText((items.get(position).getFoodname()));
        holder.foodCalories.setText(String.valueOf(items.get(position).getCalories()));
        holder.foodCarbohydrates.setText(String.valueOf(items.get(position).getCarbohydrates()));
        holder.foodProteins.setText(String.valueOf(items.get(position).getProteins()));
        holder.foodFat.setText(String.valueOf(items.get(position).getFat()));
        holder.foodGlucose.setText(String.valueOf(items.get(position).getGlucose()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
