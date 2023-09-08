/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name ="Category")
public class Category {
    
    private Integer CatagoryID;
    
    private String Name;
    
    private String Description;

    private List<Vegetable> vegetables;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getCatagoryID() {
        return CatagoryID;
    }

    public void setCatagoryID(Integer CatagoryID) {
        this.CatagoryID = CatagoryID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    @OneToMany(mappedBy = "category")
    public List<Vegetable> getVegetables() {
        return vegetables;
    }
    public void setVegetables(List<Vegetable> vegetables) {
        this.vegetables = vegetables;
    }
}
