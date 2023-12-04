package com.example.dw.service;


import com.example.dw.entity.admin.NoticeBoard;
import com.example.dw.entity.dto.NoticeBoardForm;
import com.example.dw.repository.NoticeBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminService {

    private final NoticeBoardRepository noticeBoardRepository;



    //공지사항 작성
    public Long register(NoticeBoardForm noticeBoardForm){

         NoticeBoard noticeBoard = noticeBoardRepository.save(noticeBoardForm.toEntity());

         return noticeBoard.getId();

    }


}
