package com.adegadopaibackend.adegadopaibackend.service.serviceImpl;

import com.adegadopaibackend.adegadopaibackend.dto.request.CreateOrderRequest;
import com.adegadopaibackend.adegadopaibackend.dto.response.OrderResponse;
import com.adegadopaibackend.adegadopaibackend.entity.*;
import com.adegadopaibackend.adegadopaibackend.mapper.OrderMapper;
import com.adegadopaibackend.adegadopaibackend.repository.*;
import com.adegadopaibackend.adegadopaibackend.service.OrderService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final CartRepository cartRepository;
    private final OrderMapper orderMapper;

    @Override
    @Transactional
    public OrderResponse create(Long userId, CreateOrderRequest req) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User with ID: " + userId + " not found"));

        Address address = addressRepository.findById(req.getAddressId())
                .orElseThrow(() -> new EntityNotFoundException("Address with ID: " + req.getAddressId() + " not found"));

        Cart cart = cartRepository.findTopByUserIdOrderByUpdatedAtDesc(userId)
                .orElseThrow(() -> new IllegalArgumentException("No active cart found for user"));

        if (cart.getCartItems().isEmpty()) {
            throw new IllegalArgumentException("Cart is empty");
        }

        BigDecimal total = cart.getCartItems().stream()
                .map(item -> item.getProduct().getPrice()
                        .multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Order order = Order.builder()
                .user(user)
                .address(address)
                .totalAmount(total)
                .status("PENDING")
                .build();

        for (CartItem cartItem : cart.getCartItems()) {
            OrderItem orderItem = OrderItem.builder()
                    .order(order)
                    .product(cartItem.getProduct())
                    .quantity(cartItem.getQuantity())
                    .price(cartItem.getProduct().getPrice())
                    .build();
            order.getOrderItems().add(orderItem);
        }

        cart.getCartItems().clear();
        cartRepository.save(cart);

        Order savedOrder = orderRepository.save(order);
        return orderMapper.toResponse(savedOrder);
    }

    @Override
    public List<OrderResponse> findAllByUserId(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new EntityNotFoundException("User with ID: " + userId + " not found");
        }
        return orderMapper.toResponseList(orderRepository.findByUserIdOrderByCreatedAtDesc(userId));
    }

    @Override
    public OrderResponse findById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order with ID: " + id + " not found"));
        return orderMapper.toResponse(order);
    }

    @Override
    public OrderResponse updateStatus(Long id, String status) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order with ID: " + id + " not found"));

        order.setStatus(status);
        Order updatedOrder = orderRepository.save(order);
        return orderMapper.toResponse(updatedOrder);
    }
}
