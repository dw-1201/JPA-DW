package com.example.dw.repository;

import com.example.dw.entity.goods.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GoodsRepository extends JpaRepository<Goods, Long> {

        //goods(상품) 기본키로 상품 검색
        Optional<Goods> findById(Long id);


}
