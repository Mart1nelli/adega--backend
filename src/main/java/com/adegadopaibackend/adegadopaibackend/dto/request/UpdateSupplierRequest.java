package com.adegadopaibackend.adegadopaibackend.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateSupplierRequest {

    @NotBlank
    private String name;

    @Email
    private String email;

    private String phone;

    private String address;
}
