package com.example.dw.domain.entity.walkingMate;

import com.example.dw.domain.entity.user.Pet;
import com.example.dw.domain.entity.user.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Table(name = "walking_mate_state")
public class WalkingMateState {

    @Id @GeneratedValue
    @Column(name = "walking_mate_state_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "walking_mate_id")
    private WalkingMate walkingMate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="pet_id")
    private Pet pet;


    @Builder.Default
    private Integer state = 0;

    @Builder.Default
    private Integer writerCheck = 0;



    @Builder
    public WalkingMateState(Long id, WalkingMate walkingMate, Users users, Pet pet, Integer state, Integer writerCheck) {
        this.id = id;
        this.walkingMate = walkingMate;
        this.users = users;
        this.pet = pet;
        this.state = state;
        this.writerCheck = writerCheck;
    }
}
