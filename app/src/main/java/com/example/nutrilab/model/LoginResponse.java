package com.example.nutrilab.model;

public class LoginResponse {
    private int status;
    private String message;
    private DataLogin data;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public DataLogin getData() {
        return data;
    }

    public class DataLogin {
        private String id;
        private String name;
        private String email;
        private String password;
        private String role;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public String getRole() {
            return role;
        }
    }
}
