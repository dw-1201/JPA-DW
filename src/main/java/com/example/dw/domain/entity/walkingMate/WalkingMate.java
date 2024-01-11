package com.example.dw.domain.entity.walkingMate;

import com.example.dw.domain.entity.user.Pet;
import com.example.dw.domain.entity.user.Users;
import com.example.dw.domain.form.WalkMateForm;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "walking_mate")
public class WalkingMate {
    @Id
    @GeneratedValue
    @Column(name = "walking_mate_id")
    private Long id;

    private String walkingMateTitle;
    private String walkingMateContent;
    @CreatedDate
    private LocalDateTime walkingMateRd;
    @LastModifiedDate
    private LocalDateTime walkingMateMd;
    @Builder.Default
    private Long walkingMateViewCount = 0L;
    @Builder.Default
    private Long walkingMateState = 0L;
    private Long walkingMatePerson;




    private String walkingMateDate;
    private String walkingMateTime;
    private String walkingMateFullAddress;
    private String walkCity;
    private String walkCounty;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id")
    private Pet pet;


    @OneToMany(mappedBy = "walkingMate" ,fetch = FetchType.LAZY)
    private List<WalkingMateComment> walkingMateComment = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "walkingMate")
    private List<WalkingMateState> walkingMateStateList = new ArrayList<>();



    @Builder
    public WalkingMate(Long id, String walkingMateTitle, String walkingMateContent, LocalDateTime walkingMateRd, LocalDateTime walkingMateMd, Long walkingMateViewCount, Long walkingMateState, Long walkingMatePerson, String walkingMateDate, String walkingMateTime, String walkingMateFullAddress, String walkCity, String walkCounty, Users users, Pet pet, List<WalkingMateComment> walkingMateComment, List<WalkingMateState> walkingMateStateList) {
        this.id = id;
        this.walkingMateTitle = walkingMateTitle;
        this.walkingMateContent = walkingMateContent;
        this.walkingMateRd = walkingMateRd;
        this.walkingMateMd = walkingMateMd;
        this.walkingMateViewCount = walkingMateViewCount;
        this.walkingMateState = walkingMateState;
        this.walkingMatePerson = walkingMatePerson;
        this.walkingMateDate = walkingMateDate;
        this.walkingMateTime = walkingMateTime;
        this.walkingMateFullAddress = walkingMateFullAddress;
        this.walkCity = walkCity;
        this.walkCounty = walkCounty;
        this.users = users;
        this.pet = pet;
        this.walkingMateComment = walkingMateComment;
        this.walkingMateStateList = walkingMateStateList;
    }





    //산책글 전체수정
    public WalkingMate update(WalkMateForm walkMateForm){
        this.walkingMateTitle=walkMateForm.getWalkingMateTitle();
        this.walkingMateContent=walkMateForm.getWalkingMateContent();
        this.walkingMateMd = LocalDateTime.now();
        this.walkingMatePerson=walkMateForm.getWalkingMatePerson();
        this.walkingMateDate=walkMateForm.getWalkingMateDate();
        this.walkingMateTime=walkMateForm.getWalkingMateTime();
        this.walkingMateFullAddress=getWalkingMateFullAddress();
        this.walkCity = walkMateForm.getWalkCity();
        this.walkCounty = walkMateForm.getWalkCounty();
        this.pet=walkMateForm.toEntity().getPet();
        return this;
    }

    //산책글 부분수정(요일제외)
    public WalkingMate updateExceptDate(WalkMateForm walkMateForm){
        this.walkingMateTitle=walkMateForm.getWalkingMateTitle();
        this.walkingMateContent=walkMateForm.getWalkingMateContent();
        this.walkingMateMd = LocalDateTime.now();
        this.walkingMatePerson=walkMateForm.getWalkingMatePerson();
        this.walkingMateTime=walkMateForm.getWalkingMateTime();
        this.walkingMateFullAddress=getWalkingMateFullAddress();
        this.walkCity = walkMateForm.getWalkCity();
        this.walkCounty = walkMateForm.getWalkCounty();
        this.pet=walkMateForm.toEntity().getPet();
        return this;
    }


}
