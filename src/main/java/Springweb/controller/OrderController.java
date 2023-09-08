/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.controller;

import Springweb.entity.Order;
import Springweb.entity.OrderDetail;
import Springweb.entity.Vegetable;
import Springweb.service.CustomerService;
import Springweb.service.OrderService;
import Springweb.service.VegetableService;
import java.util.Collection;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {
    @Autowired
    private VegetableService vegetableService; 
    @Autowired
    private CustomerService customerService;
    @Autowired
    HttpSession session; 
    @Autowired
    private OrderService orderService;
    
    //Check out
    @PostMapping("check-out")
    public String checkOut(Model m, @ModelAttribute("NOTE") String note){
        if (checkLogin()) {
            Order order = new Order();
            Integer id = (Integer) session.getAttribute("CUSTOMER_ID");
            order.setCustomer(customerService.findById(id));
            order.setDate(new Date());
            order.setNote(note);
            order.setTotal(String.valueOf(orderService.getCartTotal()));
            Collection<Vegetable> list = orderService.getAllVegetableInCart();
            for (Vegetable ve : list) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrder(order);
                orderDetail.setVegetable(ve);
                orderDetail.setPrice(String.valueOf(ve.getPrice()));
                orderDetail.setQuantity(String.valueOf(ve.getAmount()));
                order.addOrderDetail(orderDetail);
                orderService.updateQuantityAfterCheckOut(ve.getVegetableID(),
                    orderService.getQuantityProduct(ve.getVegetableID())-ve.getAmount());
            }
            orderService.checkOutOrder(order);
            orderService.clearCart();
            return "redirect:/";
        }else{
            return "redirect:/login";
        } 
    }
    //View cart
    @GetMapping("cart")
    public String viewCart(Model model){
        model.addAttribute("CART_ITEM", orderService.getAllVegetableInCart());
        model.addAttribute("TOTAL",orderService.getCartTotal());
        return "shopping-cart";
    }
    //Add product to cart
    @PostMapping("/")
    public String addProduct(@RequestParam("add")Integer id, Model model){
        Vegetable vegetable = vegetableService.getVegetableById(id);
        Integer currentInventory = vegetable.getAmount();
        Integer quantityInCart = orderService.getQuantityProductInCart(id);
        if (quantityInCart+1>currentInventory){
            model.addAttribute("MESSAGE_QUANTITY", "error");
            return "VegetableView";
        } else {
            vegetable.setAmount(1);
            orderService.addProductToCart(vegetable);
            return "redirect:/";
        }
            
    }
    //Update quantity product
    @PostMapping("cart")
    public String updateProductQuantityInCart(Model model,
            @RequestParam("update")Integer id,
            @RequestParam("quantity") Integer quantity){
        Integer currentInventory = orderService.getQuantityProduct(id);
        if (quantity>currentInventory){
            orderService.updateProductQuantityInCart(id, currentInventory);
            model.addAttribute("CART_ITEM", orderService.getAllVegetableInCart());
            model.addAttribute("TOTAL",orderService.getCartTotal());
            model.addAttribute("MESSAGE_QUANTITY", "error");
            return "shopping-cart";
        } else {
            orderService.updateProductQuantityInCart(id, quantity);
            return "redirect:/cart";
        }   
    }
    //Remove product in cart
    @PostMapping("cart/remove/{VegetableID}")
    public String removeProductQuantityInCart(Model model,
            @PathVariable("VegetableID") Integer id){
        orderService.removeProductInCart(id);
        return "redirect:/cart";
    }
    //Check login before check out
    public Boolean checkLogin(){
        Integer userName = (Integer) session.getAttribute("CUSTOMER_ID");
        return userName != null;
    }
    
}
