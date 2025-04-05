package com.payment.payment.service;

import com.payment.payment.model.Order;
import com.payment.payment.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order updatedOrder) {
        return orderRepository.findById(id).map(existingOrder -> {
            existingOrder.setOrderStatus(updatedOrder.getOrderStatus());
            existingOrder.setTotalAmount(updatedOrder.getTotalAmount());
            existingOrder.setUser(updatedOrder.getUser());
            return orderRepository.save(existingOrder);
        }).orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    // ✅ FIXED method call
    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUser_UserId(userId);
    }

    public String deleteOrder(Long orderId) {
        if (!orderRepository.existsById(orderId)) {
            return "Order not found!";
        }
        orderRepository.deleteById(orderId);
        return "Order deleted successfully!";
    }
}
