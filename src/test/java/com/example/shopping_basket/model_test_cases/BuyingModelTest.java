package com.example.shopping_basket.model_test_cases;

import com.example.shopping_basket.controller.StoreController;
import com.example.shopping_basket.model.BuyingModel;
import com.example.shopping_basket.model.StoreModel;
import com.example.shopping_basket.service.BuyingServiceImpl;
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
import org.springframework.ui.Model;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@WebMvcTest(StoreController.class)
public class BuyingModelTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private BuyingServiceImpl buyingService;
    @Captor
    private ArgumentCaptor<StoreModel> argumentCaptor;

    @Test
    void addItemToCart() {
        BuyingModel model = new BuyingModel();
        model.setId(2L);
        model.setDate(new Date());
        model.setQuantity(500);

        // todo: addToCart()
    }

}
