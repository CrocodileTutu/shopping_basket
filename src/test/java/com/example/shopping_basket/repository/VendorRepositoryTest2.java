package com.example.shopping_basket.repository;

import com.example.shopping_basket.model.StoreModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class VendorRepositoryTest2 {

    @Autowired
    private StoreRepository underTest;

    @Test
    void saveItemTest() {
        // given
//        StoreModel product = StoreModel.builder()
//                .id(1L)
//                .name("Book")
//                .quantity(1)
//                .imported(false)
//                .bookFoodMedical(true)
//                .price(14.45)
//                .shelfPrice(14.45)
//                .taxes(0.0)
//                .build();

        StoreModel product1 =
                new StoreModel(1L, "Apple", 1, false, false, 3.95, 3.95, 0.0);

        // when
        underTest.save(product1);

        // then
        assertThat(product1.getId()).isGreaterThan(0);
    }

}
