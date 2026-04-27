package com.adegadopaibackend.adegadopaibackend.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest {

    @NotBlank
    private String name;

    private String description;

    @DecimalMin("0.01")
    private BigDecimal price;

    @Min(0)
    private Integer stock;

    @NotNull
    private Long categoryId;

    private Long supplierId;

    private String imageUrl;

    @NotNull
    private Boolean isActive;
}