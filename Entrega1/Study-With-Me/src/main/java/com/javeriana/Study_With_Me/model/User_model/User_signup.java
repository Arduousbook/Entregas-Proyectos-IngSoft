package com.javeriana.Study_With_Me.model.User_model;

import java.util.regex.Pattern;

public class User_signup {
    private static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(email).matches();
    }

    private static boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{10,20}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        return pattern.matcher(password).matches();
    }

    private static boolean isDuplicate(String email) {
        for (User user: User_cache.users){
            if (user.email.equals(email)){
                return true;
            }
        }
        return false;
    }

    public static int signup(String email, String password){
        //0: email invalida
        //1: contraseña invalida
        //2: email duplicado
        //3: valido
        if (!isValidEmail(email)){
            return 0;
        }
        if (!isValidPassword(password)){
            return 1;
        }
        if (isDuplicate(email)){
            return 2;
        }
        User_cache.users.add(new User(email, password));
        return 3;
    }
}
