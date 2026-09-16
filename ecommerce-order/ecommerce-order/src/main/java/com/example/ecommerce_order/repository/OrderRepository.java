package com.example.ecommerce_order.repository;

import com.example.ecommerce_order.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<CustomerOrder, Integer> {

}
