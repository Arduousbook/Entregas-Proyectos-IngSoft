package com.javeriana.Study_With_Me.model.User_model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class User_file_reader {
    public static void read_users_from_file() {

        try (FileInputStream fileIn = new FileInputStream("src/main/java/com/javeriana/Study_With_Me/model/data/Archivo_usuarios.txt");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            while (true) {
                User user = (User) objectIn.readObject();
                User_cache.users.add(user);
            }
        } catch (EOFException e) {
            // EOFException se lanza al final del archivo
        } catch (Exception e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
