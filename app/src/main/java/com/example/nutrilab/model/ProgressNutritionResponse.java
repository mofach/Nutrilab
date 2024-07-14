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
        private int totalCalories;
        private int totalCarbohydrate;
        private int totalProtein;
        private int totalFat;
        private int totalSugar;

        public int getTotalCalories() {
            return totalCalories;
        }

        public int getTotalCarbohydrate() {
            return totalCarbohydrate;
        }

        public int getTotalProtein() {
            return totalProtein;
        }

        public int getTotalFat() {
            return totalFat;
        }

        public int getTotalSugar() {
            return totalSugar;
        }
    }
}
