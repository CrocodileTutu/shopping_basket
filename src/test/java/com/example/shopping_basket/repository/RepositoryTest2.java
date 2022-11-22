package com.example.shopping_basket.repository;

import com.example.shopping_basket.model.StoreModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;


//@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest
public class RepositoryTest2 {

    @Autowired
    private StoreRepository underTest;

//    @Autowired
//    private TestEntityManager entityManager;

//    @Autowired
//    MockMvc mockMvc;
//
//    @Mock
//    private StoreModel product;

//    @BeforeEach
//    void setup1() {
//        StoreModel prod1 = new StoreModel(2000L, "Book", 1, false, false, 14.49, 14.49, 0.0);
//        entityManager.persist(prod1);
//    }
//
//    @BeforeEach
//    void setup2() {
//        StoreModel prod1 = new StoreModel(2000L, "Book", 1, false, false, 14.49, 14.49, 0.0);
//        entityManager.persist(prod1);
//    }

    @Test
    public void testCase1() throws Exception {
        underTest.save(new StoreModel());
    }

    @Test
    public void testCase2() throws Exception {
        underTest.delete(new StoreModel());
    }

    @Test
    public void testCase3() throws Exception {
        underTest.deleteAll();
    }

    @Test
    public void testCase5() throws Exception {
        underTest.findAll();
    }

    @Test
    void testCase6() {
        underTest.save(new StoreModel(1200L, "Music CD", 1, true, true, 15.99, null, null));
    }

    @Test
    void testCase7() {
        underTest.deleteAll(Arrays.asList(
                new StoreModel(101L, "Music CD", 1, true, false, 15.99, null, null),
                new StoreModel(102L, "Book", 1, true, true, 12.49, null, null),
                new StoreModel(103L, "Perfume", 1, true, false, 49.99, null, null)
        ));
    }
}