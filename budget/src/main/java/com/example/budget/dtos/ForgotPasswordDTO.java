package com.example.budget.dtos;

import com.example.budget.interfaces.IForgotPassword;

public class ForgotPasswordDTO implements IForgotPassword {
    private String email;
    private String password;
    private String newPassword;


    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getNewPassword() {
        return newPassword;
    }
}
