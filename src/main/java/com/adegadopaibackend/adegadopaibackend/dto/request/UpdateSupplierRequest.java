package com.adegadopaibackend.adegadopaibackend.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSupplierRequest {

    @NotBlank
    private String name;

    @Email
    private String email;

    private String phone;

    private String address;
}
