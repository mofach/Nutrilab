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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.nutrilab.model.FoodRecomendation;
import com.example.nutrilab.model.FoodRequest;
import com.example.nutrilab.model.FoodResponse;
import com.example.nutrilab.model.ProfileResponse;
import com.example.nutrilab.model.ProgressNutritionResponse;
import com.example.nutrilab.model.TotalNutritionResponse;
import com.google.android.material.imageview.ShapeableImageView;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private EditText editFood;
    private RelativeLayout layoutRekomendasi1, layoutRekomendasi2, layoutRekomendasi3;
    private ShapeableImageView btnSend;
    private ProgressDialog progressDialog;
    private TextView txtProgresCalorie, txtTotalCalorie, txtProgresCarbo, txtTotalCarbo, txtProgresProtein, txtTotalProtein, txtProgresFat, txtTotalFat, txtProgresSugar, txtTotalSugar, txtFullname, txtEmail, txtHeight, txtWeight, rFoodName1, rFoodName2, rFoodName3, rCalorie1, rCalorie2, rCalorie3, rCarbo1, rCarbo2, rCarbo3, rProtein1, rProtein2, rProtein3, rFat1, rFat2, rFat3, rSugar1, rSugar2, rSugar3, rInfo1, rInfo2, rInfo3;
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
        txtFullname = view.findViewById(R.id.fullname);
        txtEmail = view.findViewById(R.id.email);
        txtWeight = view.findViewById(R.id.weight);
        txtHeight = view.findViewById(R.id.height);
        rFoodName1 = view.findViewById(R.id.food_name1);
        rFoodName2 = view.findViewById(R.id.food_name2);
        rFoodName3 = view.findViewById(R.id.food_name3);
        rCalorie1 = view.findViewById(R.id.calories1);
        rCalorie2 = view.findViewById(R.id.calories2);
        rCalorie3 = view.findViewById(R.id.calories3);
        rCarbo1 = view.findViewById(R.id.carbohydrates1);
        rCarbo2 = view.findViewById(R.id.carbohydrates2);
        rCarbo3 = view.findViewById(R.id.carbohydrates3);
        rProtein1 = view.findViewById(R.id.proteins1);
        rProtein2 = view.findViewById(R.id.proteins2);
        rProtein3 = view.findViewById(R.id.proteins3);
        rFat1 = view.findViewById(R.id.fat1);
        rFat2 = view.findViewById(R.id.fat2);
        rFat3 = view.findViewById(R.id.fat3);
        rSugar1 = view.findViewById(R.id.glucose1);
        rSugar2 = view.findViewById(R.id.glucose2);
        rSugar3 = view.findViewById(R.id.glucose3);
        rInfo1 = view.findViewById(R.id.food_info1);
        rInfo2 = view.findViewById(R.id.food_info3);
        rInfo3 = view.findViewById(R.id.food_info3);
        layoutRekomendasi1 = view.findViewById(R.id.layout_rekomendasi1);
        layoutRekomendasi2 = view.findViewById(R.id.layout_rekomendasi2);
        layoutRekomendasi3 = view.findViewById(R.id.layout_rekomendasi3);
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

        layoutRekomendasi1.setOnClickListener(v -> {
            String foodName = rFoodName1.getText().toString();
            String foodInformation = rInfo1.getText().toString();
            String calorie = rCalorie1.getText().toString();
            String sugar = rSugar1.getText().toString();
            String carbohydrate = rCarbo1.getText().toString();
            String fat = rFat1.getText().toString();
            String protein = rProtein1.getText().toString();

            Intent intent = new Intent(getActivity(), DetailActivity.class);
            intent.putExtra("foodName", foodName);
            intent.putExtra("foodInformation", foodInformation);
            intent.putExtra("calorie", calorie);
            intent.putExtra("sugar", sugar);
            intent.putExtra("carbohydrate", carbohydrate);
            intent.putExtra("fat", fat);
            intent.putExtra("protein", protein);

            startActivity(intent);
        });

        layoutRekomendasi2.setOnClickListener(v -> {
            String foodName = rFoodName2.getText().toString();
            String foodInformation = rInfo2.getText().toString();
            String calorie = rCalorie2.getText().toString();
            String sugar = rSugar2.getText().toString();
            String carbohydrate = rCarbo2.getText().toString();
            String fat = rFat2.getText().toString();
            String protein = rProtein2.getText().toString();

            Intent intent = new Intent(getActivity(), DetailActivity.class);
            intent.putExtra("foodName", foodName);
            intent.putExtra("foodInformation", foodInformation);
            intent.putExtra("calorie", calorie);
            intent.putExtra("sugar", sugar);
            intent.putExtra("carbohydrate", carbohydrate);
            intent.putExtra("fat", fat);
            intent.putExtra("protein", protein);

            startActivity(intent);
        });

        layoutRekomendasi3.setOnClickListener(v -> {
            String foodName = rFoodName3.getText().toString();
            String foodInformation = rInfo3.getText().toString();
            String calorie = rCalorie3.getText().toString();
            String sugar = rSugar3.getText().toString();
            String carbohydrate = rCarbo3.getText().toString();
            String fat = rFat3.getText().toString();
            String protein = rProtein3.getText().toString();

            Intent intent = new Intent(getActivity(), DetailActivity.class);
            intent.putExtra("foodName", foodName);
            intent.putExtra("foodInformation", foodInformation);
            intent.putExtra("calorie", calorie);
            intent.putExtra("sugar", sugar);
            intent.putExtra("carbohydrate", carbohydrate);
            intent.putExtra("fat", fat);
            intent.putExtra("protein", protein);

            startActivity(intent);
        });

        getProgress();
        getTotalProgress();
        getProfileUser();
        getRecommendation();

        return view;
    }

    private void getRecommendation() {
        String userId = SharedPrefManager.getInstance(getActivity()).getUserId();
        ApiService apiService = RetrofitClient.getApiService();
        Call<FoodRecomendation> call = apiService.getRecommendation(userId);

        call.enqueue(new Callback<FoodRecomendation>() {
            @Override
            public void onResponse(Call<FoodRecomendation> call, Response<FoodRecomendation> response) {
                if (response.isSuccessful() && response.body() != null) {
                    FoodRecomendation foodRecomendation = response.body();
                    if (foodRecomendation != null && foodRecomendation.getData() != null) {
                        FoodRecomendation.FoodData food1 = foodRecomendation.getData().getFood1();
                        FoodRecomendation.FoodData food2 = foodRecomendation.getData().getFood2();
                        FoodRecomendation.FoodData food3 = foodRecomendation.getData().getFood3();

                        rFoodName1.setText(food1.getFoodName());
                        rCalorie1.setText(food1.getCalorie());
                        rCarbo1.setText(food1.getCarbohydrate());
                        rProtein1.setText(food1.getProtein());
                        rFat1.setText(food1.getFat());
                        rSugar1.setText(food1.getSugar());

                        rFoodName2.setText(food2.getFoodName());
                        rCalorie2.setText(food2.getCalorie());
                        rCarbo2.setText(food2.getCarbohydrate());
                        rProtein2.setText(food2.getProtein());
                        rFat2.setText(food2.getFat());
                        rSugar2.setText(food2.getSugar());

                        rFoodName3.setText(food3.getFoodName());
                        rCalorie3.setText(food3.getCalorie());
                        rCarbo3.setText(food3.getCarbohydrate());
                        rProtein3.setText(food3.getProtein());
                        rFat3.setText(food3.getFat());
                        rSugar3.setText(food3.getSugar());

                        rInfo1.setText(food1.getInformation());
                        rInfo2.setText(food2.getInformation());
                        rInfo3.setText(food3.getInformation());


                    } else {
                        Toast.makeText(getActivity(), "No food recommendations available", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<FoodRecomendation> call, Throwable t) {
                Log.e("HomeFragment", "onFailure: " + t.getMessage());
                Toast.makeText(getActivity(), "Request failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getProfileUser() {
        String userId = SharedPrefManager.getInstance(getActivity()).getUserId();
        ApiService apiService = RetrofitClient.getApiService();
        Call<ProfileResponse> call = apiService.getProfileUser(userId);

        call.enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ProfileResponse.ProfileData profileData = response.body().getData();
                    txtFullname.setText(profileData.getUser().getName());
                    txtEmail.setText(profileData.getUser().getEmail());
                    txtWeight.setText(String.valueOf(profileData.getWeight()));
                    txtHeight.setText(String.valueOf(profileData.getHeight()));

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
            public void onFailure(Call<ProfileResponse> call, Throwable t) {
                Log.e("HomeFragment", "onFailure: " + t.getMessage());
                Toast.makeText(getActivity(), "Request failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        getProgress();
        getTotalProgress();
    }

    private void getTotalProgress() {
        String userId = SharedPrefManager.getInstance(getActivity()).getUserId();
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
                    try {
                        String errorMessage = response.errorBody().string();
                        Toast.makeText(getActivity(), "Error: " + errorMessage, Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        Toast.makeText(getActivity(), "Failed to retrieve food information", Toast.LENGTH_SHORT).show();
                    }
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
        String userId = SharedPrefManager.getInstance(getActivity()).getUserId();
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
                    try {
                        String errorMessage = response.errorBody().string();
                        Toast.makeText(getActivity(), "Error: " + errorMessage, Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        Toast.makeText(getActivity(), "Failed to retrieve food information", Toast.LENGTH_SHORT).show();
                    }
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
        String userId = SharedPrefManager.getInstance(getActivity()).getUserId();
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
                    FoodResponse.FoodData.totalNutritionNeeded progressNutrition = foodData.getTotalNutritionNeeded();

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
