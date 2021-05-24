package com.cvshealth.xplab.sample.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    Long id;
    String productName;
    Double price;
}
