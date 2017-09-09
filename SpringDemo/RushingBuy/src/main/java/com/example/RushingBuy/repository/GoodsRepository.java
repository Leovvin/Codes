package com.example.RushingBuy.repository;

import com.example.RushingBuy.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods,Long> {
    List<Goods> findByName(String name);
}
