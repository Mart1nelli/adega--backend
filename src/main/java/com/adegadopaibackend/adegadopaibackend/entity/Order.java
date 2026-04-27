package com.adegadopaibackend.adegadopaibackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(exclude = {
        "orderItems", "payments", "orderReviews",
        "user", "address"
})
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DecimalMin("0.01")
    private BigDecimal totalAmount;

    @NotNull
    private String status;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    @JsonBackReference
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "addressId")
    @JsonBackReference
    private Address address;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @OrderBy("id")
    @JsonManagedReference
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Payment> payments = new ArrayList<>();

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<OrderReview> orderReviews = new ArrayList<>();
}
