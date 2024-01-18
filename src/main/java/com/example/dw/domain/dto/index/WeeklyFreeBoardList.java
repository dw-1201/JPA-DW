package com.example.dw.domain.dto.index;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeeklyFreeBoardList {



    private Long freeBoardId;
    private String freeBoardTitle;
    private Long viewCount;

    @QueryProjection
    public WeeklyFreeBoardList(Long freeBoardId, String freeBoardTitle, Long viewCount) {
        this.freeBoardId = freeBoardId;
        this.freeBoardTitle = freeBoardTitle;
        this.viewCount = viewCount;
    }
}
