package com.example.dw.repository.goods;

import com.example.dw.domain.entity.goods.GoodsQue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GoodsQueRepository extends JpaRepository<GoodsQue, Long> {

        //goods(상품) 기본키로 상품 검색
        Optional<GoodsQue> findById(Long id);




}
