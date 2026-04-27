package com.adegadopaibackend.adegadopaibackend.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateCategoryRequest {

    @NotBlank
    private String name;

    private String description;
}
