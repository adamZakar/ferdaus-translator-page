package com.adam.zakar.ferdaustranslatorpage.controller;

import com.adam.zakar.ferdaustranslatorpage.service.ContactParser;
import com.adam.zakar.ferdaustranslatorpage.service.ContactServiceImpl;
import com.adam.zakar.ferdaustranslatorpage.service.GenericWelcomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ádám on 2017. 09. 17..
 */
@RestController
public class ContactController {

    @Autowired
    private ContactServiceImpl contactService;

    @Autowired
    private GenericWelcomeService welcomeService;

    private static Logger LOG = LoggerFactory.getLogger(ContactController.class);




    @RequestMapping(value ="/contact/submitContact" , method = RequestMethod.POST)
    public @ResponseBody ContactParser addNewWorker(@RequestBody final ContactParser jsonString) {
        LOG.info("JSON has been received: "+jsonString.toString());

        return null;
    }

}
