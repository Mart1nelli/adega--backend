package com.adegadopaibackend.adegadopaibackend.service;

import com.adegadopaibackend.adegadopaibackend.dto.request.CreateSupplierRequest;
import com.adegadopaibackend.adegadopaibackend.dto.request.UpdateSupplierRequest;
import com.adegadopaibackend.adegadopaibackend.dto.response.SupplierResponse;

import java.util.List;

public interface SupplierService {

    SupplierResponse create(CreateSupplierRequest req);

    List<SupplierResponse> findAll();

    SupplierResponse findById(Long id);

    SupplierResponse update(Long id, UpdateSupplierRequest req);

    void delete(Long id);
}
