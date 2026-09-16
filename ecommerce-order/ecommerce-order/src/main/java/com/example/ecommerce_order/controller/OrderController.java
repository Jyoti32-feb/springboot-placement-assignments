package com.example.ecommerce_order.controller;

import com.example.ecommerce_order.dto.OrderResponse;
import com.example.ecommerce_order.entity.CustomerOrder;
import com.example.ecommerce_order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody CustomerOrder order) {
        OrderResponse orderResponse = orderService.placeOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable String id) {
        OrderResponse response=orderService.getOrder(id);
        return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        List<OrderResponse> orderResponse=orderService.getAllOrders();
        return ResponseEntity.ok(orderResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderResponse> updateOrder(@PathVariable String id, @RequestBody CustomerOrder order) {
        OrderResponse orderResponse=orderService.updateOrder(id,order);
        return ResponseEntity.ok(orderResponse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable String id) {
        String str=orderService.deleteOrder(id);
        return ResponseEntity.ok(str);
    }
}
