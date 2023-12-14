package com.example.dw.repository.freeBoard;

import com.example.dw.domain.entity.freeBoard.FreeBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FreeBoardRepository extends JpaRepository<FreeBoard, Long> {

    //기본키로 검색
    Optional<FreeBoard> findById(Long id);

}
