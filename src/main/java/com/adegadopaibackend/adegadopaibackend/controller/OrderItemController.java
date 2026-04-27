package com.adegadopaibackend.adegadopaibackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adegadopaibackend.adegadopaibackend.dto.request.CreateOrderItemRequest;
import com.adegadopaibackend.adegadopaibackend.dto.request.UpdateOrderItemRequest;
import com.adegadopaibackend.adegadopaibackend.dto.response.OrderItemResponse;
import com.adegadopaibackend.adegadopaibackend.service.OrderItemService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order-items")
public class OrderItemController {

    private final OrderItemService orderItemService;

    @PostMapping
    public ResponseEntity<OrderItemResponse> create(@Valid @RequestBody CreateOrderItemRequest req) {
        OrderItemResponse res = orderItemService.create(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @GetMapping
    public ResponseEntity<List<OrderItemResponse>> findAll() {
        return ResponseEntity.ok(orderItemService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(orderItemService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItemResponse> update(@PathVariable Long id, @Valid @RequestBody UpdateOrderItemRequest req) {
        return ResponseEntity.ok(orderItemService.update(id, req));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderItemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
