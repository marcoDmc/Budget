package com.example.budget.controllers.user;

import com.example.budget.dtos.DeleteUserDTO;
import com.example.budget.dtos.ForgotPasswordDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return userService.create(data);

    }

    @PostMapping("/user/forgot/password")
    public ResponseEntity<?> forgotPassword(@RequestBody ForgotPasswordDTO data) {
       return userService.forgotPassword(data);
    }


    @DeleteMapping("/user/delete")
    public ResponseEntity<?> deleteUser(@RequestBody DeleteUserDTO data) {
        return userService.deleteUser(data);
    }
}
