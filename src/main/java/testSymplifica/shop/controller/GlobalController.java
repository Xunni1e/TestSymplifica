package testSymplifica.shop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        return "index";
    }
}
