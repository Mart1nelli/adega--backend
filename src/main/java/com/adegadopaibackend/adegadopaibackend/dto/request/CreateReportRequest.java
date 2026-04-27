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
public class CreateReportRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String type;

    private String data;
}
