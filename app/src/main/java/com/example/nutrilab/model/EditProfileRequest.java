package com.example.nutrilab.model;

public class EditProfileRequest {
    private String gender;
    private String dateOfBirth;
    private String allergies;
    private float weight;
    private float height;

    public EditProfileRequest(String gender, String dateOfBirth, String allergies, float weight, float height) {
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.allergies = allergies;
        this.weight = weight;
        this.height = height;
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
