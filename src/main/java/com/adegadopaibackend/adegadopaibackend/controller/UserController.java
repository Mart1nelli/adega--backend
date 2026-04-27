package com.adegadopaibackend.adegadopaibackend.controller;

import com.adegadopaibackend.adegadopaibackend.dto.request.CreateUserRequest;
import com.adegadopaibackend.adegadopaibackend.dto.request.UpdateUserRequest;
import com.adegadopaibackend.adegadopaibackend.dto.response.UserResponse;
import com.adegadopaibackend.adegadopaibackend.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> create(@Valid @RequestBody CreateUserRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(req));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable Long id, @Valid @RequestBody UpdateUserRequest req) {
        return ResponseEntity.ok(userService.update(id, req));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
