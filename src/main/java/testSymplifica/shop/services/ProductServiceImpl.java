package testSymplifica.shop.services;

import org.springframework.stereotype.Service;
import testSymplifica.shop.dto.ProductDto;
import testSymplifica.shop.models.Product;
import testSymplifica.shop.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<ProductDto> getProductById(Integer id) {
         return productRepository.findById(id).map(this::mapToProductDto);
    }

    @Override
    public List<ProductDto> findAllProducts() {
        return productRepository.findAll().stream().map(this::mapToProductDto).collect(Collectors.toList());
    }

    private ProductDto mapToProductDto(Product product){
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        return dto;
    }
}
