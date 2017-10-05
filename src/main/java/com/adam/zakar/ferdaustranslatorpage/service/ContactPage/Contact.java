package com.adam.zakar.ferdaustranslatorpage.service.ContactPage;

import com.adam.zakar.ferdaustranslatorpage.service.Languages;

/**
 * Created by Ádám on 2017. 09. 28..
 */
public interface Contact {

    String getName();

    void setName(String name);

    String getEmail();

    void setEmail(String email);

    String getSubject();

    void setSubject(String subject);

    String getMessage();

    void setMessage(String message);

    Languages getLang();

    void setLang(String lang);

}
