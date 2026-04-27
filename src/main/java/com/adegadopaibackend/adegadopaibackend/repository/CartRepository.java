package com.adegadopaibackend.adegadopaibackend.repository;

import com.adegadopaibackend.adegadopaibackend.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUserIdAndCreatedAtIsNull(Long userId); // Carrinho ativo
    Optional<Cart> findTopByUserIdOrderByUpdatedAtDesc(Long userId);
}
