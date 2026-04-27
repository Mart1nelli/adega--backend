package com.adegadopaibackend.adegadopaibackend.mapper;

import com.adegadopaibackend.adegadopaibackend.dto.response.OrderResponse;
import com.adegadopaibackend.adegadopaibackend.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AddressMapper.class, OrderItemMapper.class})
public interface OrderMapper {

    @Mapping(target = "totalAmount", expression = "java(order.getTotalAmount() != null ? order.getTotalAmount().doubleValue() : 0.0)")
    OrderResponse toResponse(Order order);

    List<OrderResponse> toResponseList(List<Order> orders);
}
