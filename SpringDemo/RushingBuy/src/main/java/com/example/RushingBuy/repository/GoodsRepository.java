package com.example.RushingBuy.repository;

import com.example.RushingBuy.entity.Goods;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GoodsRepository extends CrudRepository<Goods,Long> {
    List<Goods> findByName(String name);
}
