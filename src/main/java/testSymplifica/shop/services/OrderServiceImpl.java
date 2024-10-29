package testSymplifica.shop.services;

import testSymplifica.shop.dto.OrderDto;
import testSymplifica.shop.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
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
}
