package testSymplifica.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import testSymplifica.shop.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
