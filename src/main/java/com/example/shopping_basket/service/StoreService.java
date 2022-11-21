package com.example.shopping_basket.service;

import com.example.shopping_basket.model.StoreModel;

import java.util.List;

public interface StoreService {
    List<StoreModel> getAllItems();
    void save(StoreModel storeModel);
    StoreModel getItemById(Long id);
    void deleteItemById(Long id);

}
