package com.example.budget.utils;

import com.example.budget.dtos.account.CreateAccountDTO;
import com.example.budget.dtos.account.DeleteAllAccountDTO;

public class AccountValidator {
    public boolean ValidateCredentialsForCreateAccountIsEmpty(CreateAccountDTO data) {

        if(data.getName() == null
                || data.getType() == null
                || data.getEmail() == null
                || data.getCategoryName() == null
                ) return false;
        else return true;
    }
    public boolean ValidateCredentialsForDeleteAllAccounts(DeleteAllAccountDTO data){
        if(data.getEmail() == null) return false;
        return true;
    }
}