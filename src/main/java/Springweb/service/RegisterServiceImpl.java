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
import Springweb.repository.RegisterRepository;
import javax.persistence.Query;

/**
 *
 * @author caothanh
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterRepository registerRepository;
    
     @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void registerCustomer(Customers customer) {
        registerRepository.save(customer);
    }
    
  @Override
public long findCustomerByFullname(String fullname) {
    Query query = entityManager.createNativeQuery(
        "SELECT COUNT(*) FROM Customers WHERE BINARY Fullname = ?");
    query.setParameter(1, fullname);
    return (int) ((Number) query.getSingleResult()).longValue();
}

     
    
}
