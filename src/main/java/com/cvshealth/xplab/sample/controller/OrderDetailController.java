package com.cvshealth.xplab.sample.controller;

import com.cvshealth.xplab.sample.model.OrderDetailDTO;
import com.cvshealth.xplab.sample.services.OrderDetailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderDetailController {
    private OrderDetailService orderDetailService;
    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @GetMapping("/orderdetail/{orderId}")
    List<OrderDetailDTO> geProduct(@PathVariable Long orderId) {
        return orderDetailService.getOrder(orderId);
    }
}
