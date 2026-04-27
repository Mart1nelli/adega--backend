package com.adegadopaibackend.adegadopaibackend.service.serviceImpl;

import com.adegadopaibackend.adegadopaibackend.dto.request.CreateUserRequest;
import com.adegadopaibackend.adegadopaibackend.dto.request.UpdateUserRequest;
import com.adegadopaibackend.adegadopaibackend.dto.response.UserResponse;
import com.adegadopaibackend.adegadopaibackend.entity.User;
import com.adegadopaibackend.adegadopaibackend.mapper.UserMapper;
import com.adegadopaibackend.adegadopaibackend.repository.UserRepository;
import com.adegadopaibackend.adegadopaibackend.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse create(CreateUserRequest req) {
        if (userRepository.existsByEmail(req.getEmail())) {
            throw new IllegalArgumentException("Email already in use");
        }

        User user = userMapper.toEntity(req);
        User savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }

    @Override
    public List<UserResponse> findAll() {
        return userMapper.toResponseList(userRepository.findAll());
    }

    @Override
    public UserResponse findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with ID: " + id + " not found"));
        return userMapper.toResponse(user);
    }

    @Override
    public UserResponse update(Long id, UpdateUserRequest req) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with ID: " + id + " not found"));

        userMapper.updateEntity(req, user);
        User updatedUser = userRepository.save(user);
        return userMapper.toResponse(updatedUser);
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with ID: " + id + " not found"));
        userRepository.delete(user);
    }
}
