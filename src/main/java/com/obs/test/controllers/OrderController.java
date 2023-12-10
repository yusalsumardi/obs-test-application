package com.obs.test.controllers;

import com.obs.test.models.Order;
import com.obs.test.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{orderNo}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderNo) {
        Order order = orderService.getOrderById(orderNo);
        return ResponseEntity.ok(order);
    }

    @GetMapping
    public ResponseEntity<Page<Order>> getAllOrders(Pageable pageable) {
        Page<Order> orders = orderService.getAllOrders(pageable);
        return ResponseEntity.ok(orders);
    }

    @PostMapping
    public ResponseEntity<Order> saveOrder(@RequestBody @Valid Order order) {
        Order savedOrder = orderService.saveOrder(order);
        return ResponseEntity.ok(savedOrder);
    }

    @PutMapping("/{orderNo}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long orderNo, @RequestBody @Valid Order order) {
        Order updatedOrder = orderService.updateOrder(orderNo, order);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{orderNo}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderNo) {
        orderService.deleteOrder(orderNo);
        return ResponseEntity.noContent().build();
    }
}