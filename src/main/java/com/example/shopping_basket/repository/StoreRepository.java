package com.example.shopping_basket.repository;

import com.example.shopping_basket.model.StoreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<StoreModel, Long> {
}
