package com.adam.zakar.ferdaustranslatorpage.persictence.DAO;


import com.adam.zakar.ferdaustranslatorpage.persictence.Entities.ContactEntity;
import com.adam.zakar.ferdaustranslatorpage.persictence.Entities.ContactRepository;
import com.adam.zakar.ferdaustranslatorpage.service.ContactPage.Contact;
import com.adam.zakar.ferdaustranslatorpage.service.Languages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class ContactDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    ContactRepository contactRepository;


    public void insertContact(Contact contact, Languages language){
      ContactEntity contactEntity=  new ContactEntity(contact, language);
        entityManager.persist(contactEntity);
    }

    public List<ContactEntity> retrieveContacts(){
        List<ContactEntity> contacts=contactRepository.findAll();
        return contacts;
    }




}
