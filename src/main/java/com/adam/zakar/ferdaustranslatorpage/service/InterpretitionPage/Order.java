package com.adam.zakar.ferdaustranslatorpage.service.InterpretitionPage;

import com.adam.zakar.ferdaustranslatorpage.service.Languages;

public interface Order {

     String getName();

    void setName(String name);

    String getEmail();

     void setEmail(String email);

    Languages getFirstLanguage();

    void setFirstLanguage(String firstLanguage);

    Languages getSecondLanguage();

    void setSecondLanguage(String secondLanguage);

    String getDescription();

    void setDescription(String description);

    String getFile();

    void setFile(String file);


}
