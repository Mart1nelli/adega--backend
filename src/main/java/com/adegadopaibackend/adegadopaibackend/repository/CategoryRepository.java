package com.adegadopaibackend.adegadopaibackend.repository;

import com.adegadopaibackend.adegadopaibackend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByNameIgnoreCase(String name);
    boolean existsByName (String name);
    boolean existsByNameAndIdNot(String name, Long id);
}
