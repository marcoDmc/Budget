package com.example.budget.controllers.account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.budget.dtos.account.CreateAccountDTO;
import com.example.budget.dtos.account.DeleteAllAccountDTO;
import com.example.budget.services.AccountServices;

@RestController
@RequestMapping("/v1")
public class AccountController {
    private final AccountServices accountService;

    public AccountController(AccountServices accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/account/create")
    public ResponseEntity<?> createAccount(@RequestBody CreateAccountDTO data) {
        return accountService.createAccount(data);
    }
    
    @DeleteMapping("/account/delete/all")
    public ResponseEntity<?> deleteAllAccount(@RequestBody DeleteAllAccountDTO data){
        return accountService.deleteAllAccount(data);
    }
}
