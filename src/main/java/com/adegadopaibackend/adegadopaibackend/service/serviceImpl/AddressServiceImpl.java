package com.adegadopaibackend.adegadopaibackend.service.serviceImpl;

import com.adegadopaibackend.adegadopaibackend.dto.request.CreateAddressRequest;
import com.adegadopaibackend.adegadopaibackend.dto.request.UpdateAddressRequest;
import com.adegadopaibackend.adegadopaibackend.dto.response.AddressResponse;
import com.adegadopaibackend.adegadopaibackend.entity.Address;
import com.adegadopaibackend.adegadopaibackend.entity.User;
import com.adegadopaibackend.adegadopaibackend.mapper.AddressMapper;
import com.adegadopaibackend.adegadopaibackend.repository.AddressRepository;
import com.adegadopaibackend.adegadopaibackend.repository.UserRepository;
import com.adegadopaibackend.adegadopaibackend.service.AddressService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final AddressMapper addressMapper;

    @Override
    public AddressResponse create(Long userId, CreateAddressRequest req) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User with ID: " + userId + " not found"));

        Address address = addressMapper.toEntity(req);
        address.setUser(user);
        Address savedAddress = addressRepository.save(address);
        return addressMapper.toResponse(savedAddress);
    }

    @Override
    public List<AddressResponse> findAllByUserId(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new EntityNotFoundException("User with ID: " + userId + " not found");
        }
        return addressMapper.toResponseList(addressRepository.findByUserIdOrderByCreatedAtDesc(userId));
    }

    @Override
    public AddressResponse findById(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Address with ID: " + id + " not found"));
        return addressMapper.toResponse(address);
    }

    @Override
    public AddressResponse update(Long id, UpdateAddressRequest req) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Address with ID: " + id + " not found"));

        addressMapper.updateEntity(req, address);
        Address updatedAddress = addressRepository.save(address);
        return addressMapper.toResponse(updatedAddress);
    }

    @Override
    public void delete(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Address with ID: " + id + " not found"));
        addressRepository.delete(address);
    }
}
