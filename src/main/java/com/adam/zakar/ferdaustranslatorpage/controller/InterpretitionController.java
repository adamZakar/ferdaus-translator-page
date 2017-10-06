package com.adam.zakar.ferdaustranslatorpage.controller;

import com.adam.zakar.ferdaustranslatorpage.service.Dictionary;
import com.adam.zakar.ferdaustranslatorpage.service.InterpretitionPage.InterpretitionService;
import com.adam.zakar.ferdaustranslatorpage.service.InterpretitionPage.Order;
import com.adam.zakar.ferdaustranslatorpage.service.Languages;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

@Controller
@RequestMapping(value = "/interpretition")
public class InterpretitionController {

    @Autowired
    InterpretitionService interpretitionService;


    @RequestMapping(method = RequestMethod.POST)
    public String getInterpretitionPage(@RequestParam(value = "lang",required =false) String lang, ModelMap model, HttpSession session) {
        Languages language=Languages.valueOf(lang);
        session.setAttribute("lang",lang);
        LOG.info("Home has been called param:" + lang);
        model.addAllAttributes(Dictionary.getPageTexts("interpretition",language));
        return "interpretitionPage";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getInterpretitionPage(ModelMap model, HttpSession session) {
        Languages lang;
        if (session.getAttribute("lang") != null) {
            lang = (Languages) session.getAttribute("lang");
        } else {
            lang = Languages.valueOf("HUN");
        }
        model.addAllAttributes(Dictionary.getPageTexts("interpretition",lang));
        return "interpretitionPage";
    }

    @RequestMapping("/order")
    public @ResponseBody String getOrder(@RequestBody Order order, @RequestParam(value = "lang",required =false) String lang, Model model) {
        Languages language=Languages.valueOf(lang);
        interpretitionService.orderHandler(order, language);
        return "interpretitionPage";
    }



    @Autowired
    private Environment env;
    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "C:\\Users\\adzakar\\ownProject\\ferdaus-translator-page\\uploaded\\";

    Logger LOG= LoggerFactory.getLogger(InterpretitionController.class);

    @ResponseBody
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public ResponseEntity<?> uploadFile(@RequestParam("fileToUpload") MultipartFile[] uploadfiles) {

        LOG.info("Uploadfile has benn called with "+uploadfiles.length+" number of elements.");

        for(MultipartFile uploadfile:uploadfiles) {
            try {
                // Get the filename and build the local file path
                String filename = uploadfile.getOriginalFilename();
                String directory = "C:\\Users\\adzakar\\ownProject\\ferdaus-translator-page\\uploaded";
                String filepath = Paths.get(directory, filename).toString();
                File file = new File(filepath);
                LOG.info("Saving  file to: " + file.getPath());
                // Save the file locally
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(file));
                stream.write(uploadfile.getBytes());
                stream.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    } // method uploadFile

}
