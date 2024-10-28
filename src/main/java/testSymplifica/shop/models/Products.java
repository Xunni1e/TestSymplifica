package testSymplifica.shop.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Long price;
    private Integer current_Stock;

    public Products(){}
    public Products(Integer id, String name, String description, Long price, Integer current_Stock){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.current_Stock = current_Stock;
    }

    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public Long getPrice(){
        return price;
    }
    public void setPrice(Long price){
        this.price = price;
    }

    public Integer getCurrent_Stock(){
        return current_Stock;
    }
    public void setCurrent_Stock(Integer current_Stock){
        this.current_Stock = current_Stock;
    }
}

