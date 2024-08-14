package com.excelr.service;

import java.time.LocalDateTime;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.enu.OrderStatus;
import com.excelr.exception.OrderNotFoundException;
import com.excelr.model.Order;
import com.excelr.model.OrderItem;
import com.excelr.model.OrderItemRequest;
import com.excelr.model.User;
import com.excelr.repo.OrderItemRepository;
import com.excelr.repo.OrderRepository;
import com.excelr.repo.UserRepository;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository; 
    
    public Order placeOrder(Order order) {
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("Placed");
        return orderRepository.save(order);
    }
    
   
    public List<Order> getOrderHistory(Long userId) {
        return orderRepository.findByUserId(userId);
    }
    
    public Order trackOrder(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }
    
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    
    public Order updateOrderStatus(Long orderId, String status) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            order.setStatus(status);
            return orderRepository.save(order);
        }
        return null;
    }
    
}