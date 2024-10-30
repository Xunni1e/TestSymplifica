package testSymplifica.shop.services;

import testSymplifica.shop.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<ProductDto> getProductById(Integer id);
    List<ProductDto> findAllProducts();
}
