package com.adam.zakar.ferdaustranslatorpage.service;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * Created by Ádám on 2017. 09. 17..
 */
public class ContactParser {
    private String name;
    private String email;
    private String subject;
    private String message;

//    @JsonView
//    private boolean success;
//
//    @JsonView
//    private String returnString;
//
//    public boolean isSuccess() {
//        return success;
//    }
//
//    public void setSuccess(boolean success) {
//        this.success = success;
//    }
//
//    public String getReturnString() {
//        return returnString;
//    }
//
//    public void setReturnString(String returnString) {
//        this.returnString = returnString;
//    }

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

    @Override
    public String toString() {
        return "ContactParser{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
