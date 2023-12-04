package com.example.dw.service;

import com.example.dw.entity.dto.FreeBoardWritingForm;
import com.example.dw.entity.dto.freeBoardDto.FreeBoardDto;
import com.example.dw.entity.freeBoard.FreeBoard;
import com.example.dw.repository.FreeBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FreeBoardService {

    private final FreeBoardRepository freeBoardRepository;

    //전체 조회
    public List<FreeBoard> getFreeBoardList(){
        List<FreeBoard> freeBoards = freeBoardRepository.findAll();
        return freeBoards;
    }

    //글쓰기
    @Transactional
    public void saveFreeBoard(FreeBoardWritingForm freeBoardWritingForm){
        freeBoardRepository.save(freeBoardWritingForm.toEntity());
    }
}
