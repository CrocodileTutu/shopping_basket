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
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

@ExtendWith(SpringExtension.class)
@WebMvcTest(StoreController.class)
@DataJpaTest
public class BuyingModelTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private BuyingServiceImpl buyingService;
    @MockBean
    private StoreServiceImpl storeService;
    @Captor
    private ArgumentCaptor<StoreModel> argumentCaptor;

    @Test
    void addItemToCart() {
        // given
        BuyingModel model = new BuyingModel();
        model.setId(2L);
        model.setDate(new Date());
        model.setQuantity(500);

        // when
        buyingService.save(model);

        // then

    }

    @Test
    void addToCart() {
        // given
        StoreModel model = new StoreModel();
        model.setId(1000L);
        model.setName("Apple (kg)");
        model.setPrice(2.50);
        model.setQuantity(500);
        model.setImported(true);
        model.setBookFoodMedical(false);
        model.setTaxes(0.10);

        // when
        storeService.save(model);

        // then
        BuyingModel buyingModel = new BuyingModel();
        buyingModel.setId(model.getId());
        buyingModel.getProduct();
//        System.out.println(buyingModel.getProduct());

        buyingService.deleteAll();
//        System.out.println(buyingService.getAllItems());

        // then 2
        storeService.getItemById(1000L);
        BuyingModel buyingModel1 = new BuyingModel();
//        System.out.println( buyingModel1.getProduct() );
    }

}
