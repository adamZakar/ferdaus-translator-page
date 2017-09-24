package com.adam.zakar.ferdaustranslatorpage.service;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class WelcomeService implements GenericWelcomeService {

    private static Logger LOG = LoggerFactory.getLogger(WelcomeService.class);

    private static ResourceBundle resourceBundle;
    private String DICTIONARY = "dictionary";
    private String BELONGSTOALLPAGE = "all";

    public WelcomeService() {
        this.resourceBundle = ResourceBundle.getBundle(DICTIONARY);
    }

    @Override
    public void setResourceBundle(String lang) {
        if (lang == null) {
            this.resourceBundle = ResourceBundle.getBundle(DICTIONARY);
            return;
        }

        switch (lang) {
            case "en":
                resourceBundle = ResourceBundle.getBundle(DICTIONARY, new Locale("en", "EN"));
                break;
            case "pa":
                resourceBundle = ResourceBundle.getBundle(DICTIONARY, new Locale("pa", "PA"));
                break;
            case "ur":
                resourceBundle = ResourceBundle.getBundle(DICTIONARY, new Locale("ur", "UR"));
                break;
            case "pe":
                resourceBundle = ResourceBundle.getBundle(DICTIONARY, new Locale("pe", "PE"));
                break;
        }


    }

    @Override
    public String getName(String key) {
        String returnValue = resourceBundle.getString(key);
        if (returnValue != null) {
            LOG.info("Key: " + key + " has been found with value: " + returnValue);
            return returnValue;
        } else {
            throw new IllegalArgumentException("Inappropriate key");
        }
    }

    @Override
    public Map<String, String> getInnerTexts(String page) {
        Set<String> keys = resourceBundle.keySet();
        Map<String, String> innerTexts = new HashMap();
        for (String key : keys) {
            if (key.contains(page) || key.contains(BELONGSTOALLPAGE)) {
                String inputKey = key.replace((page + "."), "").replace((BELONGSTOALLPAGE + "."), "");
                innerTexts.put(inputKey, resourceBundle.getString(key));
            }
        }
        LOG.info(innerTexts.size() + " number of elements has been added to the html.");
        return innerTexts;
    }
}
