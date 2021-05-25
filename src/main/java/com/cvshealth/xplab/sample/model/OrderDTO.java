package com.cvshealth.xplab.sample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    Long  id;
    String customerName;
    String signedDate;
    List<OrderDetailDTO> orderDetailDTOS;
}
