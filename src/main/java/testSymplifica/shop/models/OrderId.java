package testSymplifica.shop.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class OrderId implements Serializable {
    private Integer Id;
    private Integer productId;

    public OrderId() {}

    public OrderId(Integer Id, Integer productId) {
        this.Id = Id;
        this.productId = productId;
    }


    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }


    @Override
    public int hashCode() {
        return Id.hashCode() + productId.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof OrderId)) return false;
        OrderId other = (OrderId) obj;
        return Id.equals(other.Id) && productId.equals(other.productId);
    }
}
