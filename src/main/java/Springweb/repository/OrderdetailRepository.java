/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/Repository.java to edit this template
 */
package Springweb.repository;


import Springweb.entity.OrderDetail;
import Springweb.entity.OrderDetailId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author trinh_hoang_phu
 */
@Repository
public interface OrderdetailRepository extends CrudRepository<OrderDetail, OrderDetailId> {
    
}
