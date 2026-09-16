package com.example.ecommerce_order.service;

import com.example.ecommerce_order.dto.OrderResponse;
import com.example.ecommerce_order.entity.CustomerOrder;
import com.example.ecommerce_order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public OrderResponse placeOrder(CustomerOrder customerOrder) {
        CustomerOrder order = orderRepository.save(customerOrder);
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setCustomerName(order.getCustomerName());
        orderResponse.setOrderId(order.getOrderId());
        orderResponse.setDiscountAmount(order.getDiscountPercent());
        return orderResponse;

    }
    public OrderResponse getOrder(String orderId) {
        CustomerOrder order=orderRepository.findById(Integer.valueOf(orderId)).orElseThrow(()->new RuntimeException("order not found"));
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setCustomerName(order.getCustomerName());
        orderResponse.setOrderId(order.getOrderId());
        orderResponse.setDiscountAmount(order.getDiscountPercent());
        return orderResponse;
    }

    public List<OrderResponse> getAllOrders() {
        List<CustomerOrder> orders = orderRepository.findAll();
        List<OrderResponse> orderResponseList = new ArrayList<>();
        for (CustomerOrder order : orders) {
            OrderResponse orderResponse = new OrderResponse();
            orderResponse.setCustomerName(order.getCustomerName());
            orderResponse.setOrderId(order.getOrderId());
            orderResponse.setDiscountAmount(order.getDiscountPercent());
            orderResponseList.add(orderResponse);

        }
        return orderResponseList;
    }
    public OrderResponse updateOrder(String orderId, CustomerOrder customerOrder) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setCustomerName(customerOrder.getCustomerName());
        orderResponse.setOrderId(customerOrder.getOrderId());
        orderResponse.setDiscountAmount(customerOrder.getDiscountPercent());
        return orderResponse;
    }

    public String deleteOrder(String orderId) {
        boolean exists = orderRepository.existsById(Integer.valueOf(orderId));
        if (!exists) {
            throw new RuntimeException("order not found");
        }
        orderRepository.deleteById(Integer.valueOf(orderId));

        return "order deleted";

    }
}
