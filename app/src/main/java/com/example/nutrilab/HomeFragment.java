package com.example.nutrilab;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nutrilab.model.FoodRequest;
import com.example.nutrilab.model.FoodResponse;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private EditText editFood;
    private ShapeableImageView btnSend;

    private void initUI(View view){
        editFood = view.findViewById(R.id.edit_food);
        btnSend = view.findViewById(R.id.btn_send);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initUI(view);

        // Data Dummy
        List<Item> items = new ArrayList<>();
        items.add(new Item("Salad Buah", 50, 75, 80, 30, 10));
        items.add(new Item("Pasta Primavera", 300, 15, 60, 10, 5));
        items.add(new Item("Grilled Chicken Salad", 200, 25, 15, 10, 8));
        items.add(new Item("Salad Buah", 50, 75, 80, 30, 10));
        items.add(new Item("Pasta Primavera", 300, 15, 60, 10, 5));
        items.add(new Item("Grilled Chicken Salad", 200, 25, 15, 10, 8));

        // RecyclerView setup
        RecyclerView recyclerView = view.findViewById(R.id.history_recyclervw);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(new MyAdapter(requireContext(), items));


//        btnSend on action yow dawg
        btnSend.setOnClickListener(v -> {
            String food = editFood.getText().toString();
            trackFood(food);
        });

        return view;
    }

    private void trackFood(String food) {
        FoodRequest foodRequest = new FoodRequest(food);
        ApiService apiService = RetrofitClient.getApiService();
        Call<FoodResponse> call = apiService.trackFood(foodRequest);

        call.enqueue(new Callback<FoodResponse>() {
            @Override
            public void onResponse(Call<FoodResponse> call, Response<FoodResponse> response) {
                if (response.isSuccessful()){
                FoodResponse.FoodData foodData = response.body().getData();
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("foodName", foodData.getFoodName());
                intent.putExtra("foodInformation", foodData.getFoodInformation());
                intent.putExtra("calorie", foodData.getCalorie());
                intent.putExtra("sugar", foodData.getSugar());
                intent.putExtra("carbohydrate", foodData.getCarbohydrate());
                intent.putExtra("fat", foodData.getFat());
                intent.putExtra("protein", foodData.getProtein());

                startActivity(intent);
            } else {
                Toast.makeText(getActivity(), "Failed to retrieve food information", Toast.LENGTH_SHORT).show();
            }
            }

            @Override
            public void onFailure(Call<FoodResponse> call, Throwable t) {
                Log.e("FoodTrackerActivity", "onFailure: " + t.getMessage());
                Toast.makeText(getActivity(), "Request failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
