package com.example.nutrilab.model;

public class ProgressNutritionResponse {
    private int status;
    private String message;
    private ProgressData data;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public ProgressData getData() {
        return data;
    }

    public class ProgressData {
        private float totalCalories;
        private float totalCarbohydrate;
        private float totalProtein;
        private float totalFat;
        private float totalSugar;

        public float getTotalCalories() {
            return totalCalories;
        }

        public float getTotalCarbohydrate() {
            return totalCarbohydrate;
        }

        public float getTotalProtein() {
            return totalProtein;
        }

        public float getTotalFat() {
            return totalFat;
        }

        public float getTotalSugar() {
            return totalSugar;
        }
    }
}
