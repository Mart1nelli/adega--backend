package com.adegadopaibackend.adegadopaibackend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {

    private Long id;

    private Double totalAmount;

    private String status;

    private LocalDateTime createdAt;

    private AddressResponse address;

    private List<OrderItemResponse> orderItems;
}
