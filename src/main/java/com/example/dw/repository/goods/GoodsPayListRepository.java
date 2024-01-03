package com.example.dw.repository.goods;

import com.example.dw.domain.dto.goods.GoodsPayDto;
import com.example.dw.domain.entity.goods.GoodsPayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GoodsPayListRepository extends JpaRepository<GoodsPayList, Long> {


//    List<GoodsPayDto> findAllByUserId(Long userId);

//    @Query("select gp.id, gp.goods.id, gp.goods.goodsName, gp.goodsQuantity, gp.goodsPrice, gp.users.id from GoodsPayList gp left join Goods g on g.id=gp.goods.id left join Users u on u.id=gp.users.id where gp.users.id=:userId")
//    List<GoodsPayDto> findGoodsPayList(@Param("userId")Long userId);

    @Query("SELECT NEW com.example.dw.domain.dto.goods.GoodsPayDto(gp.id, gp.goods.id, gp.goods.goodsName, gp.goodsQuantity, gp.goodsPrice, gp.users.id) FROM GoodsPayList gp LEFT JOIN gp.goods g LEFT JOIN gp.users u WHERE gp.users.id = :userId")
    List<GoodsPayDto> findGoodsPayList(@Param("userId") Long userId);

}
