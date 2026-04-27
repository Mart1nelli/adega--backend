package com.adegadopaibackend.adegadopaibackend.service;

import com.adegadopaibackend.adegadopaibackend.dto.request.CreateOrderReviewRequest;
import com.adegadopaibackend.adegadopaibackend.dto.response.OrderReviewResponse;

import java.util.List;

public interface OrderReviewService {

    OrderReviewResponse create(Long userId, Long orderId, CreateOrderReviewRequest req);

    List<OrderReviewResponse> findByOrderId(Long orderId);

    List<OrderReviewResponse> findByUserId(Long userId);
}
