package com.adegadopaibackend.adegadopaibackend.mapper;

import com.adegadopaibackend.adegadopaibackend.dto.request.CreateOrderReviewRequest;
import com.adegadopaibackend.adegadopaibackend.dto.response.OrderReviewResponse;
import com.adegadopaibackend.adegadopaibackend.entity.OrderReview;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderReviewMapper {

    OrderReviewResponse toResponse(OrderReview orderReview);

    List<OrderReviewResponse> toResponseList(List<OrderReview> orderReviews);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "order", ignore = true)
    @Mapping(target = "user", ignore = true)
    OrderReview toEntity(CreateOrderReviewRequest request);
}
