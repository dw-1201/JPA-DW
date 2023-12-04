package com.example.dw.service;

import com.example.dw.entity.dto.FreeBoardWritingForm;
import com.example.dw.entity.freeBoard.FreeBoard;
import com.example.dw.repository.FreeBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FreeBoardService {

    private final FreeBoardRepository freeBoardRepository;

    public List<FreeBoard> search(String keyword){
        List<FreeBoard> freeBoardLists = freeBoardRepository.findByFreeBoardTitleContainingOrFreeBoardContentContaining(keyword, keyword);
        return freeBoardLists;
    }

    @Transactional
    public void saveFreeBoard(FreeBoardWritingForm freeBoardWritingForm){
        freeBoardRepository.save(freeBoardWritingForm.toEntity());
    }
}
