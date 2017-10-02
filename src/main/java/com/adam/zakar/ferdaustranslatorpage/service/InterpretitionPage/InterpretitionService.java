package com.adam.zakar.ferdaustranslatorpage.service.InterpretitionPage;

import com.adam.zakar.ferdaustranslatorpage.service.ContactPage.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.List;

@Service
public class InterpretitionService {

    @Autowired
    private JavaMailSender sender;


    public boolean orderHandler(Order order, String Lang){
        if(order.getFirstLanguage().equals(order.getSecondLanguage())){
            throw new IllegalArgumentException("First language cannot be equal to second language");
        }
        return true;
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
