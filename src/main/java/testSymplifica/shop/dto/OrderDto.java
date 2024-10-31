package testSymplifica.shop.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import testSymplifica.shop.models.Product;

public class OrderDto {
    private Integer id;
    private String product_Name;
    private String product_Price;

    public OrderDto() {
    }
    public OrderDto(Integer id, String product_Name, String product_Price) {
        this.id = id;
        this.product_Name = product_Name;
        this.product_Price = product_Price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct_Name() {
        return product_Name;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public String getProduct_Price() {
        return product_Price;
    }

    public void setProduct_Price(String product_Price) {
        this.product_Price = product_Price;
    }
}
