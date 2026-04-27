package com.adegadopaibackend.adegadopaibackend.service;

import com.adegadopaibackend.adegadopaibackend.dto.request.AddToCartRequest;
import com.adegadopaibackend.adegadopaibackend.dto.response.CartResponse;

public interface CartService {

    CartResponse getOrCreateCart(Long userId);

    CartResponse addItem(Long userId, AddToCartRequest req);

    CartResponse updateItem(Long userId, Long cartItemId, Integer quantity);

    CartResponse removeItem(Long userId, Long cartItemId);

    void clearCart(Long userId);
}
