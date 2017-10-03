package com.adam.zakar.ferdaustranslatorpage.persictence.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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


    public ContactEntity(String name, String email, String subject, String message) {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
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
