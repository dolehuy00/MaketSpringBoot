
package Springweb.repository;

import Springweb.entity.Customers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author caothanh
 */
@Repository
public interface LoginRepository extends CrudRepository<Customers, Integer>{
    Customers findByFullname(String fullname);
}
