
package Springweb.entity;

import javax.persistence.*;

@Entity
@Table(name = "orderdetail")
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.order",
        joinColumns = @JoinColumn(name = "OrderID")),
    @AssociationOverride(name = "primaryKey.vegetable",
        joinColumns = @JoinColumn(name = "VegetableID")) })

public class OrderDetail{
    
    private OrderDetailId primaryKey = new OrderDetailId();

    private Vegetable vegetable=getPrimaryKey().getVegetable();
    private String Quantity;
    private String Price;
    
    
    @EmbeddedId
    public OrderDetailId getPrimaryKey() {
        return primaryKey;
    }
 
    public void setPrimaryKey(OrderDetailId primaryKey) {
        this.primaryKey = primaryKey;
    }
  
    @Transient
    public Order getOrder() {
        return getPrimaryKey().getOrder();
    }
 
    public void setOrder(Order order) {
        getPrimaryKey().setOrder(order);
    }

    @Transient
    public Vegetable getVegetable() {
        return getPrimaryKey().getVegetable();
    }
 
    public void setVegetable(Vegetable vegetable) {
        getPrimaryKey().setVegetable(vegetable);
    }
    
    @Column(name = "Quantity")
    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String Quantity) {
        this.Quantity = Quantity;
    }
    
    @Column(name = "Price")
    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }
    
}