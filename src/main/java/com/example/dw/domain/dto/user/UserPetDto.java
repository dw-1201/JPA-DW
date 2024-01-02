package com.example.dw.domain.dto.user;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserPetDto {


    private Long id;
    private String petName;


    @QueryProjection
    public UserPetDto(Long id, String petName) {
        this.id = id;
        this.petName = petName;
    }

}
