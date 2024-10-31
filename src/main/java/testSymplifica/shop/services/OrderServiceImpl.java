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
        List<OrderDto> ordersDto = new ArrayList<>();
        List<Order> orders = orderRepository.findAll();
        for (Order order : orders){
            OrderId orderId = order.getId();
            Integer id = orderId.getId();
            Integer productId = orderId.getProductId();
            String productName = productService.findNameById(productId);
            String productPrice = productService.findPriceById(productId);
            OrderDto orderDto = new OrderDto();
            orderDto.setId(id);
            orderDto.setProduct_Name(productName);
            orderDto.setProduct_Price(productPrice);
            ordersDto.add(orderDto);
        }
        return ordersDto;
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
