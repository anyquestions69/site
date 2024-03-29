package com.anyquestions69.site.repository;

import com.anyquestions69.site.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Long> {
    List<Shop> findByPrice(float price);
}
