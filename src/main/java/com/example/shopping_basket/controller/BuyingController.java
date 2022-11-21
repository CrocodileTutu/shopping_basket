package com.example.shopping_basket.controller;

import com.example.shopping_basket.model.BuyingModel;
import com.example.shopping_basket.repository.BuyingRepository;
import com.example.shopping_basket.service.BuyingService;
import com.example.shopping_basket.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class BuyingController {

    @Autowired
    private StoreService storeService;

    @Autowired
    BuyingRepository buyingRepository;

    @Autowired
    private BuyingService buyingService;

    @GetMapping("/buyer/add/{id}")
    public String addToCart (@PathVariable("id") Long id) {
        BuyingModel item = new BuyingModel();
        item.setProduct(storeService.getItemById(id));
        item.setQuantity(1);
        item.setDate(new Date());
        item.setItemId(id);
        item.setItem(storeService.getItemById(id).getName());
        item.setPrice(String.valueOf(storeService.getItemById(id).getPrice()));

        // ToDo: Implementation in BuyingServiceImpl
        Double shelfPrice = buyingService.getItemPriceAndTaxById(id);
        item.setPriceAndTax(String.valueOf(shelfPrice));

        System.out.println("ID of product: "+id);
        System.out.println(item);
        buyingService.save(item);
        return "redirect:/buyer";
    }

    @GetMapping("/buyer/delete_all")
    public String deleteAllItems() {
        buyingService.deleteAll();
        return "redirect:/buyer";
    }

    @GetMapping("/buyer/empty_cart")
    public String deleteCart() {
        buyingService.deleteAll();
        return "redirect:/buyer";
    }

    @GetMapping("/buyer/show_cart")
    public String showShoppingCart(Model model) {

        List<Long> idList = buyingRepository.findAll().stream().map(a -> a.getId() ).toList();
        int num = buyingService.getAllItems().size();
        model.addAttribute("all_items", buyingService.getAllItems());

        /* calculate tax and total */
        Double sumTax = 0.0;
        Double sum = 0.0;
        Double sumWithTax = 0.0;
        for (Long myId : idList) {
            sum += buyingService.getItemPriceById(buyingService.getItemIdById(myId));
            sumTax += buyingService.getItemTaxById(buyingService.getItemIdById(myId));
        }
        sumWithTax = sum + sumTax;
        model.addAttribute("tax", sumTax);
        model.addAttribute("total", sumWithTax);
        return "/buyer/cart";
    }
}
