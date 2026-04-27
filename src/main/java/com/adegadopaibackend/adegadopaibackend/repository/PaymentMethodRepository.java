package com.adegadopaibackend.adegadopaibackend.repository;


import com.adegadopaibackend.adegadopaibackend.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

}
