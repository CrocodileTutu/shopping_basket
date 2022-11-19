package com.example.shopping_basket.controller;

import com.example.shopping_basket.service.StoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

    @Autowired
    private StoreServiceImpl service;

//    @Autowired
//    private OrderService order;         // needs implementation

    @GetMapping("/buyer")
    public String viewAllItems(Model model) {
        model.addAttribute("all_items", service.getAllItems());
        return "/buyer/index";
    }
}
