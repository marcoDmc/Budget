package com.example.budget.interfaces.account;

import com.example.budget.model.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface ICreateAccount {
    String getName();
    String getType();
    String getEmail();
    String getCategoryName();
    boolean getIncome();
    BigDecimal getAmount();
    LocalDateTime getDate();
    String getDescription();
    String getPaymentType();
    Boolean getIsRecurring();
}
