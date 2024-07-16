package com.example.nutrilab.model;

public class CreateProfileResponse {
    private int status;
    private String message;
    private Data data;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Data getData() {
        return data;
    }

    public class Data {
        private ProfileData profile;
        private DailyNutritionData dailyNutrition;

        public ProfileData getProfile() {
            return profile;
        }

        public DailyNutritionData getDailyNutrition() {
            return dailyNutrition;
        }
    }

    public class ProfileData {
        private String id;
        private String userId;
        private String gender;
        private String dateOfBirth;
        private String allergies;
        private float weight;
        private float height;

        public String getId() {
            return id;
        }

        public String getUserId() {
            return userId;
        }

        public String getGender() {
            return gender;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public String getAllergies() {
            return allergies;
        }

        public float getWeight() {
            return weight;
        }

        public float getHeight() {
            return height;
        }
    }
    public class DailyNutritionData{
        private String id;
        private String userId;
        private double dailyCalorie;
        private double dailyCarbohydrate;
        private double dailySugar;
        private double dailyFat;
        private double dailyProtein;

        public String getId() {
            return id;
        }

        public String getUserId() {
            return userId;
        }

        public double getDailyCalorie() {
            return dailyCalorie;
        }

        public double getDailyCarbohydrate() {
            return dailyCarbohydrate;
        }

        public double getDailySugar() {
            return dailySugar;
        }

        public double getDailyFat() {
            return dailyFat;
        }

        public double getDailyProtein() {
            return dailyProtein;
        }
    }
}
