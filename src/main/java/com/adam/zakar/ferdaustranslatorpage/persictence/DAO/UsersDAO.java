package com.adam.zakar.ferdaustranslatorpage.persictence.DAO;

import com.adam.zakar.ferdaustranslatorpage.persictence.Entities.Users;
import com.adam.zakar.ferdaustranslatorpage.persictence.Entities.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UsersDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UsersRepository usersRepository;

    public List<Users> getAllUsers(){
        List<Users> users= usersRepository.findAll();
        return users;
    }

    public Users getUser(String name){
      return  getAllUsers().get(getAllUsers().indexOf(new Users(name)));
    }

}
