package com.cvshealth.xplab.sample.repository;

import com.cvshealth.xplab.sample.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
}
