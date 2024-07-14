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
        private int dailyCalorie;
        private int dailyProtein;
        private int dailyFat;
        private int dailyCarbohydrate;
        private int dailySugar;

        public int getDailyCalorie() {
            return dailyCalorie;
        }

        public int getDailyProtein() {
            return dailyProtein;
        }

        public int getDailyFat() {
            return dailyFat;
        }

        public int getDailyCarbohydrate() {
            return dailyCarbohydrate;
        }

        public int getDailySugar() {
            return dailySugar;
        }
    }
}
