package com.example.nutrilab;

import com.example.nutrilab.model.FoodRequest;
import com.example.nutrilab.model.FoodResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("/food/nutrition")
    Call<FoodResponse> trackFood(@Body FoodRequest foodRequest);
}
