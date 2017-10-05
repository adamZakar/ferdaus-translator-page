package com.adam.zakar.ferdaustranslatorpage.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DictionaryTest {

    @Test
    public void testgetText(){
        assertEquals("FORDÍTÓ", Dictionary.getText("home.translator",null));
        assertEquals("SZOLGÁLTATÁSOK", Dictionary.getText("all.services",null));
        assertEquals("TRANSLATOR", Dictionary.getText("home.translator",Languages.ENG));
        assertEquals("SERVICES", Dictionary.getText("all.services", Languages.ENG));
    }

    @Test
    public void testGetPageTest(){
        assertEquals(Dictionary.getPageTexts("home",Languages.HUN).size()
                ,Dictionary.getPageTexts("home",Languages.ENG).size());
        assertTrue(Dictionary.getPageTexts("home",Languages.ENG).containsKey("inquiry"));
        assertTrue(Dictionary.getPageTexts("home",Languages.HUN).containsKey("about_me"));
        assertEquals("ABOUT ME",Dictionary.getPageTexts("home",Languages.ENG).get("about_me"));
        assertEquals("RÓLAM",Dictionary.getPageTexts("home",Languages.HUN).get("about_me"));
    }
}
