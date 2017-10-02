package com.adam.zakar.ferdaustranslatorpage.service.WelcomePage;

import java.util.Map;

public interface GenericWelcomeService {

	boolean storeIntoDatabase(String key);
	boolean sendEmailToAllConcerned(String page);
}
