package com.example.shopping_basket.controller;

import com.example.shopping_basket.model.StoreModel;
import com.example.shopping_basket.service.StoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StoreController {

    @Autowired
    private StoreServiceImpl service;

    @GetMapping("/vendor")
    public String viewAllItems(Model model) {
        model.addAttribute("all_items", service.getAllItems());
        return "/vendor/index";
    }

    @GetMapping("/vendor/sort/{field}")
    public String viewItemsSorted(@PathVariable(value = "field") String field, Model model) {
        model.addAttribute("all_items", service.getAllItemsSorted(field));
        return "redirect:/vendor";
    }

    @GetMapping("/vendor/add")
    public String addNewItem(Model model) {
        StoreModel storeModel = new StoreModel();
        model.addAttribute("item", storeModel);
        return "/vendor/add";
    }

    @PostMapping("/vendor/save")
    public String saveItem(@ModelAttribute("item") StoreModel storeModel) {
        Double shelfPrice = 0.0;
        Double importDuty = 0.0;
        Double vat = 0.0;
        service.save(storeModel);
        shelfPrice = storeModel.getPrice();

        if (storeModel.isImported()) {
            importDuty = storeModel.getPrice() * 0.05; // 5%
        }
        if (storeModel.isBookFoodMedical()) {
            vat = storeModel.getPrice() * 0.1; // 10%
        }
        shelfPrice += (importDuty + vat);
        storeModel.setShelfPrice(shelfPrice);
        storeModel.setTaxes(importDuty + vat);
        service.save(storeModel);
        return "redirect:/vendor";
    }

    @GetMapping("/vendor/update/{id}")
    public String updateItem(@PathVariable(value = "id") Long id, Model model) {
        StoreModel storeModel = service.getItemById(id);
        model.addAttribute("item", storeModel);
        return "/vendor/update";
    }

    @GetMapping("/vendor/delete/{id}")
    public String deleteThroughId(@PathVariable(value = "id") Long id) {
        service.deleteItemById(id);
        return "redirect:/vendor";
    }
}
