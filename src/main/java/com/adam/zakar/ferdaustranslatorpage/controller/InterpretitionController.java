package com.adam.zakar.ferdaustranslatorpage.controller;

import com.adam.zakar.ferdaustranslatorpage.service.Dictionary;
import com.adam.zakar.ferdaustranslatorpage.service.InterpretitionPage.InterpretitionService;
import com.adam.zakar.ferdaustranslatorpage.service.InterpretitionPage.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/interpretition")
public class InterpretitionController {

    @Autowired
    InterpretitionService interpretitionService;


    @RequestMapping
    public String getInterpretitionPage(@RequestParam(value = "lang",required =false) String lang, Model model) {
        model.addAllAttributes(Dictionary.getPageTexts("interpretition",lang));
        return "interpretitionPage";
    }

    @RequestMapping("/order")
    public @ResponseBody String getOrder(@RequestBody Order order, @RequestParam(value = "lang",required =false) String lang, Model model) {
        interpretitionService.orderHandler(order, lang);
        return "interpretitionPage";
    }


}
