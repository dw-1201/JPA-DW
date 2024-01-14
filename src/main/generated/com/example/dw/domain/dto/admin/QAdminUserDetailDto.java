package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminUserDetailDto is a Querydsl Projection type for AdminUserDetailDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminUserDetailDto extends ConstructorExpression<AdminUserDetailDto> {

    private static final long serialVersionUID = -494810718L;

    public QAdminUserDetailDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<String> userName, com.querydsl.core.types.Expression<String> userNickName, com.querydsl.core.types.Expression<String> userPhone, com.querydsl.core.types.Expression<String> userEmail, com.querydsl.core.types.Expression<java.time.LocalDate> userJoinDate, com.querydsl.core.types.Expression<String> zipCode, com.querydsl.core.types.Expression<String> address, com.querydsl.core.types.Expression<String> detail, com.querydsl.core.types.Expression<String> intro, com.querydsl.core.types.Expression<Long> userImgId, com.querydsl.core.types.Expression<String> userImgPath, com.querydsl.core.types.Expression<String> userImgUuid, com.querydsl.core.types.Expression<String> userImgName, com.querydsl.core.types.Expression<Long> petId, com.querydsl.core.types.Expression<String> birthDate, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<Long> weight, com.querydsl.core.types.Expression<String> petGender, com.querydsl.core.types.Expression<String> neutering, com.querydsl.core.types.Expression<String> petCategory, com.querydsl.core.types.Expression<Long> petImgId, com.querydsl.core.types.Expression<String> petImgPath, com.querydsl.core.types.Expression<String> petImgUuid, com.querydsl.core.types.Expression<String> petImgName) {
        super(AdminUserDetailDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, String.class, String.class, java.time.LocalDate.class, String.class, String.class, String.class, String.class, long.class, String.class, String.class, String.class, long.class, String.class, String.class, long.class, String.class, String.class, String.class, long.class, String.class, String.class, String.class}, id, userAccount, userName, userNickName, userPhone, userEmail, userJoinDate, zipCode, address, detail, intro, userImgId, userImgPath, userImgUuid, userImgName, petId, birthDate, name, weight, petGender, neutering, petCategory, petImgId, petImgPath, petImgUuid, petImgName);
    }

}

