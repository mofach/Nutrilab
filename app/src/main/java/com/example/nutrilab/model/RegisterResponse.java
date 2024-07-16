package com.example.nutrilab.model;

public class RegisterResponse {
    private int status;
    private String message;
    private DataRegister data;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public DataRegister getData() {
        return data;
    }

    public class DataRegister {
        private String id;
        private String name;
        private String email;
        private String password;
        private String role;

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public String getRole() {
            return role;
        }
    }
}
