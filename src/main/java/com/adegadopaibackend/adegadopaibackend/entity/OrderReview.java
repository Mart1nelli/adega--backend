package com.adegadopaibackend.adegadopaibackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(exclude = {"order", "user"})
@Table(name = "order_reviews")
public class OrderReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(1) @Max(5)
    private int rating;

    @Size(max = 1000)
    private String comment;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    @JsonBackReference
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    @JsonBackReference
    private User user;
}
