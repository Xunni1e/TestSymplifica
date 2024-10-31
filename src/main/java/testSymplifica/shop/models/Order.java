package testSymplifica.shop.models;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.Optional;

@Entity
@Table(name = "orders")
public class Order {
    @EmbeddedId
    private OrderId id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public Order() {
    }

    public Order(OrderId id, Product product) {
        this.id = id;
        this.product = product;
    }

    public OrderId getId() {
        return id;
    }

    public void setId(OrderId id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
