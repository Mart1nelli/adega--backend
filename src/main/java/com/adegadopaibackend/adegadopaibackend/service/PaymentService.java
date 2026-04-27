package com.adegadopaibackend.adegadopaibackend.service;

import com.adegadopaibackend.adegadopaibackend.dto.request.CreatePaymentRequest;
import com.adegadopaibackend.adegadopaibackend.dto.response.PaymentResponse;

import java.util.List;

public interface PaymentService {

    PaymentResponse create(Long userId, CreatePaymentRequest req);

    List<PaymentResponse> findByOrderId(Long orderId);

    List<PaymentResponse> findByUserId(Long userId);
}
