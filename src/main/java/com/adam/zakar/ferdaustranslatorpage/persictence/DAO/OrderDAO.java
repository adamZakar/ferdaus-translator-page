package com.adam.zakar.ferdaustranslatorpage.persictence.DAO;

import com.adam.zakar.ferdaustranslatorpage.persictence.Entities.OrderEntity;
import com.adam.zakar.ferdaustranslatorpage.service.InterpretitionPage.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class OrderDAO {

    @PersistenceContext
    private EntityManager entityManager;


    public void insertOrderRequest(Order order){
        OrderEntity orderEntity=  new OrderEntity(order.getName(),order.getEmail(),
                order.getFirstLanguage(),order.getSecondLanguage(),order.getDescription());
        entityManager.persist(orderEntity);
    }

}
