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
        private FoodInfo foodInfo;
        private ProgressNutrition progressNutrition;

        public FoodInfo getFoodInfo() {
            return foodInfo;
        }

        public void setFoodInfo(FoodInfo foodInfo) {
            this.foodInfo = foodInfo;
        }

        public ProgressNutrition getProgressNutrition() {
            return progressNutrition;
        }

        public void setProgressNutrition(ProgressNutrition progressNutrition) {
            this.progressNutrition = progressNutrition;
        }

        public class FoodInfo {
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

        public class ProgressNutrition {
            private int totalCalories;
            private int totalCarbohydrate;
            private int totalProtein;
            private int totalFat;
            private int totalSugar;

            public int getTotalCalories() {
                return totalCalories;
            }

            public void setTotalCalories(int totalCalories) {
                this.totalCalories = totalCalories;
            }

            public int getTotalCarbohydrate() {
                return totalCarbohydrate;
            }

            public void setTotalCarbohydrate(int totalCarbohydrate) {
                this.totalCarbohydrate = totalCarbohydrate;
            }

            public int getTotalProtein() {
                return totalProtein;
            }

            public void setTotalProtein(int totalProtein) {
                this.totalProtein = totalProtein;
            }

            public int getTotalFat() {
                return totalFat;
            }

            public void setTotalFat(int totalFat) {
                this.totalFat = totalFat;
            }

            public int getTotalSugar() {
                return totalSugar;
            }

            public void setTotalSugar(int totalSugar) {
                this.totalSugar = totalSugar;
            }
        }
    }
}
