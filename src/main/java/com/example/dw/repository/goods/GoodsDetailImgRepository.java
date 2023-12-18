package com.example.dw.repository.goods;

import com.example.dw.domain.dto.admin.AdminGoodsDetailImgDto;
import com.example.dw.domain.entity.goods.GoodsDetailImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsDetailImgRepository extends JpaRepository<GoodsDetailImg, Long> {

    //상품번호로 삭제
    void deleteById(Long id);


    List<AdminGoodsDetailImgDto> findAllByGoodsId(Long id);
}
