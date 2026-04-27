package com.adegadopaibackend.adegadopaibackend.repository;

import com.adegadopaibackend.adegadopaibackend.entity.Product;
import jakarta.validation.constraints.Min;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryIdAndIsActiveTrue(Long categoryId);
    List<Product> findByIsActiveTrueAndStockGreaterThanOrderByCreatedAtDesc(Integer stock);

    @Query("SELECT p FROM Product p WHERE " +
            "LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')) AND p.isActive = true")
    List<Product> searchByName(String name);
}
