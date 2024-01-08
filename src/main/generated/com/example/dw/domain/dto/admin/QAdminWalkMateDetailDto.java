package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminWalkMateDetailDto is a Querydsl Projection type for AdminWalkMateDetailDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminWalkMateDetailDto extends ConstructorExpression<AdminWalkMateDetailDto> {

    private static final long serialVersionUID = 2062316767L;

    public QAdminWalkMateDetailDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<java.time.LocalDateTime> regDate, com.querydsl.core.types.Expression<java.time.LocalDateTime> modDate, com.querydsl.core.types.Expression<Long> viewCount, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<String> content, com.querydsl.core.types.Expression<String> fullAddress, com.querydsl.core.types.Expression<String> mateDate, com.querydsl.core.types.Expression<String> mateTime, com.querydsl.core.types.Expression<Long> writerPetId, com.querydsl.core.types.Expression<String> writerPetName, com.querydsl.core.types.Expression<Long> walkMateState) {
        super(AdminWalkMateDetailDto.class, new Class<?>[]{long.class, long.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, long.class, String.class, String.class, String.class, String.class, String.class, long.class, String.class, long.class}, id, userId, userAccount, regDate, modDate, viewCount, title, content, fullAddress, mateDate, mateTime, writerPetId, writerPetName, walkMateState);
    }

    public QAdminWalkMateDetailDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<java.time.LocalDateTime> regDate, com.querydsl.core.types.Expression<java.time.LocalDateTime> modDate, com.querydsl.core.types.Expression<Long> viewCount, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<String> content, com.querydsl.core.types.Expression<String> fullAddress, com.querydsl.core.types.Expression<String> mateDate, com.querydsl.core.types.Expression<String> mateTime, com.querydsl.core.types.Expression<Long> writerPetId, com.querydsl.core.types.Expression<String> writerPetName, com.querydsl.core.types.Expression<Long> walkMateState, com.querydsl.core.types.Expression<? extends java.util.List<ApplierUserList>> applierUserListList, com.querydsl.core.types.Expression<? extends java.util.List<com.example.dw.domain.dto.community.WalkMateDetailReplyDto>> walkMateDetailReplyDtos) {
        super(AdminWalkMateDetailDto.class, new Class<?>[]{long.class, long.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, long.class, String.class, String.class, String.class, String.class, String.class, long.class, String.class, long.class, java.util.List.class, java.util.List.class}, id, userId, userAccount, regDate, modDate, viewCount, title, content, fullAddress, mateDate, mateTime, writerPetId, writerPetName, walkMateState, applierUserListList, walkMateDetailReplyDtos);
    }

}

