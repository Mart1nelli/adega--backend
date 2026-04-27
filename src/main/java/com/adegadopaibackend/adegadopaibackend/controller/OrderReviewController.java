package com.adegadopaibackend.adegadopaibackend.controller;

import com.adegadopaibackend.adegadopaibackend.dto.request.CreateOrderReviewRequest;
import com.adegadopaibackend.adegadopaibackend.dto.response.OrderReviewResponse;
import com.adegadopaibackend.adegadopaibackend.service.OrderReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order-reviews")
public class OrderReviewController {

    private final OrderReviewService orderReviewService;

    @PostMapping("/user/{userId}/order/{orderId}")
    public ResponseEntity<OrderReviewResponse> create(@PathVariable Long userId,
                                                      @PathVariable Long orderId,
                                                      @Valid @RequestBody CreateOrderReviewRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderReviewService.create(userId, orderId, req));
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<OrderReviewResponse>> findByOrderId(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderReviewService.findByOrderId(orderId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderReviewResponse>> findByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(orderReviewService.findByUserId(userId));
    }
}
