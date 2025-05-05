package com.example.budget.controllers.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.budget.model.User;
import com.example.budget.services.UserServices;

@RestController
@RequestMapping("/v1")
public class UserController {

    private final UserServices userService;

    public UserController(UserServices userService) {
        this.userService = userService;
    }
    @PostMapping("/user/create")
    public ResponseEntity<?> createUser(@RequestBody User data) {
        UserServices userService = new UserServices();
        return this.userService.create(data);

    }
}
