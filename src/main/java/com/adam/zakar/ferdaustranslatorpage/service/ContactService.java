package com.adam.zakar.ferdaustranslatorpage.service;

import java.util.List;

/**
 * Created by Ádám on 2017. 09. 17..
 */
public interface ContactService {

    boolean contactRequestHandler();
    boolean sendEmail(List<String> addresses, String text, String lang);

}
