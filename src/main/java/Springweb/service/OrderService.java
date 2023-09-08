/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Springweb.service;

import Springweb.entity.Order;
import Springweb.entity.Vegetable;
import java.util.Collection;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public interface OrderService {
    public Order findById(Integer id);
    public void addProductToCart(Vegetable vegetableNew);
    public void removeProductInCart(Integer productId);
    public Vegetable updateProductQuantityInCart(Integer productId, Integer quantity);
    public double getCartTotal();
    public Collection<Vegetable> getAllVegetableInCart();
    public void clearCart();
    public Integer getQuantityProduct(Integer id);

    void checkOutOrder(Order order);

    void updateQuantityAfterCheckOut(Integer id, Integer quantity);

    Integer getQuantityProductInCart(Integer id);
}
