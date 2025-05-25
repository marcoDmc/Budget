package com.example.budget.dtos.account;

import com.example.budget.interfaces.account.IDeleteAllAccount;

public class  DeleteAllAccountDTO implements IDeleteAllAccount {
    private String email;

    @Override
    public String getEmail() {
        return email;
    }
}
