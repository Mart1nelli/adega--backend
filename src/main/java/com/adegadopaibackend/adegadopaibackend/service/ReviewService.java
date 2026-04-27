package com.adegadopaibackend.adegadopaibackend.service;

import com.adegadopaibackend.adegadopaibackend.dto.request.CreateReviewRequest;
import com.adegadopaibackend.adegadopaibackend.dto.response.ReviewResponse;

import java.util.List;

public interface ReviewService {

    ReviewResponse create(Long userId, Long productId, CreateReviewRequest req);

    List<ReviewResponse> findByProductId(Long productId);

    List<ReviewResponse> findByUserId(Long userId);

    void delete(Long id);
}
