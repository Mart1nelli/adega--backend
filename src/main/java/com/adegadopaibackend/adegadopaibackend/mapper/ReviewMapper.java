package com.adegadopaibackend.adegadopaibackend.mapper;

import com.adegadopaibackend.adegadopaibackend.dto.request.CreateReviewRequest;
import com.adegadopaibackend.adegadopaibackend.dto.response.ReviewResponse;
import com.adegadopaibackend.adegadopaibackend.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewResponse toResponse(Review review);
    List<ReviewResponse> toResponseList(List<Review> reviews);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "product", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Review toEntity(CreateReviewRequest request);
}