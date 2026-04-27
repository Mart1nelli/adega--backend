package com.adegadopaibackend.adegadopaibackend.repository;

import com.adegadopaibackend.adegadopaibackend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserIdOrderByCreatedAtDesc(Long userId);
    List<Order> findByUserIdAndStatusOrderByCreatedAtDesc(Long userId, String status);

    @Query("SELECT SUM(o.totalAmount) FROM Order o WHERE o.user.id = :userId")
    BigDecimal getTotalSpentByUser(Long userId);
}
