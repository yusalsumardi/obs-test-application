package com.obs.test.models;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity(name = "order_data")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderNo;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @Column(nullable = false)
    private int qty;
}
