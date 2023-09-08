
package Springweb.service;

import Springweb.entity.Vegetable;
import Springweb.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author caothanh
 */
@Service
public interface VegetableService {
    @Autowired
    Iterable<Vegetable> findAll();
    List<Vegetable> search(String term);
    Vegetable getVegetableById(Integer id);
}
