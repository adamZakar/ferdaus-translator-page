package com.adam.zakar.ferdaustranslatorpage.persictence.Entities;

import com.adam.zakar.ferdaustranslatorpage.service.ContactPage.Contact;
import com.adam.zakar.ferdaustranslatorpage.service.Languages;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="contact")
public class ContactEntity {

    @Id
    @GeneratedValue
    private int id;


    private Date received;

    private String name;

    private String email;

    private String subject;

    private String message;

    public ContactEntity() {
    }

    private Languages language;

    public Languages getLanguages() {
        return language;
    }

    public void setLanguages(Languages languages) {
        this.language = languages;
    }

    public ContactEntity(Contact contact, Languages language) {
        this.name = contact.getName();
        this.email = contact.getEmail();
        this.subject = contact.getSubject();
        this.message = contact.getMessage();
        this.language=language;
        received= new Date();
    }


    public ContactEntity(String name, String email, String subject, String message,Languages language) {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
        this.language=language;
        received= new Date();
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public String getEmail() {
        return email;
    }



    public String getSubject() {
        return subject;
    }



    public String getMessage() {
        return message;
    }

    public Date getReceived() {
        return received;
    }


    @Override
    public String toString() {
        return "ContactEntity{" +
                "id=" + id +
                ", received=" + received +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
