package com.example.shopping_basket.service;

import com.example.shopping_basket.model.BuyingModel;
import com.example.shopping_basket.repository.BuyingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyingServiceImpl implements BuyingService {
    @Autowired
    private BuyingRepository buyingRepository;

    @Autowired
    private StoreService storeService;

    @Override
    public List<BuyingModel> getAllItems() {

        return buyingRepository.findAll();
    }

    @Override
    public void save(BuyingModel buyingModel) {

        buyingRepository.save(buyingModel);
    }

    @Override
    public BuyingModel getItemById(Long id) {
        Optional<BuyingModel> optionalBuyingModel =
                buyingRepository.findById(id);
        BuyingModel buyingModel;
        if(optionalBuyingModel.isPresent()) {
            buyingModel = optionalBuyingModel.get();
        } else {
            throw new RuntimeException("Item not found with id :" + id);
        }
        return buyingModel;
    }

    @Override
    public void deleteItemById(Long id) {
        buyingRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        buyingRepository.deleteAll();
    }

    @Override
    public Double getItemTaxById(Long id) {
        Double taxes = storeService.getItemById(id).getTaxes();
        return taxes;
    }

    @Override
    public Double getItemPriceById(Long id) {
        return storeService.getItemById(id).getPrice();
    }

    @Override
    public Double getItemPriceAndTaxById(Long id) {
        Double priceAndTax = 0.0;
        // ToDo : Implementation
        // not needed yet
        return priceAndTax;
    }

    @Override
    public Long getItemIdById(Long id) {
        return buyingRepository.findById(id).get().getItemId();
    }
}
