package testSymplifica.shop.services;

import testSymplifica.shop.dto.ProductDto;
import testSymplifica.shop.repository.ProductRepository;

import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<ProductDto> getProductById(Integer id) {
         return productRepository.findById(id).map(products -> {
             ProductDto dto = new ProductDto();
             dto.setId(products.getId());
             dto.setName(products.getName());
             dto.setPrice(products.getPrice());
             return dto;
         });

    }
}
