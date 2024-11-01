package testSymplifica.shop.models;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String price;
    private Integer current_Stock;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    public Product(){}
    public Product(Integer id, String name, String description, String price, Integer current_Stock){
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

    public String getPrice(){
        return price;
    }
    public void setPrice(String price){
        this.price = price;
    }

    public Integer getCurrent_Stock(){
        return current_Stock;
    }
    public void setCurrent_Stock(Integer current_Stock){
        this.current_Stock = current_Stock;
    }
}

