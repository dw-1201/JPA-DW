package com.example.dw.repository.community;

import com.example.dw.domain.dto.community.WalkDetailStateDto;
import com.example.dw.domain.entity.walkingMate.WalkingMate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WalkingMateRepository extends JpaRepository<WalkingMate, Long> {


    //조회수 카운트
    @Modifying
    @Query("update WalkingMate wm set wm.walkingMateViewCount = wm.walkingMateViewCount+1 where wm.id=:id")
    void updateViewCount(@Param("id") Long id);

    //walkMate-state 상태값 변경
    @Modifying
    @Query("update WalkingMate wm set wm.walkingMateState=1 where wm.id=:id")
    void updateWalkMateState(@Param("id") Long id);

    //walkMate-state 상태값 변경
    @Modifying
    @Query("update WalkingMate wm set wm.walkingMateState=0 where wm.id=:id")
    void downDateWalkMateState(@Param("id") Long id);


    @Query("select NEW com.example.dw.domain.dto.community.WalkDetailStateDto (wms.walkingMate.id, wms.id, u.id, u.userAccount, u.userNickName, p.id, p.name, p.weight, p.petGender, p.birthDate, p.petCategory, p.neutering, pi.petFileName, pi.petPath, pi.petUuid, wms.state, wms.writerCheck) " +
            "from WalkingMateState wms " +
            "left join WalkingMate wm on wm.id=wms.walkingMate.id " +
            "left join Users u on u.id = wms.users.id left join Pet p on u.id = p.users.id " +
            "left join PetImg pi on p.id=pi.pet.id " +
            "where wm.id=:walkMateId and wms.state=1 and wms.writerCheck=0")
    List<WalkDetailStateDto> applierPetsInfo(@Param("walkMateId")Long walkMateId);
}