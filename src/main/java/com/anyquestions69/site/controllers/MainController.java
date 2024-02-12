package com.anyquestions69.site.controllers;

import com.anyquestions69.site.models.Shop;
import com.anyquestions69.site.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    ShopRepository shopRepository;
    @GetMapping("/welcome")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "welcome";
    }
    @GetMapping("/shop")
    public String getAll(Model model) {
        List<Shop> items = shopRepository.findAll();
        model.addAttribute("items", items);
        return "main";
    }

}
