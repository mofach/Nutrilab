package com.example.nutrilab;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.nutrilab.model.FoodRequest;
import com.example.nutrilab.model.FoodResponse;
import com.google.android.material.imageview.ShapeableImageView;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private EditText editFood;
    private ShapeableImageView btnSend;
    private ProgressDialog progressDialog;

    private void initUI(View view) {
        editFood = view.findViewById(R.id.edit_food);
        btnSend = view.findViewById(R.id.btn_send);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initUI(view);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);

//        btnSend on action
        btnSend.setOnClickListener(v -> {
            String food = editFood.getText().toString();
            trackFood(food);
        });

        return view;
    }

    private void trackFood(String food) {
        progressDialog.show();
        String userId = "5fb3aa47-f976-4781-9c95-a6e65e8d9194";
        FoodRequest foodRequest = new FoodRequest(food, userId);
        ApiService apiService = RetrofitClient.getApiService();
        Call<FoodResponse> call = apiService.trackFood(foodRequest);

        call.enqueue(new Callback<FoodResponse>() {
            @Override
            public void onResponse(Call<FoodResponse> call, Response<FoodResponse> response) {

                progressDialog.dismiss();

                if (response.isSuccessful()) {
                    FoodResponse.FoodData foodData = response.body().getData();
                    FoodResponse.FoodData.FoodInfo foodInfo = foodData.getFoodInfo();
                    FoodResponse.FoodData.ProgressNutrition progressNutrition = foodData.getProgressNutrition();

                    Intent intent = new Intent(getActivity(), DetailActivity.class);
                    intent.putExtra("foodName", foodInfo.getFoodName());
                    intent.putExtra("foodInformation", foodInfo.getFoodInformation());
                    intent.putExtra("calorie", foodInfo.getCalorie());
                    intent.putExtra("sugar", foodInfo.getSugar());
                    intent.putExtra("carbohydrate", foodInfo.getCarbohydrate());
                    intent.putExtra("fat", foodInfo.getFat());
                    intent.putExtra("protein", foodInfo.getProtein());

                    intent.putExtra("totalCalories", progressNutrition.getTotalCalories());
                    intent.putExtra("totalCarbohydrate", progressNutrition.getTotalCarbohydrate());
                    intent.putExtra("totalProtein", progressNutrition.getTotalProtein());
                    intent.putExtra("totalFat", progressNutrition.getTotalFat());
                    intent.putExtra("totalSugar", progressNutrition.getTotalSugar());

                    startActivity(intent);
                } else {
                    try {
                        String errorMessage = response.errorBody().string();
                        Toast.makeText(getActivity(), "Error: " + errorMessage, Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        Toast.makeText(getActivity(), "Failed to retrieve food information", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<FoodResponse> call, Throwable t) {
                progressDialog.dismiss();
                Log.e("FoodTrackerActivity", "onFailure: " + t.getMessage());
                Toast.makeText(getActivity(), "Request failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
