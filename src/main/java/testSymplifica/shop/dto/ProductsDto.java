package testSymplifica.shop.dto;

import org.antlr.v4.runtime.misc.NotNull;

public class ProductsDto {
    private Integer id;
    private String name;
    private Long price;

    public ProductsDto() {
    }
    public ProductsDto(Integer id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}