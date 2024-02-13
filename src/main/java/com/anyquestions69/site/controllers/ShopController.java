package com.anyquestions69.site.controllers;

import com.anyquestions69.site.BadRequestException;
import com.anyquestions69.site.ErrorMessage;
import com.anyquestions69.site.models.Shop;
import com.anyquestions69.site.repository.ShopRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("/shop/{id}")
    public Shop getById(@PathVariable(value = "id") long id){
        Shop item = shopRepository.findById(id).orElseThrow(()-> new BadRequestException("Not found"));
        return item;
    }
    @PostMapping("/add")
    public ResponseEntity<?> addItem(@RequestBody Shop item){
        try{
            if(item.getName()==null || item.getName().trim().isEmpty()) return new ResponseEntity<>(new ErrorMessage(HttpStatus.BAD_REQUEST.value(),"Body is empty"), HttpStatus.BAD_REQUEST);
            Shop _item = shopRepository.save(new Shop(item.getName(), item.getPrice(), item.getCount()));
            return new ResponseEntity<>( _item, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Server error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
