package com.example.springboot.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "price_at_purchase", nullable = false)
    private BigDecimal priceAtPurchase;

    // Many OrderItems belong to one Order
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    // Many OrderItems can belong to one Product
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}