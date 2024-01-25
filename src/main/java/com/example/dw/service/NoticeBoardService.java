package com.example.dw.service;

import com.example.dw.repository.admin.NoticeBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class NoticeBoardService {

    private final NoticeBoardRepository noticeBoardRepository;

    //공지사항 조회수
    public void increaseViewCount(Long noticeBoardId){
        noticeBoardRepository.increaseViewCount(noticeBoardId);
    }
}
