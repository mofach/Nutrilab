package com.example.nutrilab;

import com.example.nutrilab.model.FoodRecomendation;
import com.example.nutrilab.model.FoodRequest;
import com.example.nutrilab.model.FoodResponse;
import com.example.nutrilab.model.HistoryResponse;
import com.example.nutrilab.model.ProfileResponse;
import com.example.nutrilab.model.ProgressNutritionResponse;
import com.example.nutrilab.model.TotalNutritionResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @POST("/food/nutrition")
    Call<FoodResponse> trackFood(@Body FoodRequest foodRequest);

    @GET("/profile/nutrition/{userId}")
    Call<TotalNutritionResponse> getTotalNutrition(@Path("userId") String userId);

    @GET("/profile/nutrition/progress/{userId}")
    Call<ProgressNutritionResponse> getProgressNutrition(@Path("userId") String userId);

    @GET("/profile/{userId}")
    Call<ProfileResponse> getProfileUser(@Path("userId") String userId);

    @GET("/food/recommendation/{userId}")
    Call<FoodRecomendation> getRecommendation(@Path("userId") String userId);

    @GET("/history/{userId}")
    Call<HistoryResponse> getUserHistory(@Path("userId") String userId);
}
