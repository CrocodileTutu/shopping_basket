package com.example.shopping_basket.model_test_cases;

import com.example.shopping_basket.controller.StoreController;
import com.example.shopping_basket.model.StoreModel;
import com.example.shopping_basket.service.StoreServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@WebMvcTest(StoreController.class)
class StoreModelTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private StoreServiceImpl storeService;
    @Captor
    private ArgumentCaptor<StoreModel> argumentCaptor;

    @Test
    void addNewItemShouldBeRecordInDatabase() {
        StoreModel model = new StoreModel();
        model.setName("Apple (kg)");
        model.setPrice(2.50);
        model.setQuantity(500);
        model.setImported(false);
        model.setBookFoodMedical(true);

        storeService.save(model);

        String res = model.toString();
        String exp = "StoreModel(id=null, name=Apple (kg), quantity=500, price=2.5, imported=false, bookFoodMedical=true)";

        assertEquals(exp,res);
    }

    @Test
    void updateAnItemShouldBeRecordInDatabase() {
        StoreModel model = new StoreModel();
        model.setId(2L);
        model.setName("Apple (kg)");
        model.setPrice(2.99);
        model.setQuantity(500);
        model.setImported(true);
        model.setBookFoodMedical(true);

        storeService.save(model);

        String res =  model.toString();
        String exp = "StoreModel(id=2, name=Apple (kg), quantity=500, price=2.99, imported=true, bookFoodMedical=true)";

        assertEquals(exp,res);
    }
}