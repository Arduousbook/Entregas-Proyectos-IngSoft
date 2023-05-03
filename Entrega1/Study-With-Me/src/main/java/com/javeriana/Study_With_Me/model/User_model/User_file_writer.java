package com.javeriana.Study_With_Me.model.User_model;

import java.io.*;
import java.util.ArrayList;

public class User_file_writer {
    public static void write_user_to_file() {
        try (FileOutputStream fileOut = new FileOutputStream("src/main/java/com/javeriana/Study_With_Me/model/data/Archivo_usuarios.txt");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            User_cache.users.add(User_cache.getCurrentUser());
            for (User user : User_cache.users) {
                objectOut.writeObject(user);
            }
        } catch (Exception e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}