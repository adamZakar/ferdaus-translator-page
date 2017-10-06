package com.adam.zakar.ferdaustranslatorpage.persictence.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Users {

    @Id
    @GeneratedValue
    private int id;

    private Date registered;

    private String userName;
    private String email;
    private String password;
    private Priviliege priviliege;

    public Users() {
    }

    public Users(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Priviliege getPriviliege() {
        return priviliege;
    }

    public void setPriviliege(Priviliege priviliege) {
        this.priviliege = priviliege;
    }

    @Override
    public boolean equals(Object users) {
        return userName.equals(((Users)users).getUserName());
    }
}
