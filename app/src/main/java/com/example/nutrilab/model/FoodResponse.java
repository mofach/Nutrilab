package com.example.nutrilab.model;

public class FoodResponse {
    private int status;
    private String message;
    private FoodData data;

    public int getStatus() {
        return status;
    }
    public String getMessage() {
        return message;
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

        public ProgressNutrition getProgressNutrition() {
            return progressNutrition;
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

            public String getFoodInformation() {
                return foodInformation;
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

        public class ProgressNutrition {
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
}
