package com.example.dw.domain.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AdminUserDetailWalkMateWithTotalCountDto {


    private Long totalCount;
    private List<AdminUserDetailWalkMateDto> walkMateList;


    public AdminUserDetailWalkMateWithTotalCountDto(Long totalCount, List<AdminUserDetailWalkMateDto> walkMateList) {
        this.totalCount = totalCount;
        this.walkMateList = walkMateList;
    }
}
