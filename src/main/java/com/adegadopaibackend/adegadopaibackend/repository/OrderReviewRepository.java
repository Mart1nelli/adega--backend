package com.adegadopaibackend.adegadopaibackend.repository;

import com.adegadopaibackend.adegadopaibackend.entity.OrderReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderReviewRepository extends JpaRepository<OrderReview, Long> {
    List<OrderReview> findByOrderIdOrderByCreatedAtDesc(Long orderId);
    List<OrderReview> findByUserIdOrderByCreatedAtDesc(Long userId);
}
