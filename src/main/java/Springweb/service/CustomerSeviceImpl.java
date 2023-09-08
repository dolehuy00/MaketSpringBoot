/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.service;

import Springweb.entity.Customers;
import Springweb.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class CustomerSeviceImpl implements CustomerService{

    @Autowired
    CustomersRepository customersRepository;
    
    @Override
    public Customers findCustomers(String user) {
        Iterable<Customers> listCustomer = customersRepository.findAll();
        for(Customers customers : listCustomer){
            if (customers.getFullname().equals(user)) {
                return customers;
            }
        }
        return null;
    }
    @Override
    public Customers findById(Integer id){
        return customersRepository.findById(id).get();
    }
}
