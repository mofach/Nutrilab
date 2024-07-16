package com.example.nutrilab.model;

public class CreateProfileRequest {
    private String userId;
    private String gender;
    private String dateOfBirth;
    private String allergies;
    private float weight;
    private float height;

    public CreateProfileRequest(String userId, String gender, String dateOfBirth, String allergies, float weight, float height) {
        this.userId = userId;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.allergies = allergies;
        this.weight = weight;
        this.height = height;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
