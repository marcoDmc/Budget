package com.example.budget.utils;

import com.example.budget.dtos.account.CreateAccountDTO;

public class AccountValidator {
    public boolean ValidateCredentialsForCreateAccountIsEmpty(CreateAccountDTO data) {

        if(data.getName() == null
                || data.getType() == null
                || data.getEmail() == null
                || data.getCategoryName() == null
                ) return false;
        else return true;
    }
}