package testSymplifica.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import testSymplifica.shop.dto.ProductsDto;
import testSymplifica.shop.models.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
}
