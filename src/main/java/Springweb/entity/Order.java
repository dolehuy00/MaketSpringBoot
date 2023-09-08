/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


@Entity
@Table(name = "`order`")
public class Order{
    private List<Vegetable> vegetable;
    private List<OrderDetail> orderDetail = new ArrayList<>();
    private Integer OrderID;
    private Date Date;
    private String Total;
    private String Note;
    private Customers Customer;
    
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    public Integer getOrderID() {
        return OrderID;
    }
    public void setOrderID(Integer OrderID) {
        this.OrderID = OrderID;
    }
    
    @Column
    @Temporal(value = TemporalType.DATE)
    public Date getDate() {
        return Date;
    }
    public void setDate(Date Date) {
        this.Date = Date;
    }
    @Column
    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }
    @Column
    public String getTotal() {
        return Total;
    }

    public void setTotal(String Total) {
        this.Total = Total;
    }
    
    @ManyToOne
    @JoinColumn(name = "CustomerID")
    @NotFound(action =  NotFoundAction.IGNORE)
    public Customers getCustomer() {
        return Customer;
    }

    public void setCustomer(Customers Customer) {
        this.Customer = Customer;
    }
    
    @OneToMany(mappedBy = "primaryKey.order",cascade = CascadeType.ALL, fetch =FetchType.LAZY)
    public List<OrderDetail> getOrderDetail() {
        return orderDetail;
    }
    public void setOrderDetail(List<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }
    public void addOrderDetail(OrderDetail orderDetail) {
        this.orderDetail.add(orderDetail);
    }

//    @ManyToMany
//    @JoinTable(name = "orderdetail", joinColumns={@JoinColumn(name = "OrderID")},
//            inverseJoinColumns = {@JoinColumn(name = "VegetableID")})
//    public List<Vegetable> getVegetable() {
//        return vegetable;
//    }
//    public void setVegetable(List<Vegetable> vegetable) {
//        this.vegetable = vegetable;
//    }

      


    
}
