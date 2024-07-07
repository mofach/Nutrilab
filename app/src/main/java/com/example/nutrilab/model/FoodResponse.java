package com.example.nutrilab.model;

public class FoodResponse {
    private int status;
    private String message;
    private FoodData data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public FoodData getData() {
        return data;
    }

    public void setData(FoodData data) {
        this.data = data;
    }

    public class FoodData {
        private String foodName;
        private String foodInformation;
        private String calorie;
        private String sugar;
        private String carbohydrate;
        private String fat;
        private String protein;

        public String getFoodName() {
            return foodName;
        }

        public void setFoodName(String foodName) {
            this.foodName = foodName;
        }

        public String getFoodInformation() {
            return foodInformation;
        }

        public void setFoodInformation(String foodInformation) {
            this.foodInformation = foodInformation;
        }

        public String getCalorie() {
            return calorie;
        }

        public void setCalorie(String calorie) {
            this.calorie = calorie;
        }

        public String getSugar() {
            return sugar;
        }

        public void setSugar(String sugar) {
            this.sugar = sugar;
        }

        public String getCarbohydrate() {
            return carbohydrate;
        }

        public void setCarbohydrate(String carbohydrate) {
            this.carbohydrate = carbohydrate;
        }

        public String getFat() {
            return fat;
        }

        public void setFat(String fat) {
            this.fat = fat;
        }

        public String getProtein() {
            return protein;
        }

        public void setProtein(String protein) {
            this.protein = protein;
        }
    }
}
