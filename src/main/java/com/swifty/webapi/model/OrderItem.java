package com.swifty.webapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;



@Entity
@NoArgsConstructor
@AllArgsConstructor @Data
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "orderId", nullable = false)
    private Order order;

    private Integer quantity;

    private Double subtotal;
}

