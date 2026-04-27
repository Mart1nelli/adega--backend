package com.adegadopaibackend.adegadopaibackend.mapper;

import com.adegadopaibackend.adegadopaibackend.dto.response.CartResponse;
import com.adegadopaibackend.adegadopaibackend.entity.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CartItemMapper.class)
public interface CartMapper {

    @Mapping(target = "items", source = "cartItems")
    CartResponse toResponse(Cart cart);
}