/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Springweb.service;

import Springweb.entity.Customers;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public interface CustomerService {
    public Customers findCustomers(String user);

    Customers findById(Integer id);
}
