package com.cvshealth.xplab.sample.controller;

import com.cvshealth.xplab.sample.model.OrderDTO;
import com.cvshealth.xplab.sample.services.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/order/{orderId}")
    OrderDTO getOrder(@PathVariable Long orderId)  {
        return orderService.getProduct(orderId);
    }

}
