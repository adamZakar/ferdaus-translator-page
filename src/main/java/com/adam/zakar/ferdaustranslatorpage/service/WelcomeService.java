package com.adam.zakar.ferdaustranslatorpage.service;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class WelcomeService implements GenericWelcomeService {

    private static Logger LOG = LoggerFactory.getLogger(WelcomeService.class);

    @Override
    public boolean storeIntoDatabase(String key) {
        return false;
    }

    @Override
    public boolean sendEmailToAllConcerned(String page) {
        return false;
    }
}
