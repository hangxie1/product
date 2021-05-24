package com.cvshealth.xplab.sample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDTO {
    String productName;
    Long quantity;
    Double price;
}
