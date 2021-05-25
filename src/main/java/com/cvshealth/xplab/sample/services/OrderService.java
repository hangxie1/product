package com.cvshealth.xplab.sample.services;

import com.cvshealth.xplab.sample.entities.OrderDetailEntity;
import com.cvshealth.xplab.sample.entities.OrderEntity;
import com.cvshealth.xplab.sample.model.OrderDTO;
import com.cvshealth.xplab.sample.model.OrderDetailDTO;
import com.cvshealth.xplab.sample.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    ModelMapper modelMapper;

    public OrderService(OrderRepository orderRepository)  {
        this.orderRepository = orderRepository;
        modelMapper = new ModelMapper();
    }

    public void save(OrderEntity orderEntity) {
        orderRepository.save(orderEntity);
    }

    public OrderDTO getProduct(Long id) {
        OrderEntity orderEntity = orderRepository.findById(id).get();
        List<OrderDetailDTO> orderDetailDTOS = new ArrayList<>();
        for (OrderDetailEntity orderDetailEntity : orderEntity.getOrderDetailEntityEntities() ) {
            OrderDetailDTO orderDetailDTO =  new OrderDetailDTO(
                    orderDetailEntity.getProductEntity().getProductName(),
                    orderDetailEntity.getQuantity(),
                    orderDetailEntity.getProductEntity().getPrice()
            );
            orderDetailDTOS.add(orderDetailDTO);
        }
        OrderDTO orderDTO = new OrderDTO(orderEntity.getId(),
                orderEntity.getCustomerName(),
                orderEntity.getSignedDate(),
                orderDetailDTOS
        );
        return orderDTO;

    }
}
