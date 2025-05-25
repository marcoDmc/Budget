package com.example.budget.services;

import com.example.budget.dtos.user.DeleteUserDTO;
import com.example.budget.dtos.user.ForgotPasswordDTO;
import com.example.budget.utils.NameValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.budget.model.User;
import com.example.budget.repository.UserRepository;
import com.example.budget.utils.EmailValidator;
import com.example.budget.utils.PasswordValidator;



@Service
public class UserServices {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServices(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public ResponseEntity<?> create(User data) {
        try {

            if (!NameValidator.isValidName(data.getUsername())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid name format");
            } else if (!EmailValidator.isValidEmail(data.getEmail())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid email format");
            } else if (!PasswordValidator.isValidPassword(data.getPassword())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid password format");
            }

            data.setPassword(passwordEncoder.encode(data.getPassword()));

            userRepository.save(data);

            return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while creating the user");
        }
    }
    public ResponseEntity<?> forgotPassword(ForgotPasswordDTO data) {
        if (!EmailValidator.isValidEmail(data.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid email format");
        } else if (PasswordValidator.emptyPassword(data.getPassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid password format");
        } else if (!PasswordValidator.isValidPassword(data.getNewPassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid new password format");
        }

        User findUserWithEmail = userRepository.findByEmail(data.getEmail());

        if (findUserWithEmail == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid credentials");

        boolean isValidPassword = passwordEncoder.matches(data.getPassword(), findUserWithEmail.getPassword());

        if(!isValidPassword) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid credentials");
        else {
            findUserWithEmail.setPassword(passwordEncoder.encode(data.getNewPassword()));
            userRepository.save(findUserWithEmail);
        }

        return ResponseEntity.status(HttpStatus.OK).body("change password successfully");
    }
    public ResponseEntity<?> deleteUser(DeleteUserDTO data) {
        if (!EmailValidator.isValidEmail(data.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid email format");
        } else if (PasswordValidator.emptyPassword(data.getPassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid password format");
        }

        User findUserWithEmail = userRepository.findByEmail(data.getEmail());

        if (findUserWithEmail == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid credentials");

        boolean isValidPassword = passwordEncoder.matches(data.getPassword(), findUserWithEmail.getPassword());

        if(!isValidPassword) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid credentials");
        else userRepository.delete(findUserWithEmail);

        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");
    }
}
