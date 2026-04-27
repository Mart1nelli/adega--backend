package com.adegadopaibackend.adegadopaibackend.service.serviceImpl;

import com.adegadopaibackend.adegadopaibackend.dto.request.CreatePaymentRequest;
import com.adegadopaibackend.adegadopaibackend.dto.response.PaymentResponse;
import com.adegadopaibackend.adegadopaibackend.entity.Order;
import com.adegadopaibackend.adegadopaibackend.entity.Payment;
import com.adegadopaibackend.adegadopaibackend.entity.PaymentMethod;
import com.adegadopaibackend.adegadopaibackend.entity.User;
import com.adegadopaibackend.adegadopaibackend.mapper.PaymentMapper;
import com.adegadopaibackend.adegadopaibackend.repository.OrderRepository;
import com.adegadopaibackend.adegadopaibackend.repository.PaymentMethodRepository;
import com.adegadopaibackend.adegadopaibackend.repository.PaymentRepository;
import com.adegadopaibackend.adegadopaibackend.repository.UserRepository;
import com.adegadopaibackend.adegadopaibackend.service.PaymentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public PaymentResponse create(Long userId, CreatePaymentRequest req) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User with ID: " + userId + " not found"));

        Order order = orderRepository.findById(req.getOrderId())
                .orElseThrow(() -> new EntityNotFoundException("Order with ID: " + req.getOrderId() + " not found"));

        PaymentMethod method = paymentMethodRepository.findById(req.getPaymentMethodId())
                .orElseThrow(() -> new EntityNotFoundException("Payment method with ID: " + req.getPaymentMethodId() + " not found"));

        Payment payment = Payment.builder()
                .user(user)
                .order(order)
                .method(method)
                .amount(order.getTotalAmount())
                .status("PENDING")
                .build();

        Payment savedPayment = paymentRepository.save(payment);
        return paymentMapper.toResponse(savedPayment);
    }

    @Override
    public List<PaymentResponse> findByOrderId(Long orderId) {
        return paymentMapper.toResponseList(paymentRepository.findByOrderId(orderId));
    }

    @Override
    public List<PaymentResponse> findByUserId(Long userId) {
        return paymentMapper.toResponseList(paymentRepository.findByUserIdOrderByCreatedAtDesc(userId));
    }
}
