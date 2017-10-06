package com.adam.zakar.ferdaustranslatorpage.controller;

import com.adam.zakar.ferdaustranslatorpage.service.Dictionary;
import com.adam.zakar.ferdaustranslatorpage.service.Languages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adam.zakar.ferdaustranslatorpage.service.WelcomePage.GenericWelcomeService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class WelcomeController {

    private static Logger LOG = LoggerFactory.getLogger(WelcomeController.class);


    @Autowired
    private GenericWelcomeService welcomeService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getWelcomPage(ModelMap model, HttpSession session) {
        Languages lang;
        if (session.getAttribute("lang") != null) {
            lang = (Languages) session.getAttribute("lang");
        } else {
            lang = Languages.valueOf("HUN");
        }
        LOG.info("Home has been called param:" + lang);
        model.addAllAttributes(Dictionary.getPageTexts("home", lang));
        return "homePage";
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String changeWelcomPage(@RequestParam(value = "lang") String language, HttpSession session, ModelMap model) {
        Languages lang = Languages.valueOf(language);
        session.setAttribute("lang",lang);
        LOG.info("Home has been called param:" + lang);
        model.addAllAttributes(Dictionary.getPageTexts("home", lang));
        return "homePage";
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String doWelcomPage( ModelMap model) {
        Languages lang;
        if (model.get("lang") != null) {
            lang = Languages.valueOf(model.get("lang").toString());
        } else {
            lang = Languages.valueOf("HUN");
        }
        LOG.info("Home has been called param:" + lang);
        model.addAllAttributes(Dictionary.getPageTexts("home", lang));
        return "homePage";
    }


    @RequestMapping(value = "/translation" ,method = RequestMethod.GET)
    public String getTranslationPage(ModelMap model, HttpSession session) {
        Languages lang;
        if (session.getAttribute("lang") != null) {
            lang = (Languages) session.getAttribute("lang");
        } else {
            lang = Languages.valueOf("HUN");
        }
        LOG.info("Contact has been called param:" + lang);
        model.addAllAttributes(Dictionary.getPageTexts("contact", lang));
        return "translationPage";
    }

    @RequestMapping(value = "/translation",method = RequestMethod.POST)
    public String changeTranslationPage(@RequestParam(value = "lang") String language, ModelMap model, HttpSession session) {
        Languages lang = Languages.valueOf(language);
        session.setAttribute("lang",lang);
        LOG.info("Contact has been called param:" + lang);
        model.addAllAttributes(Dictionary.getPageTexts("contact", lang));
        return "translationPage";
    }


}
