package com.adam.zakar.ferdaustranslatorpage;

import com.adam.zakar.ferdaustranslatorpage.service.Languages;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LanguagesTest {

    @Test
    public void getCountryTest(){
        Languages language= Languages.valueOf("ENG");
        assertEquals(language.getCountry(),"EN");
        assertEquals(language.getLocale(),"en");
    }
}
