package com.example.nutrilab;

import android.animation.ObjectAnimator;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.nutrilab.model.FoodRequest;
import com.example.nutrilab.model.FoodResponse;
import com.example.nutrilab.model.ProgressNutritionResponse;
import com.example.nutrilab.model.TotalNutritionResponse;
import com.google.android.material.imageview.ShapeableImageView;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private EditText editFood;
    private ShapeableImageView btnSend;
    private ProgressDialog progressDialog;
    private TextView txtProgresCalorie, txtTotalCalorie, txtProgresCarbo, txtTotalCarbo, txtProgresProtein, txtTotalProtein, txtProgresFat, txtTotalFat, txtProgresSugar, txtTotalSugar;
    private ProgressBar pbCalories, pbCarbo, pbProtein, pbFat, pbSugar;

    private void initUI(View view) {
        editFood = view.findViewById(R.id.edit_food);
        btnSend = view.findViewById(R.id.btn_send);
        pbCalories = view.findViewById(R.id.pb_calories);
        pbCarbo = view.findViewById(R.id.pb_carbohydrates);
        pbProtein = view.findViewById(R.id.pb_proteins);
        pbFat = view.findViewById(R.id.pb_fat);
        pbSugar = view.findViewById(R.id.pb_glucose);
        txtProgresCalorie = view.findViewById(R.id.txt_progress_calories);
        txtProgresCarbo = view.findViewById(R.id.txt_progress_carbo);
        txtProgresProtein = view.findViewById(R.id.txt_progress_protein);
        txtProgresFat = view.findViewById(R.id.txt_progress_fat);
        txtProgresSugar = view.findViewById(R.id.txt_progress_sugar);
        txtTotalCalorie = view.findViewById(R.id.txt_total_calories);
        txtTotalCarbo = view.findViewById(R.id.txt_total_carbo);
        txtTotalProtein = view.findViewById(R.id.txt_total_protein);
        txtTotalFat = view.findViewById(R.id.txt_total_fat);
        txtTotalSugar = view.findViewById(R.id.txt_total_sugar);
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

        getProgress();
        getTotalProgress();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getProgress();
        getTotalProgress();
    }

    private void getTotalProgress() {
        String userId = "5fb3aa47-f976-4781-9c95-a6e65e8d9194";
        ApiService apiService = RetrofitClient.getApiService();
        Call<TotalNutritionResponse> call = apiService.getTotalNutrition(userId);

        call.enqueue(new Callback<TotalNutritionResponse>() {
            @Override
            public void onResponse(Call<TotalNutritionResponse> call, Response<TotalNutritionResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    TotalNutritionResponse.NutritionData nutritionData = response.body().getData();
                    pbCalories.setMax((int) nutritionData.getDailyCalorie());
                    pbCarbo.setMax((int) nutritionData.getDailyCarbohydrate());
                    pbProtein.setMax((int) nutritionData.getDailyProtein());
                    pbFat.setMax((int) nutritionData.getDailyFat());
                    pbSugar.setMax((int) nutritionData.getDailySugar());

                    txtTotalCalorie.setText(String.valueOf(nutritionData.getDailyCalorie()) + "kkal");
                    txtTotalCarbo.setText(String.valueOf(nutritionData.getDailyCarbohydrate())+ "g");
                    txtTotalProtein.setText(String.valueOf(nutritionData.getDailyProtein())+ "g");
                    txtTotalFat.setText(String.valueOf(nutritionData.getDailyFat())+ "kkal");
                    txtTotalSugar.setText(String.valueOf(nutritionData.getDailySugar())+ "g");
                } else {
                    Toast.makeText(getActivity(), "Failed to retrieve nutrition information", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TotalNutritionResponse> call, Throwable t) {
                Log.e("HomeFragment", "onFailure: " + t.getMessage());
                Toast.makeText(getActivity(), "Request failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getProgress() {
        String userId = "5fb3aa47-f976-4781-9c95-a6e65e8d9194";
        ApiService apiService = RetrofitClient.getApiService();
        Call<ProgressNutritionResponse> call = apiService.getProgressNutrition(userId);

        call.enqueue(new Callback<ProgressNutritionResponse>() {
            @Override
            public void onResponse(Call<ProgressNutritionResponse> call, Response<ProgressNutritionResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ProgressNutritionResponse.ProgressData progressData = response.body().getData();
                    animateProgressBar(pbCalories, pbCalories.getProgress(), (int) progressData.getTotalCalories());
                    animateProgressBar(pbCarbo, pbCarbo.getProgress(), (int) progressData.getTotalCarbohydrate());
                    animateProgressBar(pbProtein, pbProtein.getProgress(), (int) progressData.getTotalProtein());
                    animateProgressBar(pbFat, pbFat.getProgress(), (int) progressData.getTotalFat());
                    animateProgressBar(pbSugar, pbSugar.getProgress(), (int) progressData.getTotalSugar());

                    txtProgresCalorie.setText(String.valueOf(progressData.getTotalCalories()) + "/");
                    txtProgresCarbo.setText(String.valueOf(progressData.getTotalCarbohydrate())+ "/");
                    txtProgresProtein.setText(String.valueOf(progressData.getTotalProtein())+ "/");
                    txtProgresFat.setText(String.valueOf(progressData.getTotalFat())+ "/");
                    txtProgresSugar.setText(String.valueOf(progressData.getTotalSugar())+ "/");
                } else {
                    Toast.makeText(getActivity(), "Failed to retrieve nutrition information", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ProgressNutritionResponse> call, Throwable t) {
                Log.e("HomeFragment", "onFailure: " + t.getMessage());
                Toast.makeText(getActivity(), "Request failed", Toast.LENGTH_SHORT).show();
            }
        });
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
    private void animateProgressBar(ProgressBar progressBar, int currentProgress, int newProgress) {
        ObjectAnimator progressAnimator = ObjectAnimator.ofInt(progressBar, "progress", currentProgress, newProgress);
        progressAnimator.setDuration(10000); // Durasi animasi dalam milidetik
        progressAnimator.start();
    }
}
