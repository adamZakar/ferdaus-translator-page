package com.adam.zakar.ferdaustranslatorpage.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DictionaryTest {

    @Test
    public void testgetText(){
        assertEquals("FORDÍTÓ", Dictionary.getText("home.translator",null));
        assertEquals("SZOLGÁLTATÁSOK", Dictionary.getText("all.services",null));
        assertEquals("TRANSLATOR", Dictionary.getText("home.translator","en"));
        assertEquals("SERVICES", Dictionary.getText("all.services", "en"));
    }

    @Test
    public void testGetPageTest(){
        assertEquals(Dictionary.getPageTexts("home","hu").size()
                ,Dictionary.getPageTexts("home","en").size());
        assertTrue(Dictionary.getPageTexts("home","en").containsKey("inquiry"));
        assertTrue(Dictionary.getPageTexts("home","hu").containsKey("about_me"));
        assertEquals("ABOUT ME",Dictionary.getPageTexts("home","en").get("about_me"));
        assertEquals("RÓLAM",Dictionary.getPageTexts("home","hu").get("about_me"));
    }
}
