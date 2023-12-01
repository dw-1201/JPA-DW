package com.example.dw.entity.goods;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="goods_que")
@Getter
@Setter
public class GoodsQue {
    @Id
    @GeneratedValue
    private Long id;
}
