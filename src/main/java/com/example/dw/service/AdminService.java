package com.example.dw.service;


import com.example.dw.entity.admin.FaqBoard;
import com.example.dw.entity.admin.NoticeBoard;
import com.example.dw.entity.dto.FaqBoardForm;
import com.example.dw.entity.dto.NoticeBoardForm;
import com.example.dw.entity.dto.admin.FaqBoardDto;
import com.example.dw.repository.FaqBoardRepository;
import com.example.dw.repository.NoticeBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminService {

    private final NoticeBoardRepository noticeBoardRepository;
    private final FaqBoardRepository faqBoardRepository;


    //공지사항 작성
    public Long register(NoticeBoardForm noticeBoardForm){

         NoticeBoard noticeBoard = noticeBoardRepository.save(noticeBoardForm.toEntity());

         return noticeBoard.getId();

    }

    //Faq 작성
    public Long faqRegister(FaqBoardForm faqBoardForm){

        FaqBoard faqBoard = faqBoardRepository.save(faqBoardForm.toEntity());

        return faqBoard.getId();
    }
    
    //Faq 조회
    public List<FaqBoard> faqList(){
        List<FaqBoard> list = faqBoardRepository.findAll();
        return list;
    }


}
