package com.example.dw.domain.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AdminUserDetailQnaResultWithTotalCountDto {


        private Long totalCount;
        private List<AdminUserDetailQnaListDto> qnaBoardList;


    public AdminUserDetailQnaResultWithTotalCountDto(Long totalCount, List<AdminUserDetailQnaListDto> qnaBoardList) {
        this.totalCount = totalCount;
        this.qnaBoardList = qnaBoardList;
    }
}
