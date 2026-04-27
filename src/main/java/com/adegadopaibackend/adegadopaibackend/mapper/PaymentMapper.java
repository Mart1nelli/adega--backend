package com.adegadopaibackend.adegadopaibackend.mapper;

import com.adegadopaibackend.adegadopaibackend.dto.response.PaymentResponse;
import com.adegadopaibackend.adegadopaibackend.entity.Payment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentResponse toResponse(Payment payment);
    List<PaymentResponse> toResponseList(List<Payment> payments);
}
