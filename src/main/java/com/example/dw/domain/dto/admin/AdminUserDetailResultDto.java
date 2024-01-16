package com.example.dw.domain.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AdminUserDetailResultDto {



    private AdminUserDetailInfo adminUserDetailInfo;
    private List<AdminUserPetDetailDto> adminUserPetDetailDto;


    public AdminUserDetailResultDto(AdminUserDetailInfo adminUserDetailInfo, List<AdminUserPetDetailDto> adminUserPetDetailDto) {
        this.adminUserDetailInfo = adminUserDetailInfo;
        this.adminUserPetDetailDto = adminUserPetDetailDto;
    }
}
