package com.example.dw.service;

import com.example.dw.domain.entity.freeBoard.FreeBoard;
import com.example.dw.domain.entity.user.Users;
import com.example.dw.domain.form.FreeBoardWritingForm;
import com.example.dw.repository.UsersRepository;
import com.example.dw.repository.freeBoard.FreeBoardRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FreeBoardService {

    private final FreeBoardRepository freeBoardRepository;
    private final UsersRepository usersRepository;
    private final HttpSession httpSession;

    //전체 조회
    public List<FreeBoard> getFreeBoardList(){
        System.out.println("=============");
        List<FreeBoard> freeBoards = freeBoardRepository.findAll();
        System.out.println(freeBoards +"-----------");
        return freeBoards;
    }

    //글쓰기
    @Transactional
    public Long saveFreeBoard(FreeBoardWritingForm freeBoardWritingForm){
        // 세션에서 사용자 ID 가져오기
        Long userId = (Long) httpSession.getAttribute("userId");

        // 해당 사용자 ID로 Users 엔티티 가져오기
        Users user = usersRepository.findById(userId).orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));

        // FreeBoard 엔티티 생성 및 Users 엔티티 설정
        FreeBoard freeBoard = FreeBoard.builder()
                .freeBoardTitle(freeBoardWritingForm.getFreeBoardTitle())
                .freeBoardContent(freeBoardWritingForm.getFreeBoardContent())
                .users(user)
                .build();

        FreeBoard savedFreeBoard = freeBoardRepository.save(freeBoard);
        return savedFreeBoard.getId();
    }
}
