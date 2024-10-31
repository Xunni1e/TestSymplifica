package testSymplifica.shop.repository;

import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import testSymplifica.shop.models.Order;
import testSymplifica.shop.models.OrderId;

import java.util.List;


public interface OrderRepository extends JpaRepository<Order, OrderId> {


    //@Query("SELECT MAX(o.id.id) FROM Order o")
    //Integer findLastId();
    Order findTopByOrderByIdDesc();
}
