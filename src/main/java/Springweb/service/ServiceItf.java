/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/Repository.java to edit this template
 */
package Springweb.service;


/**
 *
 * @author trinh_hoang_phu
 */
public interface ServiceItf<T> {
    Iterable<T> findAll();
}
