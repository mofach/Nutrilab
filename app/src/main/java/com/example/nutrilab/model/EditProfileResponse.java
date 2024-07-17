package com.example.nutrilab.model;

public class EditProfileResponse {
    private int status;
    private String message;
    private DataEdit data;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public DataEdit getData() {
        return data;
    }

    public class DataEdit {
        private ProfileEdit profile;
        private NewNutrition newNutrition;

        public ProfileEdit getProfile() {
            return profile;
        }

        public NewNutrition getNewNutrition() {
            return newNutrition;
        }
    }

    public class ProfileEdit {
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

    public class NewNutrition {
        private String id;
        private String userId;
        private float dailyCalorie;
        private float dailyCarbohydrate;
        private float dailySugar;
        private float dailyFat;
        private float dailyProtein;

        public String getId() {
            return id;
        }

        public String getUserId() {
            return userId;
        }

        public float getDailyCalorie() {
            return dailyCalorie;
        }

        public float getDailyCarbohydrate() {
            return dailyCarbohydrate;
        }

        public float getDailySugar() {
            return dailySugar;
        }

        public float getDailyFat() {
            return dailyFat;
        }

        public float getDailyProtein() {
            return dailyProtein;
        }
    }
}
