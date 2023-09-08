
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
import Springweb.service.RegisterService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {
    
    
        @Autowired
    private RegisterService registerService;

  @PostMapping("/register")
    public String registerCustomer(@RequestParam("nfullname") String fullname, 
                                   @RequestParam("npassword") String password, 
                                   @RequestParam("naddress") String address, 
                                   @RequestParam("ncity") String city,
                                    Model model) {
        // Kiểm tra xem fullname đã tồn tại trong cơ sở dữ liệu hay chưa
        if (registerService.findCustomerByFullname(fullname)!= 0) 
        {
            model.addAttribute("errormess", "username đã tồn tại");
            return "login";
        }
       
        Customers customer = new Customers();
        customer.setFullname(fullname);
        customer.setPassword(password);
        customer.setAddress(address);
        customer.setCity(city);
        registerService.registerCustomer(customer);
        return "redirect:/login";
    }




}



