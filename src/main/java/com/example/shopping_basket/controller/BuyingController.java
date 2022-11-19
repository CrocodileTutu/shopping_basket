package com.example.shopping_basket.controller;

import com.example.shopping_basket.model.BuyingModel;
import com.example.shopping_basket.model.OrderModel;
import com.example.shopping_basket.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;

@Controller
public class BuyingController {

    @Autowired
    private StoreService storeService;

    @PostMapping("/buyer/addToCart")
    public String addToCart(HttpSession session,
                            Model model,
                            @RequestParam("id") Long id,
                            @RequestParam("quantity") int quantity) {
        // sessionToken
        String sessionToken = (String) session.getAttribute("sessionToken");
        if(sessionToken == null) {
            session.setAttribute("sessionToken", UUID.randomUUID().toString());
            OrderModel order = new OrderModel();
            BuyingModel item = new BuyingModel();
            item.setQuantity(quantity);
            item.setDate(new Date());
            item.setProduct(storeService.getItemById(id));

            order.getItems().add(item);
        }
        return "redirect:/buyer";
    }}
