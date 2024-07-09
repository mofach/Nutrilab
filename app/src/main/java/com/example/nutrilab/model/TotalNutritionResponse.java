package com.example.nutrilab.model;

public class TotalNutritionResponse {
    private int status;
    private String message;
    private NutritionData data;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public NutritionData getData() {
        return data;
    }

    public class NutritionData {
        private float dailyCalorie;
        private float dailyProtein;
        private float dailyFat;
        private float dailyCarbohydrate;
        private float dailySugar;

        public float getDailyCalorie() {
            return dailyCalorie;
        }

        public float getDailyProtein() {
            return dailyProtein;
        }

        public float getDailyFat() {
            return dailyFat;
        }

        public float getDailyCarbohydrate() {
            return dailyCarbohydrate;
        }

        public float getDailySugar() {
            return dailySugar;
        }
    }
}
