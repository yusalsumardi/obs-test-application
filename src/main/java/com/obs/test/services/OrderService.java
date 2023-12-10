package com.obs.test.services;

import com.obs.test.models.Order;
import com.obs.test.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order getOrderById(Long orderNo) {
        return orderRepository.findById(orderNo).orElse(null);
    }

    public Page<Order> getAllOrders(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long orderNo, Order order) {
        if (orderRepository.existsById(orderNo)) {
            order.setOrderNo(orderNo);
            return orderRepository.save(order);
        } else {
            return null;
        }
    }

    public void deleteOrder(Long orderNo) {
        orderRepository.deleteById(orderNo);
    }
}
