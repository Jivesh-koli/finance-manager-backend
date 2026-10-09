package com.jivesh.demo.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterRequest {
    @NotBlank
    private String name;
    @NotBlank @Email
    private String email;
    @NotBlank @Size(min = 8) private String password;


    //getter
    public @NotBlank String getName() {
        return name;
    }

    public @NotBlank @Email String getEmail() {
        return email;
    }

    public @NotBlank @Size(min = 8) String getPassword() {
        return password;
    }


   //Setters
    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public void setEmail(@NotBlank @Email String email) {
        this.email = email;
    }

    public void setPassword(@NotBlank @Size(min = 8) String password) {
        this.password = password;
    }


}