package com.adam.zakar.ferdaustranslatorpage.service.ContactPage;

import com.adam.zakar.ferdaustranslatorpage.persictence.DAO.ContactDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.*;


import javax.mail.internet.MimeMessage;

/**
 * Created by Ádám on 2017. 09. 17..
 */
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private JavaMailSender sender;

    @Autowired
    private ContactDAO contactDAO;

    private final String emailUserName = "EMAILUSERNAME";
    private final String passEnvVariableName = "EMAILPASS";
    private final ResourceBundle configuration = ResourceBundle.getBundle("configuration");
    private final String EMAIL_ADRESSES = "EMAIL_TO_SEND_1";

    @Override
    public boolean contactRequestHandler(Contact contact, String lang) {
        List<String> adresses = setAdresses(contact.getEmail());
        contactDAO.insertContact(contact);
        return true; //sendEmail(adresses, contact, lang);
    }

    private List<String> setAdresses(String email) {
        List<String> contacts = new ArrayList<>();
        contacts.add(email);
        contacts.add(configuration.getString(EMAIL_ADRESSES));
        return contacts;
    }

    protected boolean sendEmail(List<String> addresses, Contact contact, String lang) {

        MimeMessage message = sender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo((addresses.toArray(new String[addresses.size()])));

            helper.setText(
                    "Szia!\n Megkerestek a következő e-mail címről: "+ contact.getEmail()+
                    "\n \n a következő üzenettel:  \n"+
                    contact.getMessage());

            helper.setSubject(contact.getSubject());

            sender.send(message);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

}
