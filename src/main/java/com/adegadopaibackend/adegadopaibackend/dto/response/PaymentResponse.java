package com.adegadopaibackend.adegadopaibackend.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PaymentResponse {

    private Long id;

    private BigDecimal amount;

    private String status;

    private String transactionId;
}
