package com.example.budget.dtos;

import com.example.budget.interfaces.IDeleteUser;

public class DeleteUserDTO implements IDeleteUser {
    private String email;
    private String password;


    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
