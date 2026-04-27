package com.adegadopaibackend.adegadopaibackend.service;

import com.adegadopaibackend.adegadopaibackend.dto.request.CreatePaymentMethodRequest;
import com.adegadopaibackend.adegadopaibackend.dto.request.UpdatePaymentMethodRequest;
import com.adegadopaibackend.adegadopaibackend.dto.response.PaymentMethodResponse;

import java.util.List;

public interface PaymentMethodService {

    PaymentMethodResponse create(CreatePaymentMethodRequest req);

    List<PaymentMethodResponse> findAll();

    PaymentMethodResponse findById(Long id);

    PaymentMethodResponse update(Long id, UpdatePaymentMethodRequest req);

    void delete(Long id);
}
