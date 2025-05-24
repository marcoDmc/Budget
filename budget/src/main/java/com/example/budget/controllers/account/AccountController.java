package com.example.budget.controllers.account;
import com.example.budget.dtos.account.CreateAccountDTO;
import com.example.budget.services.AccountServices;
import com.example.budget.services.UserServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
