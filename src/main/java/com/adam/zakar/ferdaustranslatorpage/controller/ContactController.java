package com.adam.zakar.ferdaustranslatorpage.controller;

import com.adam.zakar.ferdaustranslatorpage.service.ContactImpl;
import com.adam.zakar.ferdaustranslatorpage.service.ContactService;
import com.adam.zakar.ferdaustranslatorpage.service.Dictionary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Ádám on 2017. 09. 17..
 */
@Controller
@RequestMapping(value = "/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;


    private static Logger LOG = LoggerFactory.getLogger(ContactController.class);

    @RequestMapping
    public String getContactPage(@RequestParam(value = "lang",required =false) String lang, Model model) {
        LOG.info("Contact has been called param:" +lang);
        model.addAllAttributes(Dictionary.getPageTexts("contact",lang));
        return "contactPage";
    }



    @RequestMapping(value = "/submitContact", method = RequestMethod.POST)
    public @ResponseBody String addNewWork(@Valid ContactImpl contact, BindingResult result, @RequestParam(value="lang", required = false) String lang) {
        if (result.hasErrors()) {
            return result.getFieldErrors().get(0).getDefaultMessage();
        }

        if (contactService.contactRequestHandler(contact, lang)) {
            return "success";
        }
        return "Problem has occured please try again later";
    }

}
