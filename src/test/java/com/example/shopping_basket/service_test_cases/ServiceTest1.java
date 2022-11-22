package com.example.shopping_basket.service_test_cases;

import com.example.shopping_basket.model.StoreModel;
import com.example.shopping_basket.service.StoreServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceTest1 {

    @Autowired
    private StoreServiceImpl underTest;

    @Test
    void testCase1() {
        underTest.save(new StoreModel());
    }

    @Test
    void testCase2() {
        underTest.save(new StoreModel(1200L, "Music CD", 1, true, true, 15.99, null, null));
    }

}
