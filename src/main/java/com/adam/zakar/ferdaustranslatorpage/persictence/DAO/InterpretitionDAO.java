package com.adam.zakar.ferdaustranslatorpage.persictence.DAO;

import com.adam.zakar.ferdaustranslatorpage.persictence.Entities.InterpretitionEntity;
import com.adam.zakar.ferdaustranslatorpage.service.InterpretitionPage.Order;
import com.adam.zakar.ferdaustranslatorpage.service.Languages;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class InterpretitionDAO {

    @PersistenceContext
    private EntityManager entityManager;


    public void insertOrderRequest(Order order, Languages languages){
        InterpretitionEntity orderEntity=  new InterpretitionEntity(order, languages);
        entityManager.persist(orderEntity);
    }

}
