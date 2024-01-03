package com.example.dw.repository.community;

import com.example.dw.domain.dto.community.WalkDetailStateDto;
import com.example.dw.domain.entity.walkingMate.WalkingMateState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

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



//    @Query("select wms.walkingMate.id, wms.id, , p.PET_ID, p.NAME, p.WEIGHT, p.PET_GENDER, p.BIRTH_DATE, p.PET_CATEGORY, p.NEUTERING, pi.PET_FILE_NAME, pi.PET_PATH, pi.PET_UUID, WALKING_MATE_STATE from WalkingMateState wms join WALKING_MATE wm on wm.WALKING_MATE_ID=wms.WALKING_MATE_ID join users u on u.USER_ID = wms.USER_ID join pet p on u.USER_ID = p.USER_ID join PET_IMG pi on p.PET_ID=pi.PET_ID where wm.WALKING_MATE_ID=:walkMateId and WALKING_MATE_STATE=1")
//    List<WalkDetailStateDto> findApplierPetInfo(@Param("walkMateId") Long walkMateId);

}
