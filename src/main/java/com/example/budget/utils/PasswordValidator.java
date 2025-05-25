package com.example.budget.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

    @Autowired
    private static PasswordEncoder passwordEncoder;

    public static boolean isValidPassword(String password) {
        if (password == null) return  false;
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    public static boolean emptyPassword(String password){
        return password == null || password.isEmpty();
    }
}
