package com.example.shopping_basket.repository;

import com.example.shopping_basket.model.StoreModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StoreRepositoryTest {
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setup() {
        StoreModel store = new StoreModel(1L, "Book", 1, false, false, 14.49, 14.49, 0.0);
        entityManager.persist(store);
    }

    @Test
    void testFindById() {
        StoreModel storeModel = storeRepository.findById(1L).orElseThrow();
        System.out.println(storeModel.getName());
        System.out.println(storeModel.getId());
        assertEquals("Book", storeModel.getName());
    }
}
