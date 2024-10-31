package testSymplifica.shop.controller;


import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import testSymplifica.shop.dto.OrderDto;
import testSymplifica.shop.dto.ProductDto;
import testSymplifica.shop.services.OrderServiceImpl;
import testSymplifica.shop.services.ProductServiceImpl;

import java.util.List;

@Controller
public class GlobalController {

    private final ProductServiceImpl productService;
    private final OrderServiceImpl orderService;

    public GlobalController(ProductServiceImpl productService, OrderServiceImpl orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping("/")
    public String homePage(Model model){
        List<ProductDto> products = productService.findAllProducts();
        model.addAttribute("products", products);
        List<OrderDto> orders = orderService.findAllOrders();
        model.addAttribute("orders",orders);
        return "index";
    }
    @PostMapping("/")
    public String submit(@RequestParam List<Integer> selectedProducts, Model model){
        System.out.println("Productos seleccionados: " + selectedProducts);
        orderService.createNewOrder(selectedProducts);
        return "redirect:/";
    }
}
