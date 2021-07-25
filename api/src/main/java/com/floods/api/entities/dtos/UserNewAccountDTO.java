package com.floods.api.entities.dtos;

public class UserNewAccountDTO {
    private String email;
    private String password;

    public UserNewAccountDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserNewAccountDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
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

    public void setPassword(String password) {
        this.password = password;
    }
}
