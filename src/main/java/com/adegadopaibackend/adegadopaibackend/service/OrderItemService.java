package com.adegadopaibackend.adegadopaibackend.service;

import java.util.List;

import com.adegadopaibackend.adegadopaibackend.dto.request.CreateOrderItemRequest;
import com.adegadopaibackend.adegadopaibackend.dto.request.UpdateOrderItemRequest;
import com.adegadopaibackend.adegadopaibackend.dto.response.OrderItemResponse;

public interface OrderItemService {

    OrderItemResponse create(CreateOrderItemRequest req);

    List<OrderItemResponse> findAll();

    OrderItemResponse findById(Long id);

    OrderItemResponse update(Long id, UpdateOrderItemRequest req);

    void delete(Long id);
}
