package com.adam.zakar.ferdaustranslatorpage.service;

import com.adam.zakar.ferdaustranslatorpage.service.ContactPage.ContactImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


public class ContactImpTest {

    @Rule
    public ExpectedException expectedException= ExpectedException.none();

    private static Validator validator;

     @Before
     public void setUp(){
         ValidatorFactory factory= Validation.buildDefaultValidatorFactory();
         validator= factory.getValidator();
     }


    @Test
    public void testEmailValidation(){
        ContactImpl contact= new ContactImpl();
       // expectedException.expect(ValidationException.class);
      //  expectedException.expectMessage("Please type in valid e-mail address");
        contact.setEmail("asd");
    }


}
