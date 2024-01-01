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

}
