package com.example.shopping_basket.repository;

import com.example.shopping_basket.model.BuyingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyingRepository extends JpaRepository<BuyingModel, Long> {
}
