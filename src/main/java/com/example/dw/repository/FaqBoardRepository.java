package com.example.dw.repository;

import com.example.dw.entity.admin.FaqBoard;
import com.example.dw.entity.dto.admin.FaqBoardDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FaqBoardRepository extends JpaRepository<FaqBoard, Long> {


}
