package testSymplifica.shop.services;

import testSymplifica.shop.dto.ProductsDto;

import java.util.Optional;

public interface ProductsService {
    Optional<ProductsDto> getProductById(Integer id);
}
