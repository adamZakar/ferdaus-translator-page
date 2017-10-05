package com.adam.zakar.ferdaustranslatorpage.service.ContactPage;

import com.adam.zakar.ferdaustranslatorpage.service.Languages;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Size;

public class ContactImpl implements Contact{

    @Size(min=5, message = "Invalid name")
    private String name;

    @Email(message = "Please type in valid e-mail address")
    private String email;

    @Size(min=3, message="Please write longer name")
    private String subject;

    @Size(min = 3, message = "Please write longer description")
    private String message;

    public Languages getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = Languages.valueOf(lang);
    }

    private Languages lang;


    public ContactImpl() {
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
