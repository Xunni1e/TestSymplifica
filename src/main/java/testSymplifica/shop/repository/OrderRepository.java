package testSymplifica.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import testSymplifica.shop.models.Order;
import testSymplifica.shop.models.OrderId;

import java.util.List;


public interface OrderRepository extends JpaRepository<Order, OrderId> {
    //@Query("select o.id, p.name, p.price from Order o join Product p")
    //List<Object[]> findOrderAndProductsDetails();

    //@Query("SELECT MAX(o.id.id) FROM Order o")
    //Integer findLastId();
    Order findTopByOrderByIdDesc();
}
