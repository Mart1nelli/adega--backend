package com.adegadopaibackend.adegadopaibackend.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateOrderRequest {

    @NotNull
    private Long addressId;

    @NotNull
    private Long paymentMethodId;
}
