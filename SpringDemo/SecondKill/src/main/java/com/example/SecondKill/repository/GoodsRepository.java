package com.example.SecondKill.repository;

import com.example.SecondKill.entity.Goods;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GoodsRepository extends CrudRepository<Goods,Long> {
    List<Goods> findByName(String name);
}
