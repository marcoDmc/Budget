package com.example.budget.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator {

    public static boolean isValidName(String name) {
        if (name == null) return  false;
        String regex = "^(?!.*([a-zA-Z])\\1{2,})[A-Za-z]+(?: [A-Za-z]+)?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

}
