package com.example.dw.domain.form;

import com.example.dw.domain.entity.freeBoard.FreeBoard;
import com.example.dw.domain.entity.freeBoard.FreeBoardImg;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FreeBoardImgForm {

    private Long id;

    private String freeBoardImgRoute;
    private String freeBoardImgName;
    private String freeBoardImgUuid;

    private FreeBoard freeBoard;

    @Builder
    public FreeBoardImgForm(Long id, String freeBoardImgRoute, String freeBoardImgName, String freeBoardImgUuid, FreeBoard freeBoard) {
        this.id = id;
        this.freeBoardImgRoute = freeBoardImgRoute;
        this.freeBoardImgName = freeBoardImgName;
        this.freeBoardImgUuid = freeBoardImgUuid;
        this.freeBoard = freeBoard;
    }

    public FreeBoardImg toEntity(){
        return FreeBoardImg.builder()
                .id(id)
                .freeBoardImgRoute(freeBoardImgRoute)
                .freeBoardImgName(freeBoardImgName)
                .freeBoardImgUuid(freeBoardImgUuid)
                .freeBoard(freeBoard)
                .build();
    }
}
