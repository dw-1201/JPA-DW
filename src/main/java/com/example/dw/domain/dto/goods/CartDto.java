package com.example.dw.domain.dto.goods;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartDto {

    private Long id;
    private Long userId;


    @QueryProjection
    public CartDto(Long id, Long userId) {
        this.id = id;
        this.userId = userId;
    }
}
