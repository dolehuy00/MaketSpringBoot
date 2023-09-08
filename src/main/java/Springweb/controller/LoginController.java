
package Springweb.controller;

import Springweb.entity.Customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import Springweb.repository.LoginRepository;
import Springweb.service.LoginServiceImpl;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    
    
    @Autowired LoginRepository loginRepository; //
    @Autowired LoginServiceImpl loginsv;
    @Autowired
    HttpSession session;
    @GetMapping( value = "/login")
    public String getAll(Model model)
    {
        return "login";
        
    }
    
    
    @PostMapping("/login")
public String processLogin(@RequestParam("fullname") String username, @RequestParam("password") String password, Model model) {
    if (isValidUser(username, password)) {
        session.setAttribute("CUSTOMER_ID", loginsv.findCustomerByFullnameAndPassword(username).getCustomerID());
        return "redirect:/"; 
    } else {
        model.addAttribute("message", "Invalid username or password.");
        return "login";
    }
}


   private boolean isValidUser(String username, String password) {
    Customers customer = loginsv.findCustomerByFullnameAndPassword(username); // Tìm khách hàng theo tên đăng nhập

    if (customer != null && customer.getPassword().equals(password)) {
        return true; // Trả về true nếu tìm thấy khách hàng và mật khẩu hợp lệ
    } else {
        return false; // Trả về false nếu không tìm thấy khách hàng hoặc mật khẩu không đúng
    }
}


}
