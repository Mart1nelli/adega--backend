package com.adegadopaibackend.adegadopaibackend.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateReviewRequest {

    @Min(1) @Max(5)
    private Integer rating;

    private String comment;
}
