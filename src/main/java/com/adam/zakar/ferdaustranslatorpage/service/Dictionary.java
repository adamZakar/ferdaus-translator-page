package com.adam.zakar.ferdaustranslatorpage.service;

import java.util.*;

/**
 * Created by Ádám on 2017. 09. 28..
 */
public class Dictionary {


    private static String DICTIONARY = "dictionary";
    private static String BELONGSTOALLPAGE = "all";


    private static ResourceBundle setResourceBundle(String lang) {
        ResourceBundle resourceBundle=null;
        if (lang == null) {
            resourceBundle = ResourceBundle.getBundle(DICTIONARY);
            return resourceBundle;
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
        return resourceBundle;
    }


    public static Map<String, String> getPageTexts(String page, String lang) {
      ResourceBundle  resourceBundle = setResourceBundle(lang);
        Set<String> keys = resourceBundle.keySet();
        Map<String, String> innerTexts = new HashMap();
        for (String key : keys) {
            if (key.contains(page) || key.contains(BELONGSTOALLPAGE)) {
                String inputKey = key.replace((page + "."), "").replace((BELONGSTOALLPAGE + "."), "");
                innerTexts.put(inputKey, resourceBundle.getString(key));
            }
        }

        return innerTexts;
    }


    public static String getText(String key, String lang){
        return setResourceBundle(lang).getString(key);
    }

}
