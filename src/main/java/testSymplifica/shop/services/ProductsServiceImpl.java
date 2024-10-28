package testSymplifica.shop.services;

import testSymplifica.shop.dto.ProductsDto;
import testSymplifica.shop.repository.ProductsRepository;

import java.util.Optional;

public class ProductsServiceImpl implements ProductsService{
    private final ProductsRepository productsRepository;

    public ProductsServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public Optional<ProductsDto> getProductById(Integer id) {
         return productsRepository.findById(id).map(products -> {
             ProductsDto dto = new ProductsDto();
             dto.setId(products.getId());
             dto.setName(products.getName());
             dto.setPrice(products.getPrice());
             return dto;
         });

    }
}
