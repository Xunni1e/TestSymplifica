package testSymplifica.shop.services;

import testSymplifica.shop.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> findAllOrders();
    void createNewOrder(List<Integer> product_id);

}
