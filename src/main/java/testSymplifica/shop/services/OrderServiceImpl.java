package testSymplifica.shop.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import testSymplifica.shop.dto.OrderDto;
import testSymplifica.shop.dto.ProductDto;
import testSymplifica.shop.models.Order;
import testSymplifica.shop.models.OrderId;
import testSymplifica.shop.models.Product;
import testSymplifica.shop.repository.OrderRepository;

import java.util.ArrayList;
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
        /*return orderRepository.findOrderAndProductsDetails().stream().map(order ->{
            OrderDto dto = new OrderDto();
            dto.setId((Integer) order[0]);
            dto.setProduct_Name((String) order[1]);
            dto.setProduct_Price((Long) order[2]);
            return dto;
        }).collect(Collectors.toList());*/
        return null;
    }

    @Override
    @Transactional
    public void createNewOrder(List<Integer> product_id) {
        List<Order> ordersToSave = new ArrayList<>();

        Order lastOrder = orderRepository.findTopByOrderByIdDesc();
        OrderId orderId = lastOrder.getId();
        Integer lastId = orderId.getId();
        Integer newId = (lastId !=null) ? lastId + 1:1;

        System.out.println("nuevo id de orden: " + newId);

        for (Integer id: product_id){
            Product product = productService.getProductById(id).orElse(null);
            System.out.println("procesando producto con id" + id);
            Order order = new Order();
            OrderId compositeId = new OrderId(newId, id);
            order.setId(compositeId);
            order.setProduct(product);
            ordersToSave.add(order);
        }
        orderRepository.saveAll(ordersToSave);
        System.out.println("Ordenes guardadas con ID:" + newId);

    }
}
