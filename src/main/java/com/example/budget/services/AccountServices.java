package com.example.budget.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.budget.dtos.account.CreateAccountDTO;
import com.example.budget.dtos.account.DeleteAllAccountDTO;
import com.example.budget.model.Account;
import com.example.budget.model.Category;
import com.example.budget.model.Transaction;
import com.example.budget.model.User;
import com.example.budget.repository.AccountRepository;
import com.example.budget.repository.CategoryRepository;
import com.example.budget.repository.TransactionRepository;
import com.example.budget.repository.UserRepository;
import com.example.budget.utils.AccountValidator;

@Service
public class AccountServices {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public AccountServices(AccountRepository accountRepository, UserRepository userRepository,
                           CategoryRepository categoryRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public ResponseEntity<?> createAccount(CreateAccountDTO data)
    {
        try {
            AccountValidator validator = new AccountValidator();
            boolean credentials = validator.ValidateCredentialsForCreateAccountIsEmpty(data);

            if (!credentials) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid credentials");
            }

            User findUser = userRepository.findByEmail(data.getEmail());
            if (findUser == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid user credentials");
            }

            Category newCategory = new Category();
            newCategory.setName(data.getCategoryName());
            newCategory.setIsIncome(data.getIncome());
            newCategory.setUser(findUser);
            newCategory = categoryRepository.save(newCategory);

            Account newAccount = new Account();
            newAccount.setName(data.getName());
            newAccount.setType(data.getType());
            newAccount.setUser(findUser);
            newAccount.setCategory(newCategory);
            newAccount = accountRepository.save(newAccount);

            Transaction newTransaction = new Transaction();
            newTransaction.setAmount(data.getAmount());
            newTransaction.setDescription(data.getDescription());
            newTransaction.setPaymentType(data.getPaymentType());
            newTransaction.setIsRecurring(data.getIsRecurring());
            newTransaction.setAccount(newAccount);
            newTransaction.setCategory(newCategory);
            transactionRepository.save(newTransaction);

            return ResponseEntity.status(HttpStatus.CREATED).body("Account created successfully.");

        } catch (Exception e) {
            System.err.println("Error creating account: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to create account. Please try again.");
        }
    }

    @Transactional
    public ResponseEntity<?> deleteAllAccount(DeleteAllAccountDTO data){
        AccountValidator validator = new AccountValidator();

        if(!validator.ValidateCredentialsForDeleteAllAccounts(data)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid credentials for delete all accounts");
        }

        User findUser = userRepository.findByEmail(data.getEmail());
        if(findUser == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("something wrong");
        }

        var userAccounts = findUser.getAccounts();
        Long userCategoriesId = findUser.getId();

        accountRepository.deleteAll(userAccounts);
        categoryRepository.deleteById(userCategoriesId);

        findUser.getAccounts().clear();
        findUser.getCategories().clear();

        userRepository.save(findUser);

        return ResponseEntity.status(HttpStatus.OK).body("delete all accounts successfully");
    }
}