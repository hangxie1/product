package com.cvshealth.xplab.sample.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderEntity {
    @Id
    Long  id;
    String customerName;
    String signedDate;

    @OneToMany(mappedBy = "orderEntity")
    List<OrderDetailEntity> orderDetailEntityEntities;

}
