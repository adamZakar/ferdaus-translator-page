package com.adam.zakar.ferdaustranslatorpage.service.ContactPage;

import com.adam.zakar.ferdaustranslatorpage.service.Languages;

/**
 * Created by Ádám on 2017. 09. 17..
 */
public interface ContactService {

    boolean contactRequestHandler(Contact contact, Languages lang);

}
