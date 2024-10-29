package testSymplifica.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import testSymplifica.shop.models.Order;

import java.util.List;


public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("select o.id, p.name, p.price from Order o join Product p")
    List<Object[]> findOrderAndProductsDetails();
}
