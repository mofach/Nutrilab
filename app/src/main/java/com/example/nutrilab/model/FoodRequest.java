package com.example.nutrilab.model;

public class FoodRequest {
    private String foodName;

    public FoodRequest(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
