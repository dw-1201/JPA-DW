package com.example.dw.repository.community;

import com.example.dw.domain.entity.walkingMate.WalkingMateState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WalkingMateStateRepository extends JpaRepository<WalkingMateState, Long>

{


    @Query("select wm.id from WalkingMateState wm where wm.walkingMate.id=:walkingMateId and wm.users.id=:userId")
    Long applyCheck(@Param("walkingMateId") Long walkingMateId,
                    @Param("userId") Long userId);

    @Query("select wm.users.id from WalkingMateState wm where wm.state=1 and wm.users.id=:userId and wm.walkingMate.id=:walkMateId")
    Long applyState(@Param("userId") Long userId,
                    @Param("walkMateId") Long walkMateId);

    //walkMateState 상태값 개수 가져오기
    @Query("select count(wm.id) from WalkingMateState wm where wm.walkingMate.id=:walkingMateId")
    Long stateCount(@Param("walkingMateId") Long walkingMateId);

}
