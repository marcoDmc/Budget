package com.example.budget.dtos.account;

import com.example.budget.interfaces.account.IValidateCredentialsForCreateAccount;

public class ValidateCredentialsForCreateAccount implements IValidateCredentialsForCreateAccount {
    private String name;
    private String balance;
    private String type;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getBalance() {
        return balance;
    }

    @Override
    public String getType() {
        return type;
    }
}
