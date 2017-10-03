package com.adam.zakar.ferdaustranslatorpage.controller;

import com.adam.zakar.ferdaustranslatorpage.service.ContactPage.ContactImpl;
import com.adam.zakar.ferdaustranslatorpage.service.ContactPage.ContactService;
import com.adam.zakar.ferdaustranslatorpage.service.Dictionary;
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


    @RequestMapping
    public String getContactPage(@RequestParam(value = "lang",required =false) String lang, Model model) {
        model.addAllAttributes(Dictionary.getPageTexts("contact",lang));
        return "contactPage";
    }



    @RequestMapping(value = "/submitContact", method = RequestMethod.POST)
    public @ResponseBody String[] addNewWork(@Valid ContactImpl contact, BindingResult result, @RequestParam(value="lang", required = false) String lang) {
        if (result.hasErrors()) {
            return new String[]{"fail", result.getFieldErrors().get(0).getDefaultMessage()};
        }

        if (contactService.contactRequestHandler(contact, lang)) {
            return new String[]{"success", Dictionary.getText("sent",lang)};
        }
        return new String[]{"fail", Dictionary.getText("problem_occured",lang)};
    }

}
