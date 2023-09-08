
package Springweb.repository;


import Springweb.*;
import Springweb.entity.Vegetable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author caothanh
 */
@Repository
public interface VegetableRepository extends CrudRepository<Vegetable, Integer>{
    @Modifying
    @Query("UPDATE Vegetable v SET v.amount=:quantity WHERE v.vegetableID =:id")
    public void updateQuantityAfterCheckOut(@Param("id") Integer id, @Param("quantity") Integer quantity);
    
}
