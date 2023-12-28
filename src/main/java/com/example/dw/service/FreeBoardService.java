package com.example.dw.service;

import com.example.dw.domain.entity.freeBoard.FreeBoard;
import com.example.dw.domain.entity.user.Users;
import com.example.dw.domain.form.FreeBoardModifyForm;
import com.example.dw.domain.form.FreeBoardWritingForm;
import com.example.dw.repository.freeBoard.FreeBoardCommentRepository;
import com.example.dw.repository.freeBoard.FreeBoardRepository;
import com.example.dw.repository.user.UsersRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FreeBoardService {

    private final FreeBoardRepository freeBoardRepository;
    private final UsersRepository usersRepository;
    private final HttpSession httpSession;
    private final FileService fileService;
    private final FreeBoardCommentRepository freeBoardCommentRepository;


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

    //글 수정
    @Transactional
    public FreeBoard modify(FreeBoardModifyForm freeBoardModifyForm)
            throws IOException {
        Long freeBoardId = freeBoardModifyForm.getId();
        FreeBoard freeBoard = freeBoardRepository.findById(freeBoardModifyForm.getId()).get();

        //자유게시판 기본 내용 업데이트
        freeBoard.update(freeBoardModifyForm);

        return Optional.ofNullable(freeBoard).orElseThrow(()->{
            throw new IllegalArgumentException("조회 정보 없음");
        });
    }

    //자유게시판 글삭제
    @Transactional
    public void delete(Long freeBoardId){

        if (freeBoardId == null) {

            throw new IllegalArgumentException("유효하지 않은 번호");
        }

//        fileService.removeMainImg(freeBoardId);
//        fileService.removeDetailImgs(freeBoardId);

        freeBoardRepository.deleteById(freeBoardId);
    }

    //자유게시판 조회수
    @Transactional
    public void increaseViewCount(Long freeBoarId){
        freeBoardRepository.increaseViewCount(freeBoarId);
    }

    // 게시물의 댓글 수 조회
    public Long countCommentsByFreeBoardId(Long freeBoardId) {
        return freeBoardCommentRepository.countCommentsByFreeBoardId(freeBoardId);
    }

}
