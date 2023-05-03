package com.javeriana.Study_With_Me.model.User_model;

import org.mindrot.jbcrypt.BCrypt;
import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    protected String email;
    protected String hash_password;
    protected Profile profile;

    protected User() {
        this.profile = new Profile();
    }
    protected User(String email, String password) {
        this.email = email;
        this.hash_password = BCrypt.hashpw(password, BCrypt.gensalt());
        this.profile = new Profile();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHash_password(String password) {
        this.hash_password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public Profile getProfile() {
        return profile;
    }

    protected boolean authenticate(String password) {
        return BCrypt.checkpw(password, this.hash_password);
    }
}


