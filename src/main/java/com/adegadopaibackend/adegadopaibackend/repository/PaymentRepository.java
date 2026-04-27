package com.adegadopaibackend.adegadopaibackend.repository;

import com.adegadopaibackend.adegadopaibackend.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByOrderId(Long orderId);
    List<Payment> findByUserIdOrderByCreatedAtDesc(Long userId);
}
