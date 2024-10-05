package Pengguna;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class User {
    String username, password;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
    }

    public boolean login(String inputUser, String inputPass) {
        return this.username.equals(inputUser) && this.password.equals(inputPass);
    }
}
