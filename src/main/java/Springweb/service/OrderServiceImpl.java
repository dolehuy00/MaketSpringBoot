/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.service;

import Springweb.entity.Order;
import Springweb.entity.Vegetable;
import Springweb.repository.OrderRepository;
import Springweb.repository.VegetableRepository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

/**
 *
 * @author PC
 */
@SessionScope
@Service
public class OrderServiceImpl implements OrderService{
    
    private Map<Integer, Vegetable> cart = new HashMap<>();

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    VegetableRepository vegetableRepository;
    
    @Override
    public Order findById(Integer id) {
        return orderRepository.findById(id).get();
    }
    
    @Override
    public void checkOutOrder(Order order){
        orderRepository.save(order);
    }
    
    @Override
    @Transactional
    public void updateQuantityAfterCheckOut(Integer id, Integer quantity){
        vegetableRepository.updateQuantityAfterCheckOut(id, quantity);
    }
    
    @Override
    public void addProductToCart(Vegetable vegetableNew){
        Vegetable vegetableOld = cart.get(vegetableNew.getVegetableID());
        if(vegetableOld == null){
            cart.put(vegetableNew.getVegetableID(), vegetableNew);
        }else{
            vegetableOld.setAmount(vegetableOld.getAmount()+1);
            vegetableOld.setPrice(vegetableOld.getPrice()+vegetableNew.getPrice());
        }
    }
    @Override
    public Integer getQuantityProductInCart(Integer id){
        Vegetable vegetable = cart.get(id);
        if (vegetable==null) {
            return 0;
        } else {
            return vegetable.getAmount();
        }
    }
    
    @Override
    public void removeProductInCart(Integer productId){
        cart.remove(productId);
    }
    
    @Override
    public Vegetable updateProductQuantityInCart(Integer productId, Integer quantity){
        Vegetable vegetable = cart.get(productId);
        vegetable.setPrice(vegetable.getPrice()/vegetable.getAmount()*quantity);
        vegetable.setAmount(quantity);
        return vegetable;
    }
    
    @Override
    public double getCartTotal(){
        return cart.values().stream()
                .mapToDouble(item -> item.getPrice()).sum();
    }
    
    @Override
    public Collection<Vegetable> getAllVegetableInCart(){
        return cart.values();
    }
    
    @Override
    public void clearCart(){
        cart.clear();
    }
    
    @Override
    public Integer getQuantityProduct(Integer id){
        return vegetableRepository.findById(id).get().getAmount();
    }
}
