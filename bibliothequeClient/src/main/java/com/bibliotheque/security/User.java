package com.bibliotheque.security;

import org.springframework.stereotype.Component;

@Component
public class User {

    private int id;
    private String prenom;
    private String role = "Role_user";

    public User() {
    }

    public User(int id, String prenom) {
        this.id = id;
        this.prenom = prenom;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
