package com.example.dw.domain.dto.community;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WalkMateIdDto {

    private Long walkMateId;

    @QueryProjection
    public WalkMateIdDto(Long walkMateId) {
        this.walkMateId = walkMateId;
    }
}
