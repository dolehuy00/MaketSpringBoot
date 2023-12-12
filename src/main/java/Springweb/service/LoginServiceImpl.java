/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.service;

import Springweb.entity.Customers;
import Springweb.*;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Springweb.repository.LoginRepository;
import javax.persistence.Query;

/**
 *
 * @author caothanh
 */
@Service
public class LoginServiceImpl implements LoginService {
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Customers findCustomerByFullnameAndPassword(String fullname) {
    Query query = entityManager.createNativeQuery(
        "SELECT * FROM Customers WHERE BINARY Fullname = ? ", Customers.class);
    query.setParameter(1, fullname);
    try {
        return (Customers) query.getSingleResult();
    } catch (NoResultException e) {
        return null;
    }
}

    
}
