package com.anyquestions69.site.controllers;

import com.anyquestions69.site.models.Shop;
import com.anyquestions69.site.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class ShopController {
    @Autowired
    ShopRepository shopRepository;
    @GetMapping("/shop")
    public List<Shop> getAll(){
        List<Shop> items = shopRepository.findAll();
        return items;
    }
    @PostMapping("/add")
    public Shop addItem(@RequestBody Shop item){
        Shop _item = shopRepository.save(new Shop(item.getName(), item.getPrice(), item.getCount()));
        return _item;
    }
}
