package com.cvshealth.xplab.sample.services;

import com.cvshealth.xplab.sample.entities.OrderDetailEntity;
import com.cvshealth.xplab.sample.entities.OrderEntity;
import com.cvshealth.xplab.sample.model.OrderDetailDTO;
import com.cvshealth.xplab.sample.repository.OrderDetailRepository;
import com.cvshealth.xplab.sample.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService {
    private OrderDetailRepository orderDetailRepository;
    private OrderRepository orderRepository;
    ModelMapper modelMapper;

    public OrderDetailService(OrderDetailRepository orderDetailRepository,
                              OrderRepository orderRepository) {
        this.orderDetailRepository = orderDetailRepository;
        this.orderRepository = orderRepository;
        modelMapper = new ModelMapper();
    }

    public List<OrderDetailDTO>  getOrder(Long orderId) {
        Optional<OrderEntity> orderEntityOptional = orderRepository.findById(orderId);
        List<OrderDetailEntity> orderDetailEntities = orderDetailRepository.findOrderDetailEntitiesByOrderEntityEquals(orderEntityOptional.get());
        List<OrderDetailDTO> orderDetailDTOS = new ArrayList<>();
        for (OrderDetailEntity orderDetailEntity: orderDetailEntities) {
            OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
            orderDetailDTO.setProductName(orderDetailEntity.getProductEntity().getProductName());
            orderDetailDTO.setPrice(orderDetailEntity.getProductEntity().getPrice());
            orderDetailDTO.setQuantity(orderDetailEntity.getQuantity());
            orderDetailDTOS.add(orderDetailDTO);
        }
        return orderDetailDTOS;
    }
}

