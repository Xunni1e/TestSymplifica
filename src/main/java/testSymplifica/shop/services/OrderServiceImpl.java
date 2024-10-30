package testSymplifica.shop.services;

import org.springframework.stereotype.Service;
import testSymplifica.shop.dto.OrderDto;
import testSymplifica.shop.dto.ProductDto;
import testSymplifica.shop.models.Order;
import testSymplifica.shop.models.Product;
import testSymplifica.shop.repository.OrderRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final ProductServiceImpl productService;

    public OrderServiceImpl(OrderRepository orderRepository, ProductServiceImpl productService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
    }


    @Override
    public List<OrderDto> findAllOrders() {
        return orderRepository.findOrderAndProductsDetails().stream().map(order ->{
            OrderDto dto = new OrderDto();
            dto.setId((Integer) order[0]);
            dto.setProduct_Name((String) order[1]);
            dto.setProduct_Price((Long) order[2]);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void createNewOrder(List<Integer> product_id) {
        Integer lastId = orderRepository.findLastId();
        Integer nuevoId = (lastId !=null) ? lastId + 1:1;

        for (Integer id: product_id){
            Product product = productService.getProductById(id).orElse(null);
            Order order = new Order();
            order.setId(nuevoId);
            order.setProduct(product);
            if (product_id.isEmpty()){
                throw new IllegalArgumentException("No products added");
            }

        }

    }
}
