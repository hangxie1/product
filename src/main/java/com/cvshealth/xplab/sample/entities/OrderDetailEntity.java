package com.cvshealth.xplab.sample.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailEntity {

    @Id
    Long id;

    @ManyToOne
    @JoinColumn
    ProductEntity productEntity;

    @ManyToOne
    @JoinColumn
    OrderEntity orderEntity;

    Long quantity;

}
