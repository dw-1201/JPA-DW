package com.example.dw.repository.community;

import com.example.dw.domain.entity.walkingMate.WalkingMateState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalkingMateStateRepository extends JpaRepository<WalkingMateState, Long>

{

    Optional<WalkingMateState> findByWalkingMateId(Long walkingMateId);

}
