package com.cvshealth.xplab.sample.repository;

import com.cvshealth.xplab.sample.entities.OrderDetailEntity;
import com.cvshealth.xplab.sample.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity,Long> {
    List<OrderDetailEntity> findOrderDetailEntitiesByOrderEntityEquals(OrderEntity orderEntity);
}
