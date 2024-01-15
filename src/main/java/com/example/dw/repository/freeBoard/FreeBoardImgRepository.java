package com.example.dw.repository.freeBoard;

import com.example.dw.domain.entity.freeBoard.FreeBoardImg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreeBoardImgRepository extends JpaRepository<FreeBoardImg, Long> {

    void deleteFreeBoardImgById(Long id);
}
