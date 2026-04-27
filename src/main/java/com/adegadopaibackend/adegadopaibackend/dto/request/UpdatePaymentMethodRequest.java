package com.adegadopaibackend.adegadopaibackend.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePaymentMethodRequest {

    @NotBlank
    private String name;

    private String description;

    private Boolean isActive;
}
