package com.example.dw.domain.dto.order;


import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderReviewDto {

    private Long id;

    private String title;
    private String content;
    private Integer rating;

    private Long state=0L;

    @QueryProjection
    public OrderReviewDto(Long id, String title, String content, Integer rating, Long state) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.rating = rating;
        this.state = state;
    }
}
