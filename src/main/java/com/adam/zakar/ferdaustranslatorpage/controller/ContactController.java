package com.adam.zakar.ferdaustranslatorpage.controller;

import com.adam.zakar.ferdaustranslatorpage.service.ContactPage.ContactImpl;
import com.adam.zakar.ferdaustranslatorpage.service.ContactPage.ContactService;
import com.adam.zakar.ferdaustranslatorpage.service.Dictionary;
import com.adam.zakar.ferdaustranslatorpage.service.Languages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by Ádám on 2017. 09. 17..
 */

@Controller
@RequestMapping(value = "/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    private static Logger LOG= LoggerFactory.getLogger(ContactController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String getContactPage(ModelMap model, HttpSession session) {
        Languages lang;
        if (session.getAttribute("lang") != null) {
            lang = (Languages) session.getAttribute("lang");
        } else {
            lang = Languages.valueOf("HUN");
        }

        model.addAllAttributes(Dictionary.getPageTexts("contact",lang));
        return "contactPage";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String changeContactPage(@RequestParam(value = "lang",required =false) String language, ModelMap model, HttpSession session) {
        Languages lang= Languages.valueOf(language);
        session.setAttribute("lang",lang);
        LOG.info("Contact has been called param:" + lang);
        model.addAllAttributes(Dictionary.getPageTexts("contact",lang));
        return "contactPage";
    }



    @RequestMapping(value = "/submitContact", method = RequestMethod.POST)
    public @ResponseBody String[] addNewWork(@Valid ContactImpl contact, BindingResult result) {

        if (result.hasErrors()) {
            return new String[]{"fail", result.getFieldErrors().get(0).getDefaultMessage()};
        }

        if (contactService.contactRequestHandler(contact, contact.getLang())) {
            return new String[]{"success", Dictionary.getText("sent",contact.getLang())};
        }
        return new String[]{"fail", Dictionary.getText("problem_occured",contact.getLang())};
    }

}
