package com.example.nutrilab.model;

public class FoodRequest {
    private String foodName;
    private String userId;

    public FoodRequest(String foodName, String userId) {
        this.foodName = foodName;
        this.userId = userId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
