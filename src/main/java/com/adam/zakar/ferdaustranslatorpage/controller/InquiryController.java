package com.adam.zakar.ferdaustranslatorpage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Ádám on 2017. 09. 15..
 */
@Controller
@RequestMapping(value="/inquiry" )
public class InquiryController {

    @RequestMapping
    public String inquiryWelcome(){
        return "inquiry";
    }

}
