package com.adegadopaibackend.adegadopaibackend.service;

import com.adegadopaibackend.adegadopaibackend.dto.request.CreateOrderRequest;
import com.adegadopaibackend.adegadopaibackend.dto.response.OrderResponse;

import java.util.List;

public interface OrderService {

    OrderResponse create(Long userId, CreateOrderRequest req);

    List<OrderResponse> findAllByUserId(Long userId);

    OrderResponse findById(Long id);

    OrderResponse updateStatus(Long id, String status);
}
