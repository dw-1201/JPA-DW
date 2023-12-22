package com.example.dw.domain.entity.walkingMate;

import com.example.dw.domain.entity.user.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
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
    private String walkingMateRd;
    @LastModifiedDate
    private String walkingMateMd;
    @Builder.Default
    private Long walkingMateViewCount = 0L;
    private Long walkingMateState;
    private Long walkingMatePerson;
    @Builder.Default
    private Long walkingMateToday = 1L;

    private String petName;

    private String walkingMateDate;
    private String walkingMateTime;
    private String walkingMateFullAddress;
    private String walkCity;
    private String walkCounty;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

    @OneToMany(mappedBy = "walkingMate" ,fetch = FetchType.LAZY)
    private List<WalkingMateComment> walkingMateComment = new ArrayList<>();


    @Builder
    public WalkingMate(Long id, String walkingMateTitle, String walkingMateContent, String walkingMateRd, String walkingMateMd, Long walkingMateViewCount, Long walkingMateState, Long walkingMatePerson, Long walkingMateToday, String petName, String walkingMateDate, String walkingMateTime, String walkingMateFullAddress, String walkCity, String walkCounty, Users users, List<WalkingMateComment> walkingMateComment) {
        this.id = id;
        this.walkingMateTitle = walkingMateTitle;
        this.walkingMateContent = walkingMateContent;
        this.walkingMateRd = walkingMateRd;
        this.walkingMateMd = walkingMateMd;
        this.walkingMateViewCount = walkingMateViewCount;
        this.walkingMateState = walkingMateState;
        this.walkingMatePerson = walkingMatePerson;
        this.walkingMateToday = walkingMateToday;
        this.petName = petName;
        this.walkingMateDate = walkingMateDate;
        this.walkingMateTime = walkingMateTime;
        this.walkingMateFullAddress = walkingMateFullAddress;
        this.walkCity = walkCity;
        this.walkCounty = walkCounty;
        this.users = users;
        this.walkingMateComment = walkingMateComment;
    }






    //날짜포맷
    @PrePersist
    public void onPrePersist(){
        this.walkingMateRd = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
        this.walkingMateMd=this.walkingMateRd;
    }

    @PreUpdate
    public void onPreUpdate(){
        this.walkingMateMd = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
    }


}
