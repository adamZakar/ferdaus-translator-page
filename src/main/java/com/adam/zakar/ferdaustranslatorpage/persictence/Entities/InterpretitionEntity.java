package com.adam.zakar.ferdaustranslatorpage.persictence.Entities;


import com.adam.zakar.ferdaustranslatorpage.service.InterpretitionPage.Order;
import com.adam.zakar.ferdaustranslatorpage.service.Languages;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class InterpretitionEntity {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    private String email;

    private Languages firstLanguage;
    private Languages secondLanguage;
    private LocalDateTime received;
    private String description;
    private String file;

    private Languages pageLang;

    public InterpretitionEntity(String name, String email, Languages firstLanguage, Languages secondLanguage, LocalDateTime received, String description, Languages pageLang) {
        this.name = name;
        this.email = email;
        this.firstLanguage = firstLanguage;
        this.secondLanguage = secondLanguage;
        this.received = received;
        this.description = description;
        this.pageLang = pageLang;
    }

    public InterpretitionEntity(Order order, Languages languages){
        this.name = order.getName();
        this.email = order.getEmail();
        this.firstLanguage = order.getFirstLanguage();
        this.secondLanguage = order.getSecondLanguage();
        this.received = LocalDateTime.now();
        this.description = order.getDescription();
        this.pageLang = languages;
    }

    public InterpretitionEntity() {
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

    public Languages getFirstLanguage() {
        return firstLanguage;
    }

    public void setFirstLanguage(String firstLanguage) {
        this.firstLanguage=Languages.valueOf(firstLanguage);
    }

    public Languages getSecondLanguage() {
        return secondLanguage;
    }

    public void setSecondLanguage(String secondLanguage) {
        this.secondLanguage = Languages.valueOf(secondLanguage);
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
