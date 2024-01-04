package com.example.dw.domain.form;

import com.example.dw.domain.entity.user.Pet;
import com.example.dw.domain.entity.user.Users;
import com.example.dw.domain.entity.walkingMate.WalkingMate;
import com.example.dw.domain.entity.walkingMate.WalkingMateState;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WalkingMateStateForm {

    private Long id;
    private Long walkingMateId;
    private Long userId;
    private Long petId;
    private Integer state;
    private Integer writerCheck;


    @Builder
    public WalkingMateStateForm(Long id, Long walkingMateId, Long userId, Long petId, Integer state, Integer writerCheck) {
        this.id = id;
        this.walkingMateId = walkingMateId;
        this.userId = userId;
        this.petId = petId;
        this.state = state;
        this.writerCheck = writerCheck;
    }





    public WalkingMateState toEntity(){
        return WalkingMateState.builder()
                .id(id)
                .walkingMate(WalkingMate.builder().id(walkingMateId).build())
                .users(Users.builder().id(userId).build())
                .pet(Pet.builder().id(petId).build())
                .state(state)
                .writerCheck(writerCheck)
                .build();
    }

}