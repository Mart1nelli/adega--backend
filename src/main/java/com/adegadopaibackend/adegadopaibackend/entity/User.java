package com.adegadopaibackend.adegadopaibackend.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(exclude = {
        "orders", "carts", "addresses", "reviews",
        "notifications", "payments", "orderReviews"
})
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    private String phone;

    @Builder.Default
    private String role = "user";

    @Min(0)
    @Builder.Default
    private Integer failedAttempts = 0;

    private LocalDateTime lockUntil;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OrderBy("createdAt DESC")
    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<Address> addresses = new ArrayList<>();

    @OrderBy("createdAt DESC")
    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Order> orders = new ArrayList<>();

    @OrderBy("createdAt DESC")
    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Cart> carts = new ArrayList<>();

    @OrderBy("createdAt DESC")
    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Review> reviews = new ArrayList<>();

    @OrderBy("createdAt DESC")
    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Notification> notifications = new ArrayList<>();

    @OrderBy("createdAt DESC")
    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Payment> payments = new ArrayList<>();

    @OrderBy("createdAt DESC")
    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @Builder.Default
    private List<OrderReview> orderReviews = new ArrayList<>();
}
