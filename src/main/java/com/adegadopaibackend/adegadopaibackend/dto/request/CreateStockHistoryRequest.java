package com.adegadopaibackend.adegadopaibackend.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateStockHistoryRequest {

    @Min(-999999)
    @Max(999999)
    private Integer change;

    @NotBlank
    private String reason;
}
