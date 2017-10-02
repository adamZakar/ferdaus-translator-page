package com.adam.zakar.ferdaustranslatorpage.service.InterpretitionPage;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class OrderImpl implements Order {

    @Size(min=5)
    @NotNull
    private String name;

    @Email
    private String email;

    @Size(max=3,min=3)
    private String firstLanguage;
    @Size(max=3,min=3)
    private String secondLanguage;

    private String description;
    private String file;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getFirstLanguage() {
        return firstLanguage;
    }

    @Override
    public void setFirstLanguage(String firstLanguage) {
        this.firstLanguage = firstLanguage;
    }

    @Override
    public String getSecondLanguage() {
        return secondLanguage;
    }

    @Override
    public void setSecondLanguage(String secondLanguage) {
        this.secondLanguage = secondLanguage;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getFile() {
        return file;
    }

    @Override
    public void setFile(String file) {
        this.file = file;
    }
}
