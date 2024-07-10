package com.example.nutrilab.model;

public class ProfileResponse {
    private int status;
    private  String message;
    private ProfileData data;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public ProfileData getData() {
        return data;
    }

    public class ProfileData {
        private String id;
        private String userId;
        private String gender;
        private String dateOfBirth;
        private String allergies;
        private int weight;
        private int height;
        private ProfileUser user;

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

        public int getWeight() {
            return weight;
        }

        public int getHeight() {
            return height;
        }

        public ProfileUser getUser() {
            return user;
        }

        public class ProfileUser {
            private String name;
            private String email;
            public String getName() {
                return name;
            }
            public String getEmail() {
                return email;
            }
        }
    }
}
