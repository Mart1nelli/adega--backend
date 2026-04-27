package com.adegadopaibackend.adegadopaibackend.service;

import com.adegadopaibackend.adegadopaibackend.dto.request.CreateAddressRequest;
import com.adegadopaibackend.adegadopaibackend.dto.request.UpdateAddressRequest;
import com.adegadopaibackend.adegadopaibackend.dto.response.AddressResponse;

import java.util.List;

public interface AddressService {

    AddressResponse create(Long userId, CreateAddressRequest req);

    List<AddressResponse> findAllByUserId(Long userId);

    AddressResponse findById(Long id);

    AddressResponse update(Long id, UpdateAddressRequest req);

    void delete(Long id);
}
