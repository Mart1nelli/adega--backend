package com.adegadopaibackend.adegadopaibackend.dto.request;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAddressRequest {

    private String street;

    private String number;

    private String complement;

    private String neighborhood;

    private String city;

    @Size(min = 2, max = 2)
    private String state;

    @Pattern(regexp = "^[0-9]{5}-[0-9]{3}$")
    private String zipCode;

    private String country;

    private Boolean isDefault;
}
