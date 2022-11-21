package com.example.shopping_basket.service;


import com.example.shopping_basket.model.BuyingModel;
import java.util.List;

public interface BuyingService {
//    BuyingModel addToOrder(BuyingModel buyingModel);

    List<BuyingModel> getAllItems();

    void save(BuyingModel buyingModel);

    BuyingModel getItemById(Long id);

    void deleteItemById(Long id);

    void deleteAll();

    Double getItemTaxById(Long id);

    Double getItemPriceById(Long id);

    Double getItemPriceAndTaxById(Long id);

    Long getItemIdById(Long id);
}
