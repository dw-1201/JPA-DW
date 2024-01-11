package com.example.dw.domain.dto.community;


import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WalkMateStateDto {

    private Long id;
    private Long walkMateId;
    private Long userId;
    private String userAccount;
    private String userNickName;
    private Integer state;
    private Integer writerCheck;
    private String address;
    private String detail;

    @QueryProjection
    public WalkMateStateDto(Long id, Long walkMateId, Long userId, String userAccount, String userNickName, Integer state, Integer writerCheck, String address, String detail) {
        this.id = id;
        this.walkMateId = walkMateId;
        this.userId = userId;
        this.userAccount = userAccount;
        this.userNickName = userNickName;
        this.state = state;
        this.writerCheck = writerCheck;
        this.address = address;
        this.detail = detail;
    }
}
