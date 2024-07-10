package com.example.nutrilab.model;

import java.util.Map;

public class FoodRecomendation {
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

    public static class Data {
        private FoodData food1;
        private FoodData food2;
        private FoodData food3;

        public FoodData getFood1() {
            return food1;
        }

        public FoodData getFood2() {
            return food2;
        }

        public FoodData getFood3() {
            return food3;
        }
    }

    public static class FoodData {
        private String foodName;
        private String information;
        private String calorie;
        private String sugar;
        private String carbohydrate;
        private String fat;
        private String protein;

        public String getFoodName() {
            return foodName;
        }

        public String getInformation() {
            return information;
        }

        public String getCalorie() {
            return calorie;
        }

        public String getSugar() {
            return sugar;
        }

        public String getCarbohydrate() {
            return carbohydrate;
        }

        public String getFat() {
            return fat;
        }

        public String getProtein() {
            return protein;
        }
    }
}
