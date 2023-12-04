package com.example.dw.repository;

import com.example.dw.domain.entity.goods.GoodsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsCategoryRepository extends JpaRepository<GoodsCategory, Long> {
}
