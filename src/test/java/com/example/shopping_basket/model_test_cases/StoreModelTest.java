package com.example.shopping_basket.model_test_cases;

import com.example.shopping_basket.controller.StoreController;
import com.example.shopping_basket.model.BuyingModel;
import com.example.shopping_basket.model.StoreModel;
import com.example.shopping_basket.service.StoreService;
import com.example.shopping_basket.service.StoreServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;
import java.util.Iterator;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

//    @MockBean
//    private StoreController storeController;

//    @Autowired
//    private StoreModel storeModel;

    //    private ConsoleIOContext.AllSuggestionsCompletionTask mockMvc;


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

    @Test
    void testQuery() {
        Iterator iterator = mock(Iterator.class);
        when(iterator.next()).thenReturn("Shopping").thenReturn("Cart");

        String result = iterator.next()+" "+iterator.next();
        assertEquals("Shopping Cart", result);
    }

    @Test
    void testControllerView1() throws Exception {
        StoreModel storeModel1 =
                new StoreModel(1L, "Apple (kg)", 1, false, false, 3.95, 3.95, 0.0);

        Mockito.doNothing().when(storeService.getItemById( 1L )).getId();

        mockMvc.perform(get("/vendor"))
                .andExpect(status().isOk())
                .andExpect(view().name("vendor/index"))
                .andExpect(forwardedUrl("/vendor/index"))
                .andExpect(model().attribute("all_items", hasSize(1)));
    }

    @Test
    void shouldCheckUpdate() throws Exception {
        StoreModel storeModel1 =
                new StoreModel(1L, "Apple (kg)", 1, false, false, 3.95, 3.95, 0.0);
        BuyingModel buyingModel1 = new BuyingModel(200L, 1, 1L, "Apple (kg)", 3.95, 0.0, new Date(), null);

        when(storeService.getItemById( 1L ).getName()).thenReturn(buyingModel1.getItem());

        this.mockMvc
                .perform(get("/vendor/update", 1L))
                .andExpect(status().isOk())
                .andExpect(view().name("update"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("isImported"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("shelfPrice"))
                .andExpect(MockMvcResultMatchers.model().attribute("isBookFoodMedical","true"));
    }

    }