package com.adegadopaibackend.adegadopaibackend.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddToCartRequest {

    @NotNull
    private Long productId;

    @Min(1)
    @Builder.Default
    private Integer quantity = 1;
}
