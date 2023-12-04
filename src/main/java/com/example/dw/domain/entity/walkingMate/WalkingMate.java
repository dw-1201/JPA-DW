package com.example.dw.domain.entity.walkingMate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static lombok.Builder.*;

@Entity
@Getter
@Setter
@Table(name = "walking_mate")
public class WalkingMate {
    @Id
    @GeneratedValue
    @Column(name = "walking_mate_id")
    private Long id;

    private String walkingMateTitle;
    private String walkingMateContent;
    private LocalDateTime walkingMateRd;
    private LocalDateTime walkingMateMd;
    private Long walkingMateViewCount;
    private Long walkingMateState;
    private Long walkingMatePerson;
    @Default
    private Long walkingMateToday = 1L;

    @OneToMany(mappedBy = "walkingMate" ,fetch = FetchType.LAZY)
    private List<WalkingMateComment> walkingMateComment = new ArrayList<>();

    @OneToOne(mappedBy = "walkingMate" ,fetch = FetchType.LAZY)
    private WalkingMateAddress walkingMateAddress;
}
