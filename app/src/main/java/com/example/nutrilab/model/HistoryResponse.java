package com.example.nutrilab.model;

import java.util.List;

public class HistoryResponse {
    private int status;
    private String message;
    private List<HistoryData> data;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<HistoryData> getData() {
        return data;
    }

    public class HistoryData {
        private String id;
        private String userId;
        private String foodName;
        private String foodInformation;
        private int totalCalorie;
        private int totalCarbohydrate;
        private int totalSugar;
        private int totalFat;
        private int totalProtein;
        private String date;

        public String getId() {
            return id;
        }

        public String getUserId() {
            return userId;
        }

        public String getFoodName() {
            return foodName;
        }

        public String getFoodInformation() {
            return foodInformation;
        }

        public int getTotalCalorie() {
            return totalCalorie;
        }

        public int getTotalCarbohydrate() {
            return totalCarbohydrate;
        }

        public int getTotalSugar() {
            return totalSugar;
        }

        public int getTotalFat() {
            return totalFat;
        }

        public int getTotalProtein() {
            return totalProtein;
        }

        public String getDate() {
            return date;
        }
    }
}
