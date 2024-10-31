package testSymplifica.shop.services;

import testSymplifica.shop.dto.ProductDto;
import testSymplifica.shop.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<ProductDto> getProductDtoById(Integer id);
    List<ProductDto> findAllProducts();
    Optional<Product> getProductById(Integer id);
    String findNameById(Integer id);
    String findPriceById(Integer id);

}
