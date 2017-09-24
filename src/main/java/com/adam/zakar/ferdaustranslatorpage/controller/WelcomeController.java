package com.adam.zakar.ferdaustranslatorpage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adam.zakar.ferdaustranslatorpage.service.GenericWelcomeService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@ComponentScan("com.adam.zakar.ferdaustranslatorpage")
public class WelcomeController {

    private static Logger LOG = LoggerFactory.getLogger(WelcomeController.class);


    @Autowired
    private GenericWelcomeService welcomeService;

    @RequestMapping(value = "/home")
    public String getWelcomPage(@RequestParam(value = "lang",required =false) String lang, Model model) {
        LOG.info("Home has been called param:" +lang);
        welcomeService.setResourceBundle(lang);
        model.addAllAttributes(welcomeService.getInnerTexts("home"));
        return "homePage";
    }


    @RequestMapping(value = "/")
    public String doWelcomPage(@RequestParam(value = "lang",required =false) String lang, Model model) {
        LOG.info("Home has been called param:" +lang);
        welcomeService.setResourceBundle(lang);
        model.addAllAttributes(welcomeService.getInnerTexts("home"));
        return "homePage";
    }



    @RequestMapping(value = "/translation")
    public String getTranslationPage(@RequestParam(value = "lang",required =false) String lang, Model model) {
        LOG.info("Contact has been called param:" +lang);
        welcomeService.setResourceBundle(lang);
        model.addAllAttributes(welcomeService.getInnerTexts("contact"));
        return "translationPage";
    }

    @RequestMapping(value = "/interpretition")
    public String getInterpretitionPage(@RequestParam(value = "lang",required =false) String lang, Model model) {
        LOG.info("Contact has been called param:" +lang);
        welcomeService.setResourceBundle(lang);
        model.addAllAttributes(welcomeService.getInnerTexts("contact"));
        return "interpretitionPage";
    }

    @RequestMapping(value="/contact")
    public String getContactPage(@RequestParam(value = "lang",required =false) String lang, Model model) {
        LOG.info("Contact has been called param:" +lang);
        model.addAllAttributes(welcomeService.getInnerTexts("contact"));
        return "contactPage";
    }


}
