package com.adegadopaibackend.adegadopaibackend.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePaymentRequest {

    @NotNull
    private Long orderId;

    @NotNull
    private Long paymentMethodId;
}
