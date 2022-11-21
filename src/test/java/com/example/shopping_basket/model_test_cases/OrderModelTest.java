package com.example.shopping_basket.model_test_cases;

import com.example.shopping_basket.controller.StoreController;
import com.example.shopping_basket.model.StoreModel;
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

@ExtendWith(SpringExtension.class)
@WebMvcTest(StoreController.class)
public class OrderModelTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private OrderServiceImpl orderService;
    @Captor
    private ArgumentCaptor<StoreModel> argumentCaptor;

    @Test
    void testCaseOne() {

    }
}
