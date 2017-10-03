package com.adam.zakar.ferdaustranslatorpage.persictence.Entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderEntity {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    private String email;

    private String firstLanguage;
    private String secondLanguage;

    private String description;
    private String file;

    public OrderEntity(String name, String email, String firstLanguage, String secondLanguage, String description) {
        this.name = name;
        this.email = email;
        this.firstLanguage = firstLanguage;
        this.secondLanguage = secondLanguage;
        this.description = description;
    }

    public OrderEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstLanguage() {
        return firstLanguage;
    }

    public void setFirstLanguage(String firstLanguage) {
        this.firstLanguage = firstLanguage;
    }

    public String getSecondLanguage() {
        return secondLanguage;
    }

    public void setSecondLanguage(String secondLanguage) {
        this.secondLanguage = secondLanguage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
