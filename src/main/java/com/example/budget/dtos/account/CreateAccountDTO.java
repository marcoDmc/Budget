package com.example.budget.dtos.account;

import com.example.budget.interfaces.account.ICreateAccount;
import com.example.budget.model.Transaction;
import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreateAccountDTO implements ICreateAccount {
    private String name;
    private String email;
    private String type;
    private String categoryName;
    private boolean income;
    private BigDecimal amount;
    private LocalDateTime date;
    private String description;
    private String paymentType;
    private Boolean isRecurring;

    @Override
    public String getName() {
        return name;
    }


    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public boolean getIncome() {
        return income;
    }

    @Override
    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getPaymentType() {
        return paymentType;
    }

    @Override
    public Boolean getIsRecurring() {
        return isRecurring;
    }
}
