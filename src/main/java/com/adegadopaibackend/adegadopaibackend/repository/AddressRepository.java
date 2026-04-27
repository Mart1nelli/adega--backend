package com.adegadopaibackend.adegadopaibackend.repository;

import com.adegadopaibackend.adegadopaibackend.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByUserIdAndIsDefaultTrue(Long userId);
    List<Address> findByUserIdOrderByCreatedAtDesc(Long userId);
}
