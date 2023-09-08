
package Springweb.service;

import Springweb.*;
import Springweb.entity.Customers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author caothanh
 */
@Service
public interface RegisterService {
    void registerCustomer(Customers customer);
    
    long findCustomerByFullname(String fullname);
}

