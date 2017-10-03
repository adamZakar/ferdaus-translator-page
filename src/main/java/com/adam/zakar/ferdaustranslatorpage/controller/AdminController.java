package com.adam.zakar.ferdaustranslatorpage.controller;

import com.adam.zakar.ferdaustranslatorpage.persictence.DAO.ContactDAO;
import com.adam.zakar.ferdaustranslatorpage.persictence.Entities.ContactEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ContactDAO contactDAO;

    @RequestMapping
    public String getAdminPage(Model model){
        List<ContactEntity> contactEntities=contactDAO.retrieveContacts();
        model.addAllAttributes(contactDAO.retrieveContacts());
        return "adminPage";
    }





}
