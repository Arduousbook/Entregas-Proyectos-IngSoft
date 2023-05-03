package com.javeriana.Study_With_Me.model.User_model;

public class User_login {
    public static int login(String email_arg, String password) {
        int flag = 0;
        //flag = 0: no se encontro el nombre
        //flag = 1: no coincide la contraseña
        //flag = 2: el nombre y contraseña coinciden
        for (User user : User_cache.users) {
            if (user.email.equals(email_arg)) {
                flag = 1;
                if (user.authenticate(password)) {
                    flag = 2;
                    User_cache.setCurrentUser(user);
                }
            }
        }

        return flag;

    }
}
