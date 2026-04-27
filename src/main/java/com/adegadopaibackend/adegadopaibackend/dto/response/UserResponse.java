package com.adegadopaibackend.adegadopaibackend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Long id;

    private String email;

    private String name;

    private String phone;

    private String role;

    private LocalDateTime createdAt;

    private List<AddressResponse> addresses;
}
