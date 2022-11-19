package com.example.shopping_basket.repository;

import com.example.shopping_basket.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Long> {
    OrderModel findBySessionToken(String sessionToken);
}
