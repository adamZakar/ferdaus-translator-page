package com.adam.zakar.ferdaustranslatorpage.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

import java.util.Properties;
import java.util.ResourceBundle;


import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by Ádám on 2017. 09. 17..
 */
@Service
public class ContactServiceImpl implements ContactService {



	private static Logger LOG = LoggerFactory.getLogger(ContactServiceImpl.class);
	private final String emailUserName="EMAILUSERNAME"; 
	private final String passEnvVariableName="EMAILPASS";
	private final ResourceBundle configuration= ResourceBundle.getBundle("configuration");
	private ResourceBundle dictionary;
	private static String DICTIONARYPROPERTIES="dictionary";
	
	
    public boolean contactRequestHandler() {
        return true;
    }


    public boolean sendEmail(List<String> addresses, String text, String lang) {
		// Get system properties
		Properties properties = System.getProperties();
		String host = "smtp.gmail.com";

		Address[] mailAdressesToInformArray =parseAddressListToArray(addresses);

		// Setup mail server
		properties.setProperty("mail.smtp.starttls.enable", "true");

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			// 2 Parameters should be set in the opal.propreties and in the system variable to connect to the server. 
			message.setFrom(new InternetAddress(System.getenv(emailUserName)));

			// Set To: header field of the header.
			message.addRecipients(Message.RecipientType.TO, mailAdressesToInformArray);

			dictionary= getResourceBundle(lang);
			
			// Set Subject: header field
			message.setSubject(dictionary.getString("subject"));
		
			// Now set the actual message
			message.setContent("Content","text/html");
			
			// Send message
			Transport transport = session.getTransport("smtp");
			transport.connect(host, System.getenv(configuration.getString(emailUserName)),
					System.getenv(configuration.getString(passEnvVariableName)));
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			LOG.info("E-mail has been sent");
			return true;
		} catch (MessagingException mex) {
			mex.printStackTrace();
			LOG.info("E-mail could not be sent");
		} 
		return false;
    }
    
    private Address[] parseAddressListToArray(List<String> addresses) {
		Address[] mailAddressesToInformArray= new Address[addresses.size()];
		for (int i = 0; i < addresses.size(); i++) {
			try {
				mailAddressesToInformArray[i] = new InternetAddress(addresses.get(i));
			} catch (Exception ex) {
				ex.printStackTrace();
				LOG.info("E-mail" + addresses.get(i) + " could not be parsed to e-mail.");
			}
		}
		return mailAddressesToInformArray;
    }
    
    
    public static ResourceBundle getResourceBundle(String lang) {
    	ResourceBundle resourceBundle=null;
        if (lang == null) {
            resourceBundle = ResourceBundle.getBundle(DICTIONARYPROPERTIES);
        }

        switch (lang) {
            case "en":
                resourceBundle = ResourceBundle.getBundle(DICTIONARYPROPERTIES, new Locale("en", "EN"));
                break;
            case "pa":
                resourceBundle = ResourceBundle.getBundle(DICTIONARYPROPERTIES, new Locale("pa", "PA"));
                break;
            case "ur":
                resourceBundle = ResourceBundle.getBundle(DICTIONARYPROPERTIES, new Locale("ur", "UR"));
                break;
            case "pe":
                resourceBundle = ResourceBundle.getBundle(DICTIONARYPROPERTIES, new Locale("pe", "PE"));
                break;
        }

        return resourceBundle;
    }

    

}
