package com.javeriana.Study_With_Me.model.User_model;

import java.util.ArrayList;

public class User_cache {
    protected static ArrayList<User> users = new ArrayList<>();
    protected static User currentUser = new User ();

    public static void load_user_cache (){
        User_file_reader.read_users_from_file();
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User user){
        currentUser = user;
    }
}
