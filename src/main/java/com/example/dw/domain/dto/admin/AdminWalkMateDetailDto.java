package com.example.dw.domain.dto.admin;

import com.example.dw.domain.dto.community.WalkMateDetailReplyDto;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class AdminWalkMateDetailDto {

    //산책글 기본 정보
    private Long id; //산책글 id
    private Long userId; //산책글 작성자 회원id
    private String userAccount; //산책글 작성자 회원아이디
    private LocalDateTime regDate; //산책글 작성일자
    private LocalDateTime modDate; //산책글 수정일자
    private Long viewCount; //산책글 조회수
    private String title; //산책글 제목
    private String content; //산책글 내용
    private String fullAddress; //산책 장소
    private String mateDate; //산책 약속 일자
    private String mateTime; //산책 약속 시간
    private Long writerPetId; //산책글 펫(작성자)
    private String writerPetName;
    private Long walkMateState; //산책글 모집상태
    
    
    //산책글 신청자
    private List<ApplierUserList> applierUserListList;

    //산책글 댓글
    private List<WalkMateDetailReplyDto> walkMateDetailReplyDtos;


    @QueryProjection
    public AdminWalkMateDetailDto(Long id, Long userId, String userAccount, LocalDateTime regDate, LocalDateTime modDate, Long viewCount, String title, String content, String fullAddress, String mateDate, String mateTime, Long writerPetId, String writerPetName, Long walkMateState) {
        this.id = id;
        this.userId = userId;
        this.userAccount = userAccount;
        this.regDate = regDate;
        this.modDate = modDate;
        this.viewCount = viewCount;
        this.title = title;
        this.content = content;
        this.fullAddress = fullAddress;
        this.mateDate = mateDate;
        this.mateTime = mateTime;
        this.writerPetId = writerPetId;
        this.writerPetName = writerPetName;
        this.walkMateState = walkMateState;
    }







    @QueryProjection
    public AdminWalkMateDetailDto(Long id, Long userId, String userAccount, LocalDateTime regDate, LocalDateTime modDate, Long viewCount, String title, String content, String fullAddress, String mateDate, String mateTime, Long writerPetId, String writerPetName, Long walkMateState, List<ApplierUserList> applierUserListList, List<WalkMateDetailReplyDto> walkMateDetailReplyDtos) {
        this.id = id;
        this.userId = userId;
        this.userAccount = userAccount;
        this.regDate = regDate;
        this.modDate = modDate;
        this.viewCount = viewCount;
        this.title = title;
        this.content = content;
        this.fullAddress = fullAddress;
        this.mateDate = mateDate;
        this.mateTime = mateTime;
        this.writerPetId = writerPetId;
        this.writerPetName = writerPetName;
        this.walkMateState = walkMateState;
        this.applierUserListList = applierUserListList;
        this.walkMateDetailReplyDtos = walkMateDetailReplyDtos;
    }
}
