package com.adegadopaibackend.adegadopaibackend.controller;

import com.adegadopaibackend.adegadopaibackend.dto.request.CreateOrderRequest;
import com.adegadopaibackend.adegadopaibackend.dto.response.OrderResponse;
import com.adegadopaibackend.adegadopaibackend.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/user/{userId}")
    public ResponseEntity<OrderResponse> create(@PathVariable Long userId,
                                                @Valid @RequestBody CreateOrderRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.create(userId, req));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderResponse>> findAllByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(orderService.findAllByUserId(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<OrderResponse> updateStatus(@PathVariable Long id,
                                                      @RequestParam String status) {
        return ResponseEntity.ok(orderService.updateStatus(id, status));
    }
}
