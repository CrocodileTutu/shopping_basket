package com.example.shopping_basket.service;

import com.example.shopping_basket.model.StoreModel;
import com.example.shopping_basket.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.Sort.Direction.DESC;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    @Autowired
    public StoreServiceImpl(StoreRepository storeRepository) {

        this.storeRepository = storeRepository;
    }

    @Override
    public List<StoreModel> getAllItems() {

        return storeRepository.findAll();
    }

    public List<StoreModel> getAllItemsSorted(String field) {

        return storeRepository.findAll(Sort.by(DESC, field));
    }

    @Override
    public void save(StoreModel storeModel) {

        storeRepository.save(storeModel);
    }

    @Override
    public StoreModel getItemById(Long id) {
        Optional<StoreModel> optionalSaleModel =
                storeRepository.findById(id);
        StoreModel storeModel;
        if(optionalSaleModel.isPresent()) {
            storeModel = optionalSaleModel.get();
        } else {
            throw new RuntimeException("Item not found with id : " + id);
        }
        return storeModel;
    }

    @Override
    public void deleteItemById(Long id) {

        storeRepository.deleteById(id);
    }

}
