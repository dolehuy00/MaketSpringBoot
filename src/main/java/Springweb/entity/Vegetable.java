package Springweb.entity;




import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author caothanh
 */
@Data
@Entity (name = "Vegetable")
@Table (name = "Vegetable")
public class Vegetable{

    
    private Integer VegetableID;
    
    private String VegetableName;
    
    private String Unit;
    
    private Integer Amount;
    
    private String Image;
    
    private Double Price;
    
    private Category category;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getVegetableID() {
        return VegetableID;
    }

    public void setVegetableID(Integer VegetableID) {
        this.VegetableID = VegetableID;
    }

    public String getVegetableName() {
        return VegetableName;
    }

    public void setVegetableName(String VegetableName) {
        this.VegetableName = VegetableName;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String Unit) {
        this.Unit = Unit;
    }

    public Integer getAmount() {
        return Amount;
    }

    public void setAmount(Integer Amount) {
        this.Amount = Amount;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(Double Price) {
        this.Price = Price;
    }

    @ManyToOne
    @JoinColumn(name = "CatagoryID")
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    
    
    
    
}
