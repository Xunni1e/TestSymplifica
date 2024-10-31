package testSymplifica.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import testSymplifica.shop.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p.name FROM Product p WHERE p.id = :id")
    String findNameById(@Param("id") Integer id);

    @Query("SELECT p.price FROM Product p WHERE p.id = :id")
    String findPriceById(@Param("id") Integer id);
}
