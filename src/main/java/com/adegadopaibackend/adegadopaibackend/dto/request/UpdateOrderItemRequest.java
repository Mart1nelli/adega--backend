package com.adegadopaibackend.adegadopaibackend.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrderItemRequest {

    @Min(1)
    private Integer quantity;

    @DecimalMin("0.01")
    private BigDecimal price;
}
