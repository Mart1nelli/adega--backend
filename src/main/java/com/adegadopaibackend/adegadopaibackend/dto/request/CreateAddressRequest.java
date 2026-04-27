package com.adegadopaibackend.adegadopaibackend.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateAddressRequest {

    @NotBlank
    private String street;

    private String number;

    private String complement;

    @NotBlank
    private String city;

    @NotBlank @Size(min=2,max=2)
    private String state;

    @Pattern(regexp="\\d{5}-?\\d{3}")
    private String zipCode;

    @Builder.Default
    private Boolean isDefault = false;
}
