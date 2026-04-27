package com.adegadopaibackend.adegadopaibackend.service;

import java.util.List;

import com.adegadopaibackend.adegadopaibackend.dto.request.CreateCartItemRequest;
import com.adegadopaibackend.adegadopaibackend.dto.request.UpdateCartItemRequest;
import com.adegadopaibackend.adegadopaibackend.dto.response.CartItemResponse;

public interface CartItemService {

    CartItemResponse create(CreateCartItemRequest req);

    List<CartItemResponse> findAll();

    CartItemResponse findById(Long id);

    CartItemResponse update(Long id, UpdateCartItemRequest req);

    void delete(Long id);
}
